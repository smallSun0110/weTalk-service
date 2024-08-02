package com.hsu.wetalkportal.web.controller.user;

import com.hsu.wetalkportal.entity.param.UserInfoQueryParam;
import com.hsu.wetalkportal.entity.token.TokenData;
import com.hsu.wetalkportal.entity.vo.UserInfoVo;
import com.hsu.wetalkportal.utils.JWTUtil;
import com.hsu.wetalkportal.utils.WebUtil;
import com.hsu.wetalkportal.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/list")
    public WebUtil list(@Valid @RequestBody UserInfoQueryParam userInfoQueryParam) {
        if (userInfoQueryParam.getUserName().isEmpty()&&userInfoQueryParam.getUuid().isEmpty()){
            return WebUtil.success();
        }
       if (!userInfoQueryParam.getUserName().isEmpty()){
           return WebUtil.success(userService.getUserListByUserName(userInfoQueryParam));
       }
       if (!userInfoQueryParam.getUuid().isEmpty()){
           UserInfoVo list = userService.getUserListByUuid(userInfoQueryParam);
           userInfoQueryParam.setUserName(userInfoQueryParam.getUserName());
           List<UserInfoVo> list1 = userService.getUserListByUserName(userInfoQueryParam);
           Map<String,Object> map = new HashMap<>();
           map.put("uuidObj",list);
           map.put("nameList",list1);
           return WebUtil.success(map);
       }
       return WebUtil.error();
    }
    /**
     * 获取个人信息
     */
    @PostMapping("/getUserInfoByUserId")
    public WebUtil getUserInfoByUserId(@Valid @RequestBody String userId) {
        return WebUtil.success(userService.getUserInfoByUserId(userId));
    }
    /**
     * 根据token获取个人信息
     */
    @PostMapping("/getUserInfoByToken")
    public WebUtil getUserInfoByToken(@Valid @RequestBody String token) {
        TokenData tokenData = JWTUtil.getTokenData(token);
        return WebUtil.success(userService.getUserInfoByUserId(tokenData.getUserId()));
    }
}
