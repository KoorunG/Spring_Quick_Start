<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 입력</title>
<link rel='stylesheet' type='text/css' media='screen' href='resources/css/bootstrap.min.css'>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script>

<%-- 예제파일의 memberReg.jsp 부분을 참고하였습니다 -->

<%-- 주소검색 팝업 호출 --%>
	function fn_openAddressPopup() {
		var url = "addressAPIPopup.jsp";
		var name = "AddressPopup";
		var option = "width=650, height=500, top=100, left=200, location=no"
		window.open(url, name, option);
	}
<%-- 주소검색 팝업 호출 CallBack --%>
	function callback_openAddressPopup(aParam) {
		document.getElementById("mainAddress").value = aParam["roadAddr"];
	}
</script>
</head>
<body>
	<h2>[처음화면]</h2>
	
	<!-- update.do로 데이터 전송 -->
	<form action="update.do" method="post">
	<div class="input-group">
		<span>기본 주소</span>
		<br>
		<input type="text" id="mainAddress" name="mainAddress" placeholder="주소를 선택하세요."
			readonly="readonly">
			
			<!-- errors Map에 값이 해당하는 값이 있을 경우 메세지를 출력하는 부분 -->
			<span> 
			<c:if test="${errors.main}">기본 주소를 입력하세요</c:if>
			</span>
	</div>
	<div style="margin-top: 0px;">
		<span>상세 주소</span>
		<br>
		<input type="text" id="subAddress" name="subAddress" placeholder="나머지 주소를 입력하세요.">
			<c:if test="${errors.sub}">상세 주소를 입력하세요</c:if>
	</div>
	<input type="submit" value="주소 입력"/><button type="button" onclick="javascript:fn_openAddressPopup();">주소 검색</button>
	</form>
	<br>
	
</body>
</html>