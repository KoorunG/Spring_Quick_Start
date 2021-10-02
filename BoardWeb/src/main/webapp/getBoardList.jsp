<%@page import="com.springbook.biz.board.impl.BoardDAOSpring"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
		List<BoardVO> boardList = (List) session.getAttribute("boardList");
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<style>
* {
	margin: 0 auto;
	padding: 0;
	list-style: none;
	font-family: "맑은 고딕";
}

.center-text {
	text-align: center;
}
</style>
</head>
<body>
	<div class="center-text">
	<h1>글 목록</h1>
	<br>
	<h3>테스트님 환영합니다...<a href="logout_proc.jsp">Log-out</a></h3>
	</div>
	<!-- 검색 시작 -->
	<form action="getBoardList.jsp" method="post" style="margin-top : 10px">
		<table border="1" cellpadding="0" celllspacing="0" width="700">
		<tr>
		<td align="right">
			<select name="searchCondition">
			<option value="TITLE">제목
			<option value="CONTENT">내용
			</select>
			<input name="searchKeyword" type="text"/>
			<input type="submit" value="검색"/>
		</td>
		</tr>
		</table>
	</form>
	
	<!-- 검색 종료 -->
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<th style="background-color:orange" width="100">번호</th>
		<th style="background-color:orange" width="200">제목</th>
		<th style="background-color:orange" width="150">작성자</th>
		<th style="background-color:orange" width="150">등록일</th>
		<th style="background-color:orange" width="100">조회수</th>
	</tr>
	<% for(BoardVO board : boardList) { %>
	<tr>
		<td><%= board.getSeq() %></td>
		<td align="left"><a href="getBoard.do?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
		<td><%= board.getWriter() %></td>
		<td><%= board.getRegDate() %></td>
		<td><%= board.getCnt() %></td>
	</tr>
	<% } %>
	</table>
	<br>
	<div class="center-text">
	<a href="insertBoard.jsp">새글 등록</a>
	</div>
</body>
</html>