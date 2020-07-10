package com.kxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kxy.common.RoleEnum;
import com.kxy.factoty.FactoryManageBean;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = { "com.kxy.mapper" })
public class TsetDemo01Application implements ApplicationRunner{

	@Autowired
	private FactoryManageBean factoryManageBean;
	
	public static void main(String[] args) {
//		try {
//			RoleEnum.valueOf("role_root_admin").op();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		SpringApplication.run(TsetDemo01Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		factoryManageBean.getBean("bird").eat();
		
	}


}
