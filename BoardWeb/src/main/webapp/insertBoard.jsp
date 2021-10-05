<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 등록</title>
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
	<h1>글 등록</h1>
	<br>
	<a href="logout.do">Log-out</a>
	</div>
	<hr>
	<form action="insertBoard.do" method="post" enctype="multipart/form-data">
		<table style="margin-top : 7px; margin-bottom : 7px" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td style="background-color : orange" width="70">제목</td><td align="left">
				<input type="text" name="title"/></td>
			</tr>
			
			<tr>
				<td style="background-color : orange">작성자</td><td align="left">
				<input type="text" name="writer" size="10"/></td>
			</tr>
			
			<tr>
				<td style="background-color : orange">내용</td><td align="left">
				<textarea style="resize : none" name="content" cols="40" rows="10"></textarea></td>
			</tr>
			
			<tr>
				<td style="background-color : orange" width="70">업로드</td><td align="left">
				<input type="file" name="uploadFile"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value=" 새글 등록 "/></td>
			</tr>
		</table>
	</form>
	<hr>
	<div class="center-text">
	<a href="getBoardList.do">글 목록 가기</a>
	</div>
</body>
</html>