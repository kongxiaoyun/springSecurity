package com.kxy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxy.entity.R;

@RestController
@RequestMapping("/login")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	//当登录成功之后，可以调用下面的接口
	@RequestMapping("/getInfo")
	public R getUserInfo(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") Integer password) {
		logger.info("username---"+username+"-------password"+password);
		return R.ok().put("kxy", "你好");
	}
}
