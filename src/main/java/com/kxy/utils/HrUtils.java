package com.kxy.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.kxy.entity.User;

/**
 * Created by sang on 2017/12/30.
 */
public class HrUtils {
    public static User getCurrentHr() {
    	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	user.setPassword("");
        return user;
    }
}
