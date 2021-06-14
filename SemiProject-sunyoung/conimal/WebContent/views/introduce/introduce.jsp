<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.body{
		width: 652px;
        height: 1240px;
        margin: 0 auto;
        margin-top:30px;
	}
  .introduceimg{ 
  	  width: 652px;
	  height:407px;
	  
	  }
  h1,h5{
      margin: 0;  
      font-weight: bold; color: rgb(127, 127, 127);          
  }
  .head1{
  	width:100%;
  	height:10%;
  	
  }
  .body1{
  	width:100%;
  	height:40%;
  }
  .body2{
  width:100%;
  height:40%;
  }
  .foot1{
  width:100%;
  height:10%;  
  }
  .modifybtn{
    float:right;
    font-size: 16px;
    color: rgb(64, 64, 64);
    text-align: center;
    line-height: 2.5em;
    background-color: rgb(224, 224, 224);   
    border:0px;
    border-radius: 4px; 
    width: 100px; height: 40px;
  }
</style>
</head>
<body>
  <%@ include file="../common/menubar.jsp" %>
  <div class="body">  
  
  <div class="head1">
  <h5>코니멀 소개>사이트 소개</h5> 
  <h1>사이트소개</h1>
 
  </div>
	<div class="body1">
  <img src="" class="introduceimg">
  
  </div>
  <div class="body2">
  <hr>
  <p>
  	사이트 소개
  </p>  
  </div>
  <div class="foot1">
  <button class="modifybtn">수정</button>
  </div>
  
  
  </div>
   <%@ include file="../common/footerbar.jsp" %>

</body>
</html>