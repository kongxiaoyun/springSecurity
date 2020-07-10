package com.kxy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kxy.entity.Role;
import com.kxy.entity.User;
import com.kxy.entity.UserInfo;
import com.kxy.filter.LoginInterceptor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 //从数据库查询用户信息
        User user = userService.getUser(username);
        if (user == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        //查询权限信息
//        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(userInfo.getRoles());
        //返回Spring Security框架提供的User或者自定义的MyUser（implements UserDetails）
        ////        return new MyUser(username, userInfo.getPassword(), simpleGrantedAuthorities);
//        return new User(username, userInfo.getPassword(), simpleGrantedAuthorities);
        List<Role> list = new ArrayList<Role>();
        list.add(new Role("admin"));
        user.setRoles(list);
        String encode = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encode);//放入密码用于和页面参数密码做比较
        user.setEnabled(true);
        return user;
		
		
//		logger.info("用户的用户名: {}", username);
//        // TODO 根据用户名，查找到对应的密码，与权限
//
//        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
//        String encode = new BCryptPasswordEncoder().encode("123456");
//        //123456   "$2a$10$rE5.RvkHaB06t.9GjGeaW.jNHysRQpBXObl3ZSahzBesfq7tAkX56"
//        User user = new User(username, encode,
//                Arrays.asList(new Role("admin")));
//        user.setEnabled(true);
//        return user;
	}
	
	/**
     * 权限字符串转化
     *
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     *
     * @param roleStr 权限字符串
     */
    private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }

}
