<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		width: 1200px;
		margin: auto;
	}
	.pic-area img{
		border: 1px solid black;
		width: 700px;
		height: 300px;
	}
	table{
		margin-left: 250px;
	}
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>

	<h2 align="center">보호소 상세보기</h2>

	<br>

	<div class="pic-area" align="center">
		<img src="" alt="">
	</div>

	<br>

	<table border>
		<tr>
			<th>보호소명</th>
			<td>XX보호소</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>서울시 성동구 어딘가</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>010-1234-5678</td>
		</tr>
		<tr>
			<th>소개글</th>
			<td><p style="width:620px; height:200px;"></p></td>
		</tr>
	</table>

	<br><br>

	<%@ include file="../common/footerbar.jsp" %>
	
</body>
</html>