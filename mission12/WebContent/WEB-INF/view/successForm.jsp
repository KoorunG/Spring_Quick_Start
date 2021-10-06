<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 등록 완료</title>
</head>
<body>
	<!-- 주소 입력이 완료 되었을 때 successForm.jsp 파일을 제작 -->
	주소 정보가 제대로 등록 처리 되었습니다.
	<br>
	<br> ${ctxPath = pageContext.request.contextPath; ''}
	<br>
	<br>

	<!-- 게시글 목록 보기 이동 링크 제공 -->
	<a href="${ctxPath}/index.jsp"><button>처음으로</button></a>
	<br>
	<br>

</body>
</html>