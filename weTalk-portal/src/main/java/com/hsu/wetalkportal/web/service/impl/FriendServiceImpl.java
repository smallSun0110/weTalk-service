package com.hsu.wetalkportal.web.service.impl;

import com.hsu.wetalkportal.entity.token.TokenData;
import com.hsu.wetalkportal.entity.vo.FriendInfoVo;
import com.hsu.wetalkportal.web.mapper.FriendMapper;
import com.hsu.wetalkportal.web.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Override
    public List<FriendInfoVo> list(TokenData tokenData) {
        return friendMapper.list(tokenData);
    }

    @Override
    public List<FriendInfoVo> getFriendRequestList(TokenData tokenData) {
        return friendMapper.getFriendRequestList(tokenData);
    }

    @Override
    public void addFriend(TokenData tokenData, String userId) {
//        friendMapper.addFriend(tokenData, userId);
//        friendMapper.addFriend( )
    }
}
