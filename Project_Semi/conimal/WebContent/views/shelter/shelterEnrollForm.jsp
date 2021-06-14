<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
      .body{
            width:700px;
            /*height:900px;*/
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

        .enroll>button{
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
        <h2 align="center">회원가입(보호소등록)</h2>
        <br>
        <form action="<%=contextPath %>/insertSh.me" id="shEnroll-form" method="post">
            <h3 align="center">회원 정보 입력</h3>
            <hr>
            <table>
                <tr>
                    <th>보호소명 </th>
                        <td><input type="text" name="shName" placeholder="이름을 입력해주세요." required> </td>
                </tr>
                <tr>
                    <th>아이디</th>
                        <td>
                        <input type="text" name="memId" placeholder="아이디를 입력하세요." required>
                        <button type="button" class="btn btn-dark"  style="margin-left: 10px;" onclick="idCheck();">중복확인</button>
                        </td>
                </tr>
                <tr>
                    <th>비밀번호 </th>
                        <td><input type="password" name="memPwd" placeholder="비밀번호를 입력하세요." required></td>
                </tr>
                <tr>
                    <th>비밀번호 확인 </th>
                        <td><input type="password" name="memPwd2" placeholder="비밀번호를 재입력하세요." required></td>
                </tr>
                <tr>
                    <th>연락처</th>
                        <td><input type="text" name="shPhone" placeholder="(-) 포함하여 연락처를 입력하세요." required></td>
                </tr>
                <tr>
                    <th>이메일</th>
                        <td><input type="text" name="email" placeholder="이메일을 입력하세요."></td>
                </tr>
                <tr>
                    <th>주소</th>
                        <td>
                            <select id="city_select" name="shLocal" title="시/도별 선택 리스트">
                                <option value="서울">서울</option>
                                <option value="경기도">경기도</option>
                                <option value="강원도">강원도</option>
                                <option value="충청도">충청도</option>
                                <option value="전라도">전라도</option>
                                <option value="경상도">경상도</option>
                                <option value="제주">제주</option>
                            </select>
                            <input type="text" name="shAddress" placeholder="주소를 입력하세요." required>
                        </td>
                </tr>
                <tr>
                    <th>소개글 </th>
                        <td><textarea name="shAbout" cols="50" rows="5" placeholder="내용을 입력하세요. 보호소소개란에 글이 게시됩니다." required></textarea></td>
                </tr>
                <tr>
                    <th>필수서류</th>
                        <td>
                            <input type="file" name="upfile1" ><br><br>
                            <input type="file" name="upfile2" ><br><br>
                            <input type="file" name="upfile3" >
                        </td>
                </tr>
                <tr>
                    <th colspan="2"> 
                        <p> <br>
                            ※ 사업자 등록증 사본 1부 / 대표자 명의 통장 사본 1부 / 법인 인감증명서 1부<br>
                            ※ 최근 3개월 이내 발급하신 서류를 깨끗하게 스캔해서 준비해주세요.
                        </p>
                    </th>
                </tr>
            </table>
 
            <br><br>
            
            <div class="enroll" align="center">
                <button type="submit" disabled>회원가입</button>
            </div>

        </form>
   
    </div>
    
    
     <script>
    	function idCheck(){
    		
    		// 아이디 입력하는 input요소 객체
    		var $memId = $("#shEnroll-form input[name=memId]");
    		
    		$.ajax({
    			url:"idCheck.me",
    			data:{checkId:$memId.val()},
    			success:function(result){
    		
    				if(result == "NNNNN"){ // 사용불가능
    					
    					alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
    					$memId.focus();	
    				
    				}else{ // 사용가능
    					
    					if(confirm("사용가능한 아이디입니다. 사용하시겠습니까?")){ // 사용함
    						
    						$("#shEnroll-form :submit").removeAttr("disabled"); // 회원가입 활성화
    						$memId.attr("readonly", true); // 더이상 변경불가
    						
    					}else{ // 사용안함 => 다시입력
    						$memId.focus();
    					}
    					
    				}
    				
    				
    			},error:function(){
    				console.log("아이디중복체크용 ajax 통신실패");
    			}
    		});
    		
    		
    		
    	}
    </script>
     

	<br><br>

	 <%@ include file="../common/footerbar.jsp" %>
	 
</body>
</html>