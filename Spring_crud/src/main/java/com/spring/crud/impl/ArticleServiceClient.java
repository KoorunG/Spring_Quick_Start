package com.spring.crud.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.crud.ArticleService;
import com.spring.crud.ArticleVO;

public class ArticleServiceClient {
	
public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		ArticleService articleService = container.getBean("articleService", ArticleService.class);
		
		ArticleDAO dao = new ArticleDAO();
//		ArticleVO vo = new ArticleVO();
//		vo.setTitle("쿠렁");
//		vo.setContent("테스트5");
		
//		articleService.insert(vo);
		ArticleVO article = articleService.selectById(dao.getArticleVO());
		System.out.println(article.getTitle() + article.getContent());
		container.close();
	}

}
