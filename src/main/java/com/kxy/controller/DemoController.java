package com.kxy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {
	
	@RequestMapping("/test")
	public String test() {
		return "session 过期";
	}

}
