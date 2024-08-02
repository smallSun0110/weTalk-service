package com.hsu.wetalkportal.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.hsu.wetalkportal.constant.WebConstant;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhouxq
 * @date 2019/7/25
 */
@Data
@Slf4j
public class WebUtil {

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回内容
     */
    private String msg;

    /**
     * 数据对象
     */
    private Object data;

    public WebUtil() {
    }

    public WebUtil(WebConstant webConstant, Object data) {
        this.code = webConstant.getCode();
        this.msg = webConstant.getMsg();
        this.data = data;
    }

    public WebUtil(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static WebUtil success() {
//        log.info("response：{}--->{}", WebConstant.SUCCESS.getCode(), WebConstant.SUCCESS.getMsg());
        return new WebUtil(WebConstant.SUCCESS, null);
    }

    /**
     * 返回成功消息
     *
     * @param data 数据对象
     * @return 成功消息
     */
    public static WebUtil success(Object data) {
        //log.info("response：{}--->{}---->{}", WebConstant.SUCCESS.getCode(), WebConstant.SUCCESS.getMsg(), data);
        return new WebUtil(WebConstant.SUCCESS, data);
    }

    public static WebUtil successImport(String msg) {
        //log.info("response：{}--->{}---->{}", WebConstant.SUCCESS.getCode(), WebConstant.SUCCESS.getMsg(), data);
        return new WebUtil(0,  msg,  msg);
    }



    /**
     * 返回错误消息
     *
     * @return 成功消息
     */
    public static WebUtil error() {
//        log.error("response：{}--->{}", WebConstant.ERROR.getCode(), WebConstant.ERROR.getMsg());
        return new WebUtil(WebConstant.ERROR, null);
    }

    /**
     * 返回错误消息
     *
     * @return 成功消息
     */
    public static WebUtil error(String  msg) {
//        log.error("response：{}--->{}", WebConstant.ERROR.getCode(), WebConstant.ERROR.getMsg());
        return new WebUtil(WebConstant.ERROR1.getCode(), msg, null);
    }


    /**
     * 非正常情况
     *
     * @return 成功消息
     */
    public static WebUtil warn(WebConstant webConstant) {
//        log.warn("response：{}--->{}", webConstant.getCode(), webConstant.getMsg());
        return warn(webConstant, null);
    }

    /**
     * 非正常情况
     *
     * @return 成功消息
     */
    public static WebUtil warn(int code, String msg) {
//        log.warn("response：{}--->{}", code, msg);
        return new WebUtil(code, msg, null);
    }

    /**
     * 非正常情况（带数据返回）
     *
     * @return 成功消息
     */
    public static WebUtil warn(WebConstant webConstant, Object data) {
        return new WebUtil(webConstant, data);
    }
    public static void common(WebConstant webConstant, HttpServletResponse response, String... args) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ret_code",webConstant.getCode());
        jsonObject.put("ret_msg", webConstant.getMsg());
        returnMsg(jsonObject,response);
    }
    /**
     * 统一的返回方法
     * @param json
     * @param response
     * @throws IOException
     */
    public static void returnMsg(JSONObject json, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(json.toString());
        writer.close();
    }
    /**
     * 附加msg信息的返回 带数据
     * msg附加到webConstant的msg后面
     *
     * @return 成功消息
     */
    public static WebUtil warn(WebConstant webConstant, Object data, String msg) {
        WebUtil webUtil = new WebUtil();
        webUtil.setCode(webConstant.getCode());
        webUtil.setData(data);
        webUtil.setMsg(webConstant.getMsg() + msg);
        return webUtil;
    }

    public static WebUtil warnFormatMsg(WebConstant webConstant, String msg) {
//        log.warn("response：{}--->{}", webConstant.getCode(), webConstant.getMsg());
        WebUtil webUtil = new WebUtil();
        webUtil.setCode(webConstant.getCode());
        webUtil.setMsg(String.format(webConstant.getMsg(), msg));
        return webUtil;
    }

    /**
     * 附加msg信息的返回
     * msg附加到webConstant的msg后面
     *
     * @return 成功消息
     */
    public static WebUtil warnMsg(WebConstant webConstant, String msg) {
        return warn(webConstant, null, msg);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == WebConstant.SUCCESS.getCode();
    }


    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    public static WebUtil toAjax(int rows) {
        return rows > 0 ? success() : error();
    }

}
