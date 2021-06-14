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
	table{
		border-spacing: 10px;
	}
	.pic-area{
		width: 250px;
		height: 150px;
		border: 1px solid black;
	}
	table tr td{
		text-align: center;
	}
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>

	<h2 align="center">보호중인 아이들</h2>

	<br>
	
	<div class="type-area" align="center">
		<button type="button" class="btn btn-secondary btn-lg">강아지</button>
		<button type="button" class="btn btn-secondary btn-lg">고양이</button>
	</div>

	<br>
	
	<div class="content-area">
		<table align="center">
			<tr>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
			</tr>
			<tr>
				<td>종명</td>
				<td>종명</td>
				<td>종명</td>
				<td>종명</td>
			</tr>
			<tr>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
			</tr>
			<tr>
				<td>종명</td>
				<td>종명</td>
				<td>종명</td>
				<td>종명</td>
			</tr>
			<tr>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
				<td class="pic-area">사진</td>
			</tr>
			<tr>
				<td>종명</td>
				<td>종명</td>
				<td>종명</td>
				<td>종명</td>
			</tr>
		</table>
	</div>

	<br><br>
	
	<div align="center" class="paging-area">
		<button>1</button>
		<button>2</button>
		<button>3</button>
		<button>4</button>
	</div>
	
	<br><br>
	
	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>