<%@page import="com.springbook.biz.board.impl.BoardDAOSpring"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	<h1><spring:message code="message.board.list.mainTitle"/></h1>
	<br>
	<!-- 세션에서 id를 얻어옴 -->
	<h3>${userName}<spring:message code="message.board.list.welcomeMsg"/>   <a href="logout.do">Log-out</a></h3>
	</div>
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post" style="margin-top : 10px">
		<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
		<td align="right">
			<select name="searchCondition">
			<c:forEach items="${conditionMap }" var="option">
				<option value="${option.value }">${option.key }
			</c:forEach>
			</select>
			<input name="searchKeyword" type="text"/>
			<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"/>
		</td>
		</tr>
		</table>
	</form>
	
	<!-- 검색 종료 -->
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<th style="background-color:orange" width="100"><spring:message code="message.board.list.table.head.seq"/></th>
		<th style="background-color:orange" width="200"><spring:message code="message.board.list.table.head.title"/></th>
		<th style="background-color:orange" width="150"><spring:message code="message.board.list.table.head.writer"/></th>
		<th style="background-color:orange" width="150"><spring:message code="message.board.list.table.head.regDate"/></th>
		<th style="background-color:orange" width="100"><spring:message code="message.board.list.table.head.cnt"/></th>
	</tr>
	<c:forEach items="${boardList}" var="board">
	<tr>
		<td>${board.seq}</td>
		<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
		<td>${board.writer}</td>
		<td>${board.regDate}</td>
		<td>${board.cnt}</td>
	</tr>
	</c:forEach>
	</table>
	<br>
	<div class="center-text">
	<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
	</div>
</body>
</html>