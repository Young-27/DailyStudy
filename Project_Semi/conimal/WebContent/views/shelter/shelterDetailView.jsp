<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.shelter.model.vo.Shelter"%>
<%
	Shelter s = (Shelter)request.getAttribute("s");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.content{
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
	
	<div class="content">
	
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
				<td><%=s.getShName() %></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><%=s.getShAddress() %></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><%=s.getShPhone() %></td>
			</tr>
			<tr>
				<th>소개글</th>
				<td><p style="width:620px; height:200px;"><%=s.getShAbout() %></p></td>
			</tr>
		</table>
		
			<br>
		
			<div align="center">
				<button type="button" class="btn btn-primary" onclick="history.back();">목록으로</button>
			</div>
	
		<br><br>
	
	</div>

	<%@ include file="../common/footerbar.jsp" %>
	
</body>
</html>