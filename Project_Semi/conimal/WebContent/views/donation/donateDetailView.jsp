<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.donation.model.vo.Donation"%>
<%
	Donation d = (Donation)request.getAttribute("d");
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

	<h2 align="center">후원 상세보기</h2>
	
	<table border="1" align="center">
		<tr>
			<th>제목</th>
			<td><%=d.getDoTitle() %></td>
		</tr>
		<tr>
			<th>보호소명</th>
			<td><%=d.getShName() %></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><%=d.getShPhone() %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=d.getShAddress() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<p style="width:620px; height:200px;">
					<%=d.getDoContent() %>
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