package com.kxy;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.kxy.entity.UserInfo;
import com.kxy.tk.TkMapper;
@Mapper
@Component
//此类无用，在于去除启动警告信息
public interface DefaultMapper extends TkMapper<UserInfo>{

}
