package com.hsu.wetalkportal.web.service;


import com.hsu.wetalkportal.entity.token.TokenData;

public interface LoginService {
     TokenData login(String userName, String password);
}
