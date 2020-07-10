package com.kxy.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Table(name="user")
public class User implements Serializable,UserDetails{
	
	public User(String id,String username,String password,String nickname,Integer userface,String email,String date) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.userface = userface;
		this.date = date;
	}
	private static final long serialVersionUID = 1L;
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private String id;
	   
	   /**
	     * 用户名称
	     */
	   @Column(name = "username")
	   private String username;
	    
	    /**
	     * 密码
	     */
	   @Column(name = "password")
	   private String password;
	   
	   /**
	     * 昵称
	     */
	   @Column(name = "nickname")
	   private String nickname;
	   
	   private boolean enabled = false;
	   
	   private List<Role> roles;
	   
	   /**
	     * 邮箱
	     */
	   @Column(name = "email")
	   private String email;
	   
	   /**
	     * 邮箱
	     */
	   @Column(name = "userface")
	   private Integer userface;
	   
	   /**
	     * 时间
	     */
	   @Column(name = "date")
	   private String date;

	   @Override
	   @JsonIgnore
	   public boolean isAccountNonExpired() { // 帐户是否过期
	       return true;
	   }

	   @Override
	   @JsonIgnore
	   public boolean isAccountNonLocked() { // 帐户是否被冻结
	       return true;
	   }

	    // 帐户密码是否过期，一般有的密码要求性高的系统会使用到，比较每隔一段时间就要求用户重置密码
	   @Override
	   @JsonIgnore
	   public boolean isCredentialsNonExpired() { 
	       return true;
	   }

	   @Override
	   public boolean isEnabled() {  // 帐号是否可用
	       return enabled;
	   }

	   public void setEnabled(boolean enabled) {
	       this.enabled = enabled;
	   }

	   @Override
	   @JsonIgnore
	   public List<GrantedAuthority> getAuthorities() {
	       List<GrantedAuthority> authorities = new ArrayList<>();
	       for (Role role : roles) {
	           authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
	       }
	       return authorities;
	   }


	    public User(String username, String password, List<Role> roles) {
	        this.username = username;
	        this.password = password;
	        this.roles = roles;
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
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

		public String getDate() {
			return date;
		}

		public void setRegTime(String date) {
			this.date = date;
		}


}
