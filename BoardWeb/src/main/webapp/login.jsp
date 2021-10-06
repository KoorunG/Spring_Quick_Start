<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title"/></title>
<style>
* {
	margin: 0 auto;
	padding: 0;
	list-style: none;
	font-family: "맑은 고딕";
}

.login {
	text-align: center;
}
</style>
</head>
<body>
	<br>
	<h1 class="login"><spring:message code="message.user.login.title"/></h1>
	<div class="login">
	<!-- 언어 선택기 -->
	<a href="login.do?lang=en">
		<spring:message code="message.user.login.language.en"/>
	</a>&nbsp;&nbsp;
	<a href="login.do?lang=ko">
		<spring:message code="message.user.login.language.ko"/>
	</a>
	</div>
	<br>
	<hr>
	<br>
	<form class="inputForm" action="login.do" method="post">

		<table class="layer" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange"><spring:message code="message.user.login.id"/></td>
				<td><input type="text" name="id" value="${user.id }"></td>
			</tr>
			<tr>
				<td bgcolor="orange"><spring:message code="message.user.login.password"/></td>
				<td><input type="password" name="password" value="${user.password }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="<spring:message code="message.user.login.loginBtn"/>"></td>
			</tr>
		</table>
	</form>
	<br>
	<hr>
</body>
</html>