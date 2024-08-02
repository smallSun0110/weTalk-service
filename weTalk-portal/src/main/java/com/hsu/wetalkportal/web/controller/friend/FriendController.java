package com.hsu.wetalkportal.web.controller.friend;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import com.hsu.wetalkportal.entity.token.TokenData;
import com.hsu.wetalkportal.entity.vo.FriendInfoVo;
import com.hsu.wetalkportal.entity.vo.UserInfoVo;
import com.hsu.wetalkportal.utils.JWTUtil;
import com.hsu.wetalkportal.utils.QrcodeUtils;
import com.hsu.wetalkportal.utils.WebUtil;
import com.hsu.wetalkportal.web.service.FriendService;
import com.hsu.wetalkportal.web.service.SystemService;
import com.hsu.wetalkportal.web.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private UserService userService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private SystemService systemService;
    @GetMapping("/list")
    public WebUtil list(@RequestHeader("authorization") String token) {
        TokenData tokenData = JWTUtil.getTokenData(token);
      List<FriendInfoVo> list=  friendService.list(tokenData);
        return WebUtil.success(list);
    }
    /**
     * 生成二维码
     */
    @PostMapping("/qrcode")
    public WebUtil qrcode(@RequestHeader("authorization") String token) throws WriterException, IOException {
        Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        String ip = systemService.getIp();
        TokenData tokenData = JWTUtil.getTokenData(token);
        String data = "http://" + ip + "/me?userId=" +tokenData.getUserId();
        byte[]a =  QrcodeUtils.getQRCodeImage(data, 300, 300);
        //转图片的base64
        String base64 = Base64.encodeBase64String(a);
        return WebUtil.success(base64);
    }
    @GetMapping("/getUserInfo")
    public WebUtil getUserInfo(@RequestParam("userId") String userId) {
        UserInfoVo userInfoVo = userService.getUserInfoByUserId(userId);
        return WebUtil.success(userInfoVo);
    }
    /**
     * 获取好友请求列表
     */
    @GetMapping("/getFriendRequestList")
    public WebUtil getFriendRequestList(@RequestHeader("authorization") String token) {
        TokenData tokenData = JWTUtil.getTokenData(token);
        List<FriendInfoVo> list = friendService.getFriendRequestList(tokenData);
        return WebUtil.success(list);
    }
    @PostMapping("/addFriend")
    public WebUtil addFriend(@RequestHeader("authorization") String token,@RequestBody String userId) {
        TokenData tokenData = JWTUtil.getTokenData(token);
        friendService.addFriend(tokenData, userId);
        return WebUtil.success();
    }
}
