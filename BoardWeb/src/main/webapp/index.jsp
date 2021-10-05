<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<!-- 클라이언트가 직접 URL을 입력하거나 하이퍼링크를 클릭하여 요청하면 기본이 GET방식 -->
<!-- index.jsp 페이지에서 로그인 링크를 클릭하면 GET방식으로 요청이 전달되어 loginView() 메소드가 실행됨 -->
<body>
	<div class="center-text">
		<h1>게시판 프로그램</h1>
		<hr>
		<a href="login.do">로그인</a> <br> <br> <br> <a href="getBoardList.do">글 목록 바로가기</a>
		<hr>
	</div>
</body>
</html>