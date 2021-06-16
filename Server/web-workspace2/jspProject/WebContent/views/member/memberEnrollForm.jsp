<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background:rgb(175, 194, 230);
        color: rgb(247, 247, 247);
        width: 1000px;
        margin: auto;
        margin-top: 50px;
    }
    #enroll-form table{margin:auto;}
    #enroll-form input{margin:5px;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

    <div class="outer">
	    <br>
	    <h2 align="center">회원가입</h2>

	    <form action="<%= contextPath %>/insert.me" id="enroll-form" method="post">
	
	        <!-- 아이디, 비번, 이름, 전화번호, 이메일, 주소, 취미 -->
	        <table>
	            <tr>
	                <td>* 아이디</td>
	                <td><input type="text" name="userId" maxlength="12"></td>
	                <td><button type="button" onclick="idCheck();">중복확인</button></td>
	            </tr>
	            <tr>
	                <td>* 비밀번호</td>
	                <td><input type="password" name="userPwd" maxlength="15" required></td>
	                
	            </tr>
	            <tr>
	                <td>* 비밀번호 확인</td>
	                <td><input type="password" maxlength="15" required></td>
	                <td></td>
	            </tr>
	            
	            <tr>
	                <td>* 이름</td>
	                <td><input type="text" name="userName" maxlength="6" required></td>
	                <td></td>
	            </tr>
	            <tr>
	                <td>&nbsp;&nbsp;전화번호</td>
	                <td><input type="text" name="phone" placeholder="- 포함해서 입력"></td>
	                <td></td>
	            </tr>
	            <tr>
	                <td>&nbsp;&nbsp;이메일</td>
	                <td><input type="email" name="email"></td>
	                <td></td>
	            </tr>
	            <tr>
	                <td>&nbsp;&nbsp;주소</td>
	                <td><input type="text" name="address"></td>
	                <td></td>
	            </tr>
	            <tr>
	                <td>&nbsp;&nbsp;관심분야</td>
	                <td colspan="2">
	
	                    <input type="checkbox" name="interest" id="sports" value="운동">
	                    <label for="sports">운동</label>
	
	                    <input type="checkbox" name="interest" id="climbing" value="등산">
	                    <label for="climbing">등산</label>
	
	                    <input type="checkbox" name="interest" id="fishing" value="낚시">
	                    <label for="fishing">낚시</label>
	
	                    <br>
	
	                    <input type="checkbox" name="interest" id="cooking" value="요리">
	                    <label for="cooking">요리</label>
	
	                    <input type="checkbox" name="interest" id="game" value="게임">
	                    <label for="game">게임</label>
	
	                    <input type="checkbox" name="interest" id="movie" value="영화">
	                    <label for="movie">영화</label>
	
	                </td>
	            </tr>
	        </table>
	
	        <br><br>
	
	        <div align="center">
	            <button type="submit" disabled>회원가입</button>
	            <button type="reset">초기화</button>
	        </div>
	        <br><br>
	    </form>
    </div>
    
    <script>
    	function idCheck(){
    		
    		// 아이디 입력하는 input요소 객체
    		// 변수명 앞에 $를 두는거 => 제이쿼리를 사용하라고 알려주는 용도
    		var $userId = $("#enroll-form input[name=userId]");
    		
    		$.ajax({
    			url:"idCheck.me",
    			data:{checkId:$userId.val()},
				success:function(result){
					
					if(result == "NNNNN"){ // 사용불가능
						
						alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
						$userId.focus();
						
						
					}else{ // 사용가능
					
						if(confirm("사용가능한 아이디입니다. 사용하시겠습니까?")){ // 사용함
							
							// id="enroll-form"의 하위요소(띄어쓰기공백)의 submit 선택!! *띄어쓰기 주의
							$("#enroll-form :submit").removeAttr("disabled"); // 회원가입활성화
							$userId.attr("readonly", true); // 더이상변경불가
							
						}else{ // 사용안함 => 다시입력
							$userId.focus();
						}
						
					}
					
				},error:function(){
					console.log("아이디중복체크용 ajax 통신실패");
				}    			
    		});
    		
    		
    		
    	}
    </script>
</body>
