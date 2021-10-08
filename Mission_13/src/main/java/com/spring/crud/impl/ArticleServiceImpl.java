package com.spring.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.ArticleService;
import com.spring.crud.ArticleVO;


@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Override
	public void selectById(ArticleVO vo) {
		articleDao.selectById(vo);
	}

	@Override
	public void insert(ArticleVO vo) {
		articleDao.insert(vo);
	}

	@Override
	public void update(ArticleVO vo) {
		articleDao.update(vo);
	}

	@Override
	public void delete(ArticleVO vo) {
		articleDao.delete(vo);
	}
}
