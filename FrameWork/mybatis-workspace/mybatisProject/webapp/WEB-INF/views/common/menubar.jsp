<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .login-area a{
        text-decoration: none;
        color:black;
        font-size:12px;
    }
    .nav-area{
        background:black;
        color:white;
        height:50px;
    }
    .menu{
        display:table-cell;
        width:250px;
        height:50px;
        font-size:20px;
        vertical-align:middle;
        font-weight:bold;
    }
    .menu:hover{background:darkgray; cursor:pointer}

    .outer{
        width:900px;
        background:black;
        color:white;
        margin:auto;
        margin-top:50px;
    }
</style>
</head>
<body>

    <h1 align="center">Welcome to MyBatis World!!</h1>
    <br>

    <div class="login-area" align="right">
    
    	<c:choose>
			<c:when test="${ empty loginUser }">
		        <!--로그인 전에 보여질 폼-->
		        <form action="" method="post">
		            <table>
		                <tr>
		                    <td>아이디</td>
		                    <td><input type="text" name="userId"></td>
		                    <td rowspan="2"><button type="submit" style="height:50px;">로그인</button></td>
		                </tr>
		                <tr>
		                    <td>비밀번호</td>
		                    <td><input type="password" name="userPwd"></td>
		                </tr>
		                <tr>
		                    <td colspan="3" align="center">
		                        <a href="enrollForm.me">회원가입</a>
		                        <a href="">아이디/비번 찾기</a>
		                    </td>
		                </tr>
		            </table>
		        </form>
	        </c:when>
			<c:otherwise>
		        <!--로그인 후 보여질 div-->
		        <div>
		            <table>
		                <tr>
		                    <td colspan="2">
		                        <h3>xxx님 환영합니다.</h3>
		                    </td>
		                </tr>
		                <tr>
		                    <td><a href="">마이페이지</a></td>
		                    <td><a href="">로그아웃</a></td>
		                </tr>
		            </table>
		        </div>
        	</c:otherwise>
        </c:choose>        
        
    </div>
    <br>


    <div class="nav-area" align="center">
        <div class="menu">HOME</div>
        <div class="menu">공지사항</div>
        <div class="menu">게시판</div>
        <div class="menu">ETC</div>
    </div>



</body>
</html>