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
    #mypage table{margin:auto;}
    #mypage input{margin:5px;}
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	
	<%
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		String phone = (loginUser.getPhone() == null) ? "" : loginUser.getPhone();
		String email = (loginUser.getEmail() == null) ? "" : loginUser.getEmail();
		String address = (loginUser.getAddress() == null) ? "" : loginUser.getAddress();
		String interest = (loginUser.getInterest() == null) ? "" : loginUser.getInterest(); // "운동,등산"
	%>

    <div class="outer">
        <br>
        <h2 align="center">마이페이지</h2>
    
        <form action="" id="mypage" method="post">
    
            <!-- 아이디, 비번, 이름, 전화번호, 이메일, 주소, 취미 -->
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" value="<%=userId%>"></td>
                </tr>
                
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" maxlength="6" required value="<%=userName%>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;전화번호</td>
                    <td><input type="text" name="phone" placeholder="- 포함해서 입력" value="<%=phone%>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;이메일</td>
                    <td><input type="email" name="email" value="<%=email%>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;주소</td>
                    <td><input type="text" name="address" value="<%=address%>"></td>
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
            <script>
            	$(function(){
            		var interest = "<%=interest%>";
            		// "" | "운동,등산,게임"
            		
            		$("input[type=checkbox]").each(function(){
            			
            			// 순차적으로 접근한 input요소의 value값이 interest에 포함되어있을 경우
            			// => 해당 input요소에 checked속성 부여
                        if($(this).val *= interest){
                            $(this).checked();
                        } 

            			
            		});
            		
            	});
            </script>
    
            <br><br>
    
            <div align="center">
                <button type="submit">정보변경</button>
                <button type="button">비밀번호변경</button>
                <button type="button">회원탈퇴</button>

            </div>
    
            <br><br>
    
        </form>
        </div>
	
</body>
</html>