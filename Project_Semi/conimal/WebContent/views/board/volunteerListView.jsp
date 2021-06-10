<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.list-area{
		text-align: center;
	}
	.list-area>tbody>tr:hover{
        background: lightgray;
        cursor: pointer;
    }
	table{border: 1px solid black;}
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>

	<h2 align="center">자원봉사 조회</h2>

	<br>

	<table class="list-area" align="center">
		<thead>
			<tr>
				<th>글번호</th>
				<th width="400">글제목</th>
				<th width="100">작성자</th>
				<th>조회수</th>
				<th width="100">작성일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>3</td>
				<td>자원봉사 모집글3</td>
				<td>xxx</td>
				<td>2</td>
				<td>2021-05-15</td>
			</tr>
			<tr>
				<td>2</td>
				<td>자원봉사 모집글2</td>
				<td>xxx</td>
				<td>22</td>
				<td>2021-05-13</td>
			</tr>
			<tr>
				<td>1</td>
				<td>자원봉사 모집글1</td>
				<td>xxx</td>
				<td>12</td>
				<td>2021-05-11</td>
			</tr>
		</tbody>
	</table>

	<br><br>

	<div align="center" class="paging-area">
		<button>1</button>
		<button>2</button>
		<button>3</button>
		<button>4</button>
	</div>

	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>