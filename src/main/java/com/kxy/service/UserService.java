package com.kxy.service;


import com.kxy.entity.User;



public interface UserService {

    public boolean insert(User userInfo);

    public void encryptPassword(User userInfo);
    
    public User getUser(String username);
}
