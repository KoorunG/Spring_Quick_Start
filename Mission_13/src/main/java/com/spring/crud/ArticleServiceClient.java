package com.spring.crud;

//import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ArticleServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		ArticleService articleService = container.getBean("articleService", ArticleService.class);
		
		ArticleVO vo = new ArticleVO("안녕하세요","반갑습니다");
		
		articleService.insert(vo);
		container.close();
	}
}
