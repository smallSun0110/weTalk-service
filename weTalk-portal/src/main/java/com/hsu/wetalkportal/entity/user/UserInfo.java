package com.hsu.wetalkportal.entity.user;

import lombok.Data;

@Data
public class UserInfo {
    private Long uuid;
    private Long userId;
    private String password;
}
