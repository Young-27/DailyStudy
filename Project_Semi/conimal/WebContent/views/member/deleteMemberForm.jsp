<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    /* 사이드3 */
    .wrap{
            width:700px;
            margin:auto;
            margin-top:50px;
        }
        table{margin:auto;}
        table th, table td{height:40px;}
        table th{
            width:150px; 
            text-align:left;
            color:rgb(127, 127, 127);
            font-size:15px;
        }
        table td{width:300px;}
        #pwd{
            width:200px;
            line-height:25px;
        }
        table p{
            width:450px;
            height:130px;
            font-size:13px; 
            text-align:center;
            color:#333333;
            background:rgb(224, 224, 224);   
        }
        #btn1{
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
	
				<form action="<%=contextPath %>/delete.me" method="post">
					<h2 align="center">회원 탈퇴</h2>
					<br>
					
						<table>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="memPwd" placeholder="비밀번호를 입력하세요." required onkeyup="agreeCheck();"></td>
							</tr>
							<tr>
								<th>비밀번호 재입력</th>
								<td><input type="password" name="checkPwd" placeholder="비밀번호를 재입력하세요." required onkeyup="agreeCheck();"></td>
							</tr>
							<tr>
								<th colspan="2">
									<p><br>
									회원탈퇴 시 귀하의 게시글은 관리자에 의해 수정 및 삭제될 수 있으며 <br>
									재가입시에도 해당 계정으로 작성한 게시글 수정 및 삭제는 불가합니다.<br>
									이에 동의 하십니까? <br><br>
										<input type="checkbox" id="agreement" onchange="agreeCheck();">동의함
									</p> 
								</th>
							</tr>
						</table>
			
					
						<br><br>
						
						<div class="delete" align="center" >
							 <button type="button" id="btn1" data-toggle="modal" data-target="#deleteForm" disabled>탈퇴하기</button>
						</div>
						
						
						<!-- 탈퇴하기 버튼 클릭시 보여질 Modal -->
						<div class="modal" id="deleteForm">
						  <div class="modal-dialog">
						    <div class="modal-content">
						
						      <!-- Modal Header -->
						      <div class="modal-header">
						        <h4 class="modal-title">회원 탈퇴</h4>
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						      </div>
						
						      <!-- Modal body  -->
						      <div class="modal-body" align="center">
					
								<b>탈퇴 후 복구가 불가능합니다. <br>정말로 탈퇴 하시겠습니까?</b>
								<br>
							
									<button type="submit" class="btn btn-danger btn-sm">탈퇴하기</button>	
						
						      </div>	
						      
					    	</div>
						  </div>
						</div>	      
		
		
		
		
				</form>
				<script>
                    

                    function agreeCheck(){
                        if($("input:checkbox[id=agreement]").is(':checked')){

                            if($("input[name=memPwd]").val().length != 0 && $("input[name=checkPwd]").val().length !=0 &&      $("input[name=memPwd]").val() == $("input[name=checkPwd]").val()){
                                $("#btn1").removeAttr("disabled")
                            }else{
                                $("#btn1").attr("disabled", true);
                            }

                        }else{
                            $("#btn1").attr("disabled", true);
                        }
                    }
                    
				</script>
				
			</div>
		</div>
	</div>
	



	      
	      <br><br>
	
	<%@ include file="../common/footerbar.jsp" %>
</body>
</html>