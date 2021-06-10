<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.animal.model.vo.Animal, java.util.ArrayList"%>
<%
	Animal a = (Animal)request.getAttribute("a");
	ArrayList<Animal> list = (ArrayList<Animal>)request.getAttribute("list");
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
		
		<h2 align="center">보호중인 아이들 상세보기</h2>
	
		<br>
	
		<div class="pic-area" align="center">
			<img src="" alt="">
		</div>
	
		<br>
	
		<table border="1">
			<tr>
				<th>보호소명</th>
				<td><%=a.getShName() %></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><%=a.getAnGender() %></td>
			</tr>
			<tr>
				<th>발견날짜</th>
				<td><%=a.getAnDate() %></td>
			</tr>
	        <tr>
				<th>발견장소</th>
				<td><%=a.getAnPlace() %></td>
			</tr>
			<tr>
				<th>소개글</th>
				<td><p style="width:620px; height:200px;"><%=a.getAnContent() %></p></td>
			</tr>
		</table>
		
		<br>
	
		<div align="center">
				<button type="button" class="btn btn-primary" onclick="history.back();">목록으로</button>
			<%if(loginUser != null){ %>
				<button type="button" class="btn btn-primary" onclick="location.href='<%=contextPath%>/bookmark.an?ano=<%=a.getAnNo()%>&mno=<%=loginUser.getMemNo()%>'">즐겨찾기</button>
			<%}%>


		</div>
		
	
		<br><br>
	
	</div>

	<%@ include file="../common/footerbar.jsp" %>
	
</body>
</html>