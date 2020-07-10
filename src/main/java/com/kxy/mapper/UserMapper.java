package com.kxy.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kxy.entity.User;
import com.kxy.tk.TkMapper;
@Mapper
@Component
public interface UserMapper extends TkMapper<User>{

	User getUserInfo(@Param("name") String name);
}
