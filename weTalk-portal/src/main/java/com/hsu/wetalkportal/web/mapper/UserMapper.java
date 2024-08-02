package com.hsu.wetalkportal.web.mapper;


import com.hsu.wetalkportal.entity.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    @Select("select * from user_info where user_name like CONCAT('%',#{userName},'%')")
    List<UserInfoVo> getUserListByuserName(String userName);

    @Select("select * from user_info where uuid = #{uuid}")
    UserInfoVo getUserListByUuid(String uuid);

    @Select("select * from user_info where user_id = #{userId}")
    UserInfoVo getUserInfoByUserId(String userId);
}
