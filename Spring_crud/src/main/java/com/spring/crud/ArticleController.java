package com.spring.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

	@RequestMapping
	public String insert(ArticleVO vo) {
		return null;
	}
	
	@RequestMapping("/article/read.do")
	public String selectById(@ModelAttribute("articleData") ArticleVO vo) {
		
		return "/WEB-INF/view/readArticle.jsp";
	}
}
