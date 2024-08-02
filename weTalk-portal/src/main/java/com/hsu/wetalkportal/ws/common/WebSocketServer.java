package com.hsu.wetalkportal.ws.common;


import com.alibaba.fastjson.JSONObject;

import com.hsu.wetalkportal.entity.token.TokenData;
import com.hsu.wetalkportal.utils.JWTUtil;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;


@ServerEndpoint("/ws/zhimoyanzhu")
@Component
@Slf4j
@EqualsAndHashCode
public class WebSocketServer {
    private static int onLineCount = 0;//记录在线连接数，应该做成线程安全的

    //线程安全set,用来存储每个客户的WebSocketServer对象
    private static CopyOnWriteArraySet<WebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();

    //与某个客户端的连接会话，需要通过它来给客户发送数据
    private Session session;

    private Map<String, Object> userSession = new HashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        TokenData tokenData = JWTUtil.getTokenData(session.getQueryString());
        System.out.println("用户Id:"+tokenData.getUserId()+"登录");
        this.session = session;
        webSocketServers.add(this);
        addOnlineCount();
        userSession.put(tokenData.getUserId().toString(),this.session.getId());
        System.out.println("当前在线人数为：" + getOnLineCount());
    }


    @OnClose
    public void onClose(Session session) {
        webSocketServers.remove(this);
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnLineCount());
    }



    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息：" + message);
        JSONObject jsonObject = JSONObject.parseObject(message);
        String  toUser =  jsonObject.getString("toUser");
        for (WebSocketServer socket : webSocketServers) {
            try {
                if (socket.session.isOpen()){
                    if (socket.session.getId().equals(socket.userSession.get(toUser))){
                        socket.sendMessage(jsonObject.getString("msg"));
                        System.out.println("发送成功");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }


    public void sendMessage(String message) throws IOException {
        log.info("发送消息：" + message);
        this.session.getBasicRemote().sendText(message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发送消息失败");
        error.printStackTrace();
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onLineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onLineCount--;
    }

    public static synchronized int getOnLineCount() {
        return onLineCount;
    }

}

