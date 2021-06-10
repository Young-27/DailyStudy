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
    .outer2{
        margin: auto;
        text-align: center;
        vertical-align: middle;
    }
    .outer2>input{
        margin: 10px;
    }
    .searchIdPwd{
        margin: auto;
        background: rgb(240, 240, 239);
        width: 1000px;
        height: 450px;
    }
    #searchFrom {
        margin: auto;
        display: flex;
        
    }
    #searchFormT{
        margin: auto;
        width: 500px;
        height: 100px;
    }
    #searchForm>button{
        margin: auto;
        display: table;

    }
    #searchFormT>tr>th{
        text-align: center;
    }
    #searchFormT input{
        width: 95%;
    }
    .btn{
        margin: auto; 
        
     }
     .submitB{
        display: block;
        width: 100px;
        height: 30px;
     }
    
</style>

<script></script>
</head>
<body>
   <%@ include file="../common/menubar.jsp" %>


    <div class="outer">
        <h4 style="text-align:center;">ID / PWD 찾기</h4>
        <br>
        <div class="searchIdPwd">
           
            <br><br>
            <h5 style="text-align:center; font-weight: bold;">회원 정보 찾기</h5>
            <hr style="background: lightgray; border: 0; height: 2px;">
            <br>

            <div class="outer2">
                    <input type="radio" id="searchId" name="search" onchange="showIdForm();" class="search"  > 아이디(ID)찾기
                    <input type="radio" id="searchPwd"  name="search" onchange="showIdForm();"  class="search"> 비밀번호(PWD)찾기
                </div>
                
                <br>
                <script>
                
                $(function(){
                      $("#searchIdFormT").hide();
                       $("#searchPwdFormT").hide();
                       $("#comment").show();
                });
                   function showIdForm(){                     
                      if($('input:radio[id=searchId]').is(':checked')){
                         $("#searchIdFormT").show();
                         $("#searchPwdFormT").hide();
                         $("#comment").hide();
                       
                      }else if($('input:radio[id=searchPwd]').is(':checked')){
                         $("#searchIdFormT").hide();
                         $("#searchPwdFormT").show();                       
                         $("#comment").hide();   
                       
                      }
                   }
                
                </script>
                   <!-- 아이디 찾기 버튼클릭시 활성화 -->
                   <div id="searchIdFormT">
                     <form action="<%=contextPath %>/searchId.me" id="searchForm" method="post">                           
                            <table id="searchFormT" >
                              <tr>
                                  <th>이름</th>
                                  <td colspan="2">
                                      <input name="memName" type="text"class="userName" id="userName" placeholder="이름을 입력해주세요." required>
                                  </td>
                              </tr>
                              <tr>
                                  <th>이메일</th>
                                  <td><input name="email" type="text" id="email" class="email" placeholder="이메일주소를 입력하세요." required></td>
                              </tr>
                          </table> 
                          <br> <br>    
                          <button type="submit"  id="btn" class="submitB" style=" margin:auto; background:lightgray; border: 20px; border-radius: 3px;" >ID찾기</button>
                    </form>    
                  </div>    
                           
                                      
                  <div id="searchPwdFormT">
                      <form action="<%=contextPath %>/searchPwd.me" id="searchForm" method="post">
                           
                           <table id="searchFormT" >
                              <tr>
                                  <th>이름</th>
                                  <td colspan="2">
                                      <input name="memName" type="text"class="userName" id="userName" placeholder="이름을 입력해주세요." required>
                                  </td>
                              </tr>
                              <tr>
                                      <th>아이디</th>
                                      <td colspan="2">
                                          <input name="memId" type="text"class="userId" id="userId" placeholder="아이디를 입력하세요." required>
                                      </td>
                                  </tr> 
                              <tr>
                                  <th>이메일</th>
                                  <td><input name="email" type="text" id="email" class="email" placeholder="이메일주소를 입력하세요." required></td>
                              </tr>
                          </table> 
                          <br> <br>   
                             <button type="submit"  id="btn" class="submitB" style=" margin:auto; background:lightgray; border: 20px; border-radius: 3px;" >PWD찾기</button>
                      </form>
                </div>
                    
                       <div id="comment">
                            <b id="coment" style="margin-left:325px; margin-top:30px; text-align:center; vertical-align:middle">아이디 혹은 비밀번호 찾기 버튼을 클릭해주세요♥</b>
                       </div>
                  <!-- 비밀번호 변경 클릭시 활성화 -->
        </div>
    </div>

  


   <%@ include file="../common/footerbar.jsp" %>

</body>
</html>