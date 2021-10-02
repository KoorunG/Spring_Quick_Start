<%@page import="com.springbook.biz.board.impl.BoardDAOSpring"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	BoardVO board = (BoardVO) session.getAttribute("board");
%>

<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
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
	<h1>글 상세</h1>
	<br>
	<a href="logout_proc.jsp">Log-out</a>
	</div>
	<hr>
	<form action="updateBoard_proc.jsp" method="post">
	<!-- 글 수정 시 글 상세 화면(getBoard.jsp)이 글 수정에 사용 된다.
	     이때, 글 수정 처리를 진행 하려면, 수정할 글의 제목과 내용 뿐만 아니라,
	     게시글 번호로 알야아 한다. 따라서, 상세 화면을 출력할 때 form 태그 밑에
	   HIDDEN 타입의 input 태그를 추가하여 수정할 게시글 번호도 같이
	     전달될 수 있도록 코딩해야 한다. -->
	<input name="seq" type="hidden" value="<%=board.getSeq() %>"/>
	<table style="margin-top : 7px; margin-bottom : 7px;" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td style="background-color : orange" width="70">제목</td>
			<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/> </td>
		</tr>
		
		<tr>
			<td style="background-color : orange">작성자</td>
			<td align="left"><%= board.getWriter() %></td>
		</tr>
		
		<tr>
			<td style="background-color : orange">내용</td>
			<td align="left"><textarea name="content" cols="40" rows="10" style="resize : none"><%= board.getContent() %></textarea></td>
		</tr>
		
		<tr>
			<td style="background-color : orange">등록일</td>
			<td align="left"><%= board.getRegDate() %></td>
		</tr>
		
		<tr>
			<td style="background-color : orange">조회수</td>
			<td align="left"><%= board.getCnt() %></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글 수정"/>
			</td>
		</tr>
	</table>
	</form>
	<hr>
	<div class="center-text">
	<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글목록</a>
	</div>
</body>
</html>