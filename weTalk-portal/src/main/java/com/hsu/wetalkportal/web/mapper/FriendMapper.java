package com.hsu.wetalkportal.web.mapper;

import com.hsu.wetalkportal.entity.token.TokenData;
import com.hsu.wetalkportal.entity.vo.FriendInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FriendMapper {
    @Select("select * from friend_info a left join user_info b on a.friend_id = b.user_id  where a.user_id = #{userId} and status = 1")
    List<FriendInfoVo> list(TokenData tokenData);
    @Select("select * from friend_info a left join user_info b on a.friend_id = b.user_id  where a.friend_id = #{userId} and status = 0")
    List<FriendInfoVo> getFriendRequestList(TokenData tokenData);
}
