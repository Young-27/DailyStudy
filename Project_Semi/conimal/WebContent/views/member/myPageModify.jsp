<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.shelter.model.vo.Shelter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
       /* body 마이페이지 사이드바*/
       div{box-sizing:border-box;}
        .body{
            width:100%;
            /*height:800px;*/
            margin:auto;
            margin-top:10px;
        }
        .body>div{
            height:100%;
            float:left;
            }
        #left{width:25%;}
        #right{width:75%;}

        #mypage{
            font-weight: bold; 
            font-size: 32px; 
            color: rgb(127, 127, 127);
            text-align:center;
            padding:30px;
        }

        #sidebar{
            list-style-type:none; 
            margin:0;
            padding:0;
            height:100%;
        }
        #sidebar>li{
            background-color:lightgray;
           /* background-color: rgb(190, 190, 190);*/
            font-weight:bold;
            font-size:24px;
            text-align:center;
            line-height:75px;
        }
        #sidebar a{
            color:black;
            text-decoration:none;
        }
        #sidebar>li:hover{
            background-color:gray;
            cursor:pointer;
        }

        /* 사이드1 */
        .wrap{
            width:700px;
            height:800px;
            margin:auto;
            margin-top:50px;
        }
        table{margin:auto;}
        table th, table td{height:40px;}
        table th{width:150px; text-align:left;}
        table td{width:450px;}
      
        table input{
            width:300px;
            line-height:25px;
        }

        table p{font-size:13px;}

        button{
            font-size: 16px; 
            color: rgb(255, 255, 255); 
            text-align: center; 
            line-height: 2.5em; 
            border-radius: 4px; 
            background-color: rgb(127, 127, 127);
            border:0px;
            margin-right: 62px;
        }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<%
		String memName = loginUser.getMemName(); 
		String memId = loginUser.getMemId();
		String shPhone = loginUser.getShPhone();
		String email = (loginUser.getEmail() == null) ? "" : loginUser.getEmail();
		String shAddress = loginUser.getShAddress();
		String shLocal = loginUser.getShLocal();
		String shAbout = loginUser.getShAbout();
		int memNo = loginUser.getMemNo();
	%>

    <div class="body">

        <div id="left">
            <div id="mypage">마이페이지</div>
        
            <ul id="sidebar">
                <li id="side1"><a href="<%= contextPath %>/myPage.me">정보수정</a></li>
                <li id="side2"><a href="<%= contextPath %>/myPagePost.me">작성 게시글</a></li>
                <li id="side3"><a href="<%= contextPath %>/deletePage.me">회원 탈퇴</a></li>
            </ul>
        </div>

        <div id="right">


            <div class="wrap">
                <form action="<%= contextPath %>/update.me" id="side1-form" method="post">
                 <input type="hidden" name="mno" value="<%=memNo%>">
                    <h2 align="center">정보수정</h2>
                    <br>
                    <table>
                        <tr>
                            <th>이름</th>
                                <td><input type="text" name="memName" placeholder="이름을 입력해주세요." required readonly value="<%=memName%>"></td>
                        </tr>
                        <tr>
                            <th>아이디</th>
                                <td><input type="text" name="memId" placeholder="아이디를 입력하세요." required readonly value="<%=memId%>"></td>
                        </tr>
                        <tr>
                            <th>비밀번호</th>
                                <td><button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#updatePwdForm">변경하기</button></td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                                <td><input type="text" name="email" placeholder="이메일을 입력하세요." value="<%=email%>"></td>
                        </tr>
                       
                    </table>
             
            
                    <br><br>
                        
                    <div class="modify" align="center">
                        <button type="submit" class="btn btn-secondary btn-sm">수정하기</button>
                    </div>
            
                </form>
            </div>

        </div>

    </div>
    
    <!-- 비밀번호변경버튼 클릭시 보여질 Modal -->
	<div class="modal" id="updatePwdForm">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">비밀번호 변경</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body" align="center">

				<form action="<%= contextPath %>/updatePwd.me" method="post">
					<!-- 현재비밀번호, 변경할비밀번호, 변경할비밀번호재입력 -->
					<input type="hidden" name="memId" value="<%=memId%>">
					<table>
						<tr>
							<td>현재 비밀번호</td>
							<td><input type="password" name="memPwd" required></td>
						</tr>
						<tr>
							<td>변경할 비밀번호</td>
							<td><input type="password" name="updatePwd" required></td>
						</tr>
						<tr>
							<td>변경할 비밀번호 재입력</td>
							<td><input type="password" name="checkPwd" required></td>
						</tr>
					</table>
					<br>
					<button type="submit" class="btn btn-secondary btn-sm" onclick="return validatePwd();">비밀번호 변경</button>

				</form>
				
				<script>
					function validatePwd(){
						if($("input[name=updatePwd]").val() != $("input[name=checkPwd]").val()){
							alert("비밀번호가 일치하지 않습니다.");
							return false;
						}
					}
				</script>

	      </div>
	
	    
	
	    </div>
	  </div>
	</div>

	
	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>