package com.hsu.wetalkportal.web.service;


import com.hsu.wetalkportal.entity.param.UserInfoQueryParam;
import com.hsu.wetalkportal.entity.vo.UserInfoVo;

import java.util.List;

public interface UserService {
    UserInfoVo getUserListByUuid(UserInfoQueryParam userInfoQueryParam);

    List<UserInfoVo> getUserListByUserName(UserInfoQueryParam userInfoQueryParam);

    UserInfoVo getUserInfoByUserId(String userId);

}
