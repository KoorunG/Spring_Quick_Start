package com.spring.crud.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.crud.ArticleVO;

@Repository
public class ArticleDAO {
	
	// 마이바티스 템플릿
	private SqlSessionTemplate mybatis;
	private ArticleVO articleVO;

	public ArticleDAO() {}
	
	// 생성자 주입
	@Autowired
	public ArticleDAO(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	public ArticleVO getArticleVO() {
		return articleVO;
	}

	public void insert(ArticleVO vo) {
		mybatis.insert("ArticleDAO.insert", vo);
	}
	
	public ArticleVO selectById(ArticleVO vo) {
		return mybatis.selectOne("ArticleDAO.selectById",vo);
	}

	public void update(ArticleVO vo) {
		mybatis.update("ArticleDAO.update", vo);
	}

	public void delete(ArticleVO vo) {
		mybatis.delete("ArticleDAO.delete", vo);
	}
	
}
