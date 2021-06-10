<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        margin-bottom: 100px;
    }
    #joinTitle{
        margin: auto;

    }
    #joinForm{
        margin : auto;
        width: 1000px;
        height: 300px;
        margin-top: 30px;
       
        box-sizing: border-box;
        text-align: center;
    }
    #joinForm {
        margin: auto;
    }
    #joinForm>a{
        box-sizing: border-box;
        width: 300px;
    }
    #joinForm>div{
        float: left;
        margin-left: 125px;
    }

    #commonJoin,#petJoin{
        float: left;
        margin: auto;
        padding: 100px;
        background: rgb(188, 191, 194);
        border-radius: 10px;
        width: 300px;
    }
    #commonJoin{
        margin: 30px;
        text-align: center;
        vertical-align: middle;
    }
    #petJoin{
        margin: 30px;
        text-align: center;
        vertical-align: middle;
    }


</style>

</head>
<body>

    <%@ include file="../common/menubar.jsp" %>

    <!--
        <h2 id="joinTitle" align="center">회원가입</h2>
        <br><br><br><br>
    -->
    <div class="outer">

        <h2 id="joinTitle" align="center">회원가입</h2>
        <br><br>

        <div class="joinForm" id="joinForm">
         
            <div class="commonJoin" id="commonJoin">
            <a style="color:black; font-size:20px; font-weight:bold;" href="<%=contextPath %>/enrollForm.me">일반 회원</a> 
            </div>
            
            <div class="petJoin" id="petJoin">
                <a style="color:black; font-size:20px; font-weight:bold" href="<%=contextPath%>/shEnrollForm.me">보호소</a> 
            </div>
            <br>
            
        </div>
        <br>
    </div>











    <%@ include file="../common/footerbar.jsp" %>
</body>
</html>