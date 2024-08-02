package com.hsu.wetalkportal.entity.token;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TokenData {
    /** 用户ID */
    @NotNull(message = "ID cannot be null")
    private String userId;
    /**用户密码*/
    @NotNull
    private String password;
    /** 用户登录机构ID */
    private Long organizationId;
    /**
     * 业务类型参数
     */
    /** appId */
    private String userName;


    /**
     * 业务类型参数
     */
    /** appId */
    private String appId;

}
