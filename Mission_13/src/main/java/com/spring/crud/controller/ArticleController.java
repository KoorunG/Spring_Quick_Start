package com.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.crud.dao.ArticleDao;
import com.spring.crud.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/insert.do")
	public String insert(ArticleDao articleDao) {
		articleService.insert(articleDao.get);
		return "/WEB-INF/view/newArticleSuccess.jsp";
	}
}
