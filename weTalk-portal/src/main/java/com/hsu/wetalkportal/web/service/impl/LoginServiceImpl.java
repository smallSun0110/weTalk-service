package com.hsu.wetalkportal.web.service.impl;


import com.hsu.wetalkportal.entity.token.TokenData;
import com.hsu.wetalkportal.web.mapper.LoginMapper;
import com.hsu.wetalkportal.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public TokenData login(String userName, String password) {
        return loginMapper.login(userName,password);
    }
}
