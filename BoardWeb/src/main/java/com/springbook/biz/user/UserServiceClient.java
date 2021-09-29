package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContextBusiness.xml");
		UserService userService = container.getBean("userService", UserService.class);
		
		UserVO user = null;
		
		UserVO vo = new UserVO();
		vo.setId("koorung");
		vo.setPassword("koorung");
		
		user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다!");
		} else {
			System.out.println("로그인 실패!");
		}
	
		container.close();
		
	}
}
