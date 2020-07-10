package com.hy.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Terry
 * @since 2019-05-23
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nickname;
    private String password;
    private String email;
    private Integer userface;
    private String username;
    private String date;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserface() {
        return userface;
    }

    public void setUserface(Integer userface) {
        this.userface = userface;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", nickname=" + nickname +
        ", password=" + password +
        ", email=" + email +
        ", userface=" + userface +
        ", username=" + username +
        ", date=" + date +
        "}";
    }
}
