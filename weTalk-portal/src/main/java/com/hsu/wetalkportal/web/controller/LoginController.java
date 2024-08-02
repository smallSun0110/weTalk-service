package com.hsu.wetalkportal.web.controller;


import com.hsu.wetalkportal.config.OpLog;
import com.hsu.wetalkportal.constant.WebConstant;
import com.hsu.wetalkportal.entity.token.TokenData;
import com.hsu.wetalkportal.utils.JWTUtil;
import com.hsu.wetalkportal.utils.WebUtil;
import com.hsu.wetalkportal.web.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller("/zhimoyanzhu")
@ResponseBody
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;


    @OpLog(operDesc = "登录", operType = "登录", opModule = "1")
    @PostMapping("/login")
    public WebUtil login(@Valid @RequestBody TokenData tokenData){
       String token =  JWTUtil.createToken(tokenData,2022200);
        TokenData  tokenData1 = loginService.login(tokenData.getUserId(),tokenData.getPassword());
        if (tokenData1 != null){
            return WebUtil.success(token);
        }else {
            return WebUtil.warn(WebConstant.ACCOUNT_OR_PWD_NULL);
        }
    }

}
