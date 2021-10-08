package com.spring.crud;

import com.spring.crud.impl.ArticleDAO;

public class ArticleData {
	
	public ArticleVO convertArticle(ArticleDAO articleDAO) {
		
		ArticleVO result = new ArticleVO();
		result.setTitle(articleDAO.getArticleVO().getTitle());
		result.setContent(articleDAO.getArticleVO().getContent());
		return result;
		
	}
}
