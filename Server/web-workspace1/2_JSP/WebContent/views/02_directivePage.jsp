<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> <%-- errorPage="error500.jsp" --%>
<%@ page import="java.util.ArrayList, java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page 지시어</h1>
	
	<%
		ArrayList<String> list = new ArrayList<>();
		list.add("Servlet"); // 0번인덱스
		list.add("JSP"); 	 // 1번인덱스
		
		Date today = new Date();
	%>
	
	<p>
		리스트의 길이 : <%= list.size() %> <br>
		0번인덱스 : <%= list.get(0) %> <br>
		1번인덱스 : <%= list.get(1) %> <br>
		현재 날짜 및 시간 : <%= today %>
	</p>
	
	<%= list.get(10) %>
	
	
</body>
</html>