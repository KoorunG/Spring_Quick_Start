<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!-- el 인식 안될 경우, 상단에 다음의 소스 코드 추가해 줌   -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

	<h1>Hello JSP!!</h1>
	Hello! java Server Pages.
	<br><br>
	<c:set var="name1" value="장나라" />
	${name1}
	<br><br>
	
	<c:set var="name2" value="김유신" />
	${name2}
	<br><br>

	<c:set var="num1" value="5" />
	<c:set var="num2" value="${2}" />
	<c:set var="num3"> 5.2 </c:set>
	합은 ${num1 + num2 + num3}<br>

</body>
</html>