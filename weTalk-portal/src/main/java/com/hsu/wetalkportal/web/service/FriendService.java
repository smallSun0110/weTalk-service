package com.hsu.wetalkportal.web.service;



import com.hsu.wetalkportal.entity.token.TokenData;
import com.hsu.wetalkportal.entity.vo.FriendInfoVo;

import java.util.List;

public interface FriendService {
    List<FriendInfoVo> list(TokenData tokenData);

    List<FriendInfoVo> getFriendRequestList(TokenData tokenData);

    void addFriend(TokenData tokenData, String userId);
}
