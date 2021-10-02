<%@page import="com.springbook.biz.board.impl.BoardDAOSpring"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	boardDAO.insertBoard(vo);
	
	// 3. 화면 내비게이션
	response.sendRedirect("getBoardList.jsp");
%>