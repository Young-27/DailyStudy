<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.volunteer.model.vo.Volunteer"%>
<%
	Volunteer v = (Volunteer)request.getAttribute("v");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

	<br><br>

	<h2 align="center">자원봉사 상세보기</h2>
	
	<table border="1" align="center">
		<tr>
			<th>제목</th>
			<td><%=v.getVolTitle() %></td>
		</tr>
		<tr>
			<th>보호소명</th>
			<td><%=v.getShName() %></td>
		</tr>
		<tr>
			<th>모집기간</th>
			<td><%=v.getSperiod() %></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><%=v.getShPhone() %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=v.getShAddress() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<p style="width:620px; height:200px;">
					<%=v.getVolContent() %>
				</p>
				</td>
		</tr>
	</table>
	
	<br>
	
	<div align="center">
		<button type="button" class="btn btn-primary" onclick="history.back();">목록으로</button>
	</div>

	<br><br>
	
	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>