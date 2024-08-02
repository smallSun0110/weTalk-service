package com.hsu.wetalkportal.web.service.impl;


import com.hsu.wetalkportal.web.mapper.SystemMapper;
import com.hsu.wetalkportal.web.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl  implements SystemService {
    @Autowired
    private SystemMapper systemMapper;

    @Override
    public String getIp() {
        return systemMapper.getIp();
    }
}
