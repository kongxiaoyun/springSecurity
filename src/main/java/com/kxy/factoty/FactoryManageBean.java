package com.kxy.factoty;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class FactoryManageBean {
	static Map<String,Animal> map = new HashMap<String,Animal>();
	
	static {
		map.put("bird", new Bird());
		map.put("fish", new Fish());
	}
	
	public static Animal getBean(String beanName) {
		return map.get(beanName);
	}
}
