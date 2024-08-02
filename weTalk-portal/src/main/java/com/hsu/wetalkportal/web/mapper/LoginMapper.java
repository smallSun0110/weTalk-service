package com.hsu.wetalkportal.web.mapper;

import com.hsu.wetalkportal.entity.token.TokenData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface LoginMapper {
    @Select("select * from user_info where user_id = #{username} and password = #{password}")
    TokenData login(String username, String password);

}
