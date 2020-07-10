package com.kxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kxy.entity.User;
import com.kxy.mapper.UserMapper;
import com.kxy.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserMapper useMapper;

	@Override
	public boolean insert(User userInfo) {
		encryptPassword(userInfo);
        if(useMapper.insert(userInfo)==1)
            return true;
        else
            return false;
	}

	@Override
	public void encryptPassword(User userInfo){
        String password = userInfo.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userInfo.setPassword(password);
    }
	
	public User getUser(String username) {
		return useMapper.getUserInfo(username);
	}
}
