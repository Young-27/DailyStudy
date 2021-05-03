<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<%
	//System.out.println(request.getContextPath()); => /jsp
	String contextPath = request.getContextPath();

	Member loginUser = (Member)session.getAttribute("loginUser");
	// 로그인 전 menubar.jsp 로딩시 : null
	// 로그인 성공 후 menubar.jsp 로딩시 : 로그인 성공한 회원의 정보가 담겨있는 Member객체

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #login-form, #user-info {float:right}
    #user-info a{
        text-decoration: none;
        color: black;
        font-size: 12px;
    }
    .nav-area{background:rgb(175, 194, 230)}
    .menu{
        display:table-cell;
        height: 50px;
        width: 150px;
    }
    .menu a{
        text-decoration: none;
        color: rgb(247, 247, 247);
        font-size: 15px;
        font-weight: bold;
        display: block;
        width: 100%;
        height: 100%;
        line-height: 50px;
    }
    .menu a:hover{
        background: darkgray;
    }
</style>
<body>
	
    <h1 align="center" style="color: rgb(179, 179, 179);">Conimal</h1>

    <div class="login-area">
		
		<% if(loginUser == null) { %>
	        <!--로그인전에 보이는 로그인폼-->    
	        <form id="login-form" action="<%= request.getContextPath() %>/login.me" method="post">
	            <table>
	                <tr>
	                    <th>아이디 : </th>
	                    <td><input type="text" name="userId" required></td>
	                </tr>
	                <tr>
	                    <th>비밀번호 : </th>
	                    <td><input type="password" name="userPwd" required></td>
	                </tr>
	                <tr>
	                    <th colspan="2">
	                        <button type="submit">로그인</button>
	                        <button type="button">회원가입</button>
	                    </th>
	                </tr>
	            </table>
	        </form>
        <% } else { %>
        	<!-- 로그인성공후 -->
	        <div id="user-info">
	            <b><%= loginUser.getUserName() %>님</b>의 방문을 환영합니다. <br><br>
	            <div align="center">
	                <a href="">마이페이지</a>
	                <a href="<%= contextPath %>/logout.me">로그아웃</a>
	            </div>
	        </div>
		<% } %>
		
		
    </div>

    <br clear="both">
    <br>

    <div class="nav-area" align="center">
        <div class="menu"><a href="">HOME</a></div>
        <div class="menu"><a href="">공지사항</a></div>
        <div class="menu"><a href="">일반게시판</a></div>
        <div class="menu"><a href="">사진게시판</a></div>

    </div>


</body>
</html>