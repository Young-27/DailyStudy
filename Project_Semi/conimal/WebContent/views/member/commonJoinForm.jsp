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
        margin: auto;
        margin-top: 50px;
        margin-bottom: 50px;
    }
    .commonJoin{
        margin: auto;
        width: 1000px;
        height: 600px;
        background: rgb(240, 240, 239);
    }
    #commonJoinForm{
        margin: auto;
        width: 800px;
       
    }
    #commonJoinForm>button{
        margin: auto;
        display: table;

    }
    #submitB{
        margin: auto;
        text-align: center;
        vertical-align: middle;
        }
    #commonJoinFormT{
        margin: auto;
        width: 800px;
        height: 300px;
    }
    #commonJoinFormT>tr>th{
        margin:auto;
        width: 50px;
    }
    #commonJoinFormT input{
        width: 100%;
        height: 80%;
        border-radius:3px;
        border: 1px lightgray;

    }

</style>
<script></script>
</head>
<body>
 <%@ include file="../common/menubar.jsp" %>


    <div class="outer">
        <h4 style="text-align:center;">회원가입</h4>
        <br>
        <div class="commonJoin">
           
            <br><br>
            <h5 style="text-align:center;">회원 정보 입력</h5>
            <hr style="background: lightgray; border: 0; height: 2px;">
            <br>

            <form action="<%=contextPath %>/insert.me" id="commonJoinForm" method="post">
            
                <table id="commonJoinFormT">
                    <tr>
                        <th><label id="nameC">이름</label></th>
                        <td colspan="2">
                            <input type="text" name="userName" class="userName" id="userName" placeholder="이름을 입력해주세요." required>
                        </td>
                    </tr>

                    <tr>
                        <th><label id="idC">아이디</label></th>
                        <td><input type="text" maxlength="12" name="userId"  class="userId" id="userId" placeholder="아이디를 입력하세요." required></td>
                        <td><button type="button" class="btn btn-dark"  style="margin-left: 10px;" onclick="idCheck();">중복확인</button></td>
                    </tr>

                    <tr>
                        <th>비밀번호</th>
                        <td colspan="2"><input class="pwd" type="password"  name="userPwd" id="userPwd" maxlength="15" placeholder="비밀번호를 입력하세요." required></td>
                    </tr>

                    <tr>
                        <th>비밀번호 확인</th>
                        <td colspan="2"><input class="pwd" type="password" id="userPwd2"  placeholder="비밀번호를 다시 한 번 입력하세요." required>
                    </tr>

                    <tr>
                        <th><label id="emailC">이메일</label></th>
                        <td><input type="text" id="email" name="email" class="email" placeholder="이메일주소를 입력하세요." required></td>
            
                    </tr>
                    
                </table>
                <br><br>

                <button type="submit" id="btn" onclick="checkPwd();" class="submitB btn btn-secondary" disabled >회원가입</button>

            </form>


        </div>
    </div>


    
        <script>
        	var joinCheck=1;
  			// 아이디 중복확인 버튼 클릭시 실행할 거임 
  			
  			function idCheck(){
  				
  				// 아이디 입력하는 input요소 객체
  				var $userId = $("#commonJoinForm input[name=userId]");
  				
  				$.ajax({
  					url:"idCheck.me",
  					data: {checkId:$userId.val()},
  					type: "post",
  					success:function(result){
  						
  						if(result == "NNNNN"){ // 사용불가능한 경우
  							alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
  							$userId.focus();
  							
  						}else{ // 사용가능한 경우 => 진짜 사용할건지 사용자에게 물어보자!!
  							
  							if(confirm("사용가능한 아이디 입니다. 사용하시겠습니까?")){
  								
  							 // 속성을 없애서 회원가입 버튼을 활성화 시킴
  								joinCheck=0;
  								$userId.attr("readonly", true); //더 이상 변경이 불가능하게 바궈줌
  								
  							}else{// 아니 아이디 다시 정할래
  								
  								$userId.focus();
  							}
  							
  						}
  						
  					}, error:function(){
  						console.log("아이디 중복체크용 ajax통신 실패");
  					}
  				});
  				
  			}
  			
  
  			
  				$("#userPwd2").focusout(function(){
  	                 var pwd1 = $("#userPwd").val();
  	                 var pwd2 = $("#userPwd2").val();
  	                    
  	                 	if(pwd1 != pwd2 ){
  	                 		 alert("비밀번호가 일치하지 않습니다. 비밀번호를 재입력해주세요.");
  	                 	}
  	                 	
  	                   if(pwd1 == pwd2 && joinCheck==0){
  	                    	$("#commonJoinForm :submit").removeAttr("disabled");
  	                    }
  	                    
		  		});
  			
  
        </script>









 <%@ include file="../common/footerbar.jsp" %>
</body>
</html>