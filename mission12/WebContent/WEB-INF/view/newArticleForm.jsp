<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 등록</title>
</head>
<body>
	<!-- WriteArticleHandler가 뷰로 사용하는 newArticleForm.jsp 제작한다.
		 즉, 주소 등록 폼을 제공하는 역할을 한다. -->
	<form action="write.do" method="post">
		기본 주소 : <br>
		<!-- <input type="text" name="basicAddress" id="basicAddress" onclick="javascript:fn_openAddressPopup();" value="${param.basic}"> -->
		<input type="text" id="basicAddress" name="basicAddress">
		<button id="basicAddress" type="button" onclick="javascript:fn_openAddressPopup();">검색</button><br>
		<br> 상세 주소 : <br>
		<input type="text" id="detailAddress" name="detailAddress">
		<input type="submit" value="주소 등록">
	</form>
		<a href="${ctxPath}/mission12/index.jsp"><button>처음으로</button></a>
	<br>
	
	
</body>
<!-- <script type="text/javascript"> -->
<script>
	function fn_openAddressPopup() {
		var url = "fwdSearchAddressPopup.do";
		var name = "AddressPopup";
		var option = "width=650, height=500, top=100, left=200, location=no"
		window.open(url, name, option);
	}

	function callback_openAddressPopup(aParam) {
		document.getElementById("basicAddress").value = aParam["roadAddr"];
	}
</script>
</html>
