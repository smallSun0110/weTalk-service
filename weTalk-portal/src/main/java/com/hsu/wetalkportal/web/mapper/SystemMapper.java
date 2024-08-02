package com.hsu.wetalkportal.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SystemMapper {
    @Select("select config_value from system_info where config_id = 1")
     String getIp();
}
