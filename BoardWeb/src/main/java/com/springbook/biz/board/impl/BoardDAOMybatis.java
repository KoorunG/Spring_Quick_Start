package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis /* extends SqlSessionDaoSupport */ {
	

//	SqlSessionDaoSupport를 상속 한 후 setSqlSessionFactory를 재정의함
//	재정의한 setSqlSessionFactory 위에 @Autowired를 붙였기 때문에 스프링 컨테이너가 setSqlSessionFactory 메소드를 자동으로 호출함
//	이때 스프링 설정 파일 (applicationContext.xml)에 <bean> 등록된 setSqlSessionFactoryBean 객체를 인자로 받아 
//	부모인 SqlSessionDaoSupportd에 setSqlSessionFactory 메소드로 설정해줌
	
	
//	setter 주입
//	@Autowired
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		super.setSqlSessionFactory(sqlSessionFactory);
//	}

	private SqlSessionTemplate mybatis;
	
	// 생성자 주입
	@Autowired
	public BoardDAOMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("==> Mybatis로 insertBoard() 기능 처리");
//		SqlSessionDaoSupport 클래스로부터 상속된 getSqlSession 메소드를 호출하여 
//		SqlSession 객체를 리턴 받아서 SQL문을 처리한다
		
//		getSqlSession().insert("BoardDAO.insertBoard", vo);
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("==> Mybatis로 updateBoard() 기능 처리");
//		getSqlSession().update("BoardDAO.updateBoard", vo);
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void updateCnt(BoardVO vo) {
		System.out.println("==> Mybatis로 updateCnt() 기능 처리");
//		getSqlSession().update("BoardDAO.updateCnt", vo);
		mybatis.update("BoardDAO.updateCnt", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> Mybatis로 deleteBoard() 기능 처리");
//		getSqlSession().delete("BoardDAO.deleteBoard", vo);
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> Mybatis로 getBoard() 기능 처리");
//		return (BoardVO)getSqlSession().selectOne("BoardDAO.getBoard",vo);
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("==> Mybatis로 getBoardList() 기능 처리");
//		return getSqlSession().selectList("BoardDAO.getBoardList", vo);
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}
