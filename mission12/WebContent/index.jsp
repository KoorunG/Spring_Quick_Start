<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 등록 페이지</title>
</head>
<style>
body {
	font-family: '맑은 고딕';
}

input {
	margin-left: 400px;
	margin-top: 20px;
	margin-bottom: 10px;
	width: 200px;
	height: 40px;
	background-color: #3477eb;
	border: 1px solid black;
	color: beige;
}

a {
	text-align: center;
	font-size: 16px;
	text-decoration: none;
}
</style>
<body>
	<form action="article/write.do">
		<input type="submit" value="주소 등록">
	</form>
</body>
</html>