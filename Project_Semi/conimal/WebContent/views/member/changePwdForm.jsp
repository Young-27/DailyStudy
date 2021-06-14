<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	Member searchPwdUser = (Member)session.getAttribute("searchPwdUser");
	// 로그인 전 menubar.jsp로딩시 : null
	// 로그인 성공 후 menubar.jsp 로딩시 : 로그인 성공한 회원의 정보가 담겨있는 Member객체

%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
    .outer{
        margin: auto;
        margin-top:50px;
        margin-bottom: 50px;
    }
    .changePwd{
        margin: auto;
        text-align: center;
        margin: auto;
        background: rgb(240, 240, 239);
        width: 1000px;
        height: 350px;

    }
    #changePwdF {
        margin: auto;
        text-align: center;
        display: table;
        width: 800px;
        height: 250px;

    }
    #changePwdT{
     text-align: center;
     width:600px;
     height: 130px;
    }
    #changePwdT input{
        width: 95%;
    }
    #changePwdF {

    }
</style>

</head>
<body>
    <%@ include file="../common/menubar.jsp" %>

    <div class="outer">

        <h4 style="text-align:center;">PWD 재설정</h4>
        <br>
        <div class="changePwd">
            <br>
            <h5 style="font-weight: bolder;">비밀번호 재설정</h5>
            <hr style="background: lightgray; border: 0; height: 2px;">
            <br>

            <form action="<%=contextPath %>/changePwd.me" id="changePwdF" method="post">
                    
                 <input type="hidden" value="<%=searchPwdUser.getMemNo() %>" name="memNo">
                    <table id="changePwdT" >
                        <tr>
                            <th width="150px">새로운 비밀번호</th>
                            <td colspan="2">
                                <input type="password" name="newMemPwd" class="newPwd" id="newPwd" placeholder=" 새로운 비밀번호를 입력하세요." required>
                            </td>
                        </tr>

            
                        <tr>
                            <th width="150px">비밀번호 확인</th>
                            <td><input type="password" id="pwd2" class="pwd2" placeholder=" 비밀번호를 다시 한 번 입력하세요."></td>
                        </tr>
                        
                    </table>
                    <br>

                    <button type="submit" id="btn" class="submitB" style="font-size:18px; background:lightgray; border: 25px; border-radius: 3px;" disabled > 수정하기 </button>
            </form>

        </div>       

    </div>
    <script>
    $("#pwd2").focusout(function(){
          var pwd1 = $("#newPwd").val();
          var pwd2 = $("#pwd2").val();
             
          	if(pwd1 != pwd2 ){
          		 alert("비밀번호가 일치하지 않습니다. 비밀번호를 재입력해주세요.");
          	}
          	
            if(pwd1 == pwd2){
             	$("#btn").removeAttr("disabled");
             }
             
		});
    
    
    
    
    </script>

    <%@ include file="../common/footerbar.jsp" %>

</body>
</html>