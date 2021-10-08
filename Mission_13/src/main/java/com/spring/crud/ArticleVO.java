package com.spring.crud;

public class ArticleVO {
	
	private String title;
	private String content;
	
	public ArticleVO(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
}