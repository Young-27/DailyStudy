<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
    
<%
	
	Member searchUser = (Member)session.getAttribute("searchUser");
	// 로그인 전 menubar.jsp로딩시 : null
	// 로그인 성공 후 menubar.jsp 로딩시 : 로그인 성공한 회원의 정보가 담겨있는 Member객체

%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
    .outer{
        margin-top: 50px;
        margin-bottom: 50px;
        text-align: center;
    }
    .idresultf{
        margin: auto;
        background: rgb(240, 240, 239);
        width: 1000px;
        height: 350px;
    }
    .idresult{
        text-align: center;
        vertical-align: middle;
    }
    .idresult {font-size: 20px;}
</style>

</head>
<body>

  <%@ include file="../common/menubar.jsp" %>

    <div class="outer">

        <h4> ID찾기 </h4>
        <br> <br>

        <div class="idresultf">
            <br>
            <h5 style="text-align:center; font-weight: bold;">회원 정보 찾기</h5>
            <hr style="background: lightgray; border: 0; height: 2px;">
            <br><br><br><br>
		
		<% if(searchUser != null){ %>
            <div class="idresult">
                <b><%=searchUser.getMemName() %></b>님의 아이디는 <b><%=searchUser.getMemId() %></b>입니다. 
            </div>
		<% } %>
        </div>
    </div>
    
	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>