package com.hsu.wetalkportal.web.service.impl;


import com.hsu.wetalkportal.entity.param.UserInfoQueryParam;
import com.hsu.wetalkportal.entity.vo.UserInfoVo;
import com.hsu.wetalkportal.web.mapper.UserMapper;
import com.hsu.wetalkportal.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserInfoVo getUserListByUuid(UserInfoQueryParam userInfoQueryParam) {
        return userMapper.getUserListByUuid(userInfoQueryParam.getUuid());
    }

    @Override
    public List<UserInfoVo> getUserListByUserName(UserInfoQueryParam userInfoQueryParam) {
        return userMapper.getUserListByuserName(userInfoQueryParam.getUserName());
    }

    @Override
    public UserInfoVo getUserInfoByUserId(String userId) {
        return userMapper.getUserInfoByUserId(userId);
    }


}
