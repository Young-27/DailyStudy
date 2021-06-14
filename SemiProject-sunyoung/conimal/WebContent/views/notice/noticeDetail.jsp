<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.body{
		width: 770px;
        height: 1240px;
        margin: 0 auto;
        margin-top:80px;
	}
	.title{
	height: 58px;
	width:293px;	
	}
	.date{
	height:20px;
	width:85px;
	}
	.content{
	width:761px;
	height:415px;
	margin-top:80px;
	}
 
  .deletebtn, .modifybtn{
    float:right;
    font-size: 16px;
    color: rgb(64, 64, 64);
    text-align: center;
    line-height: 2.5em;
    background-color: rgb(224, 224, 224);   
    border:0px;
    border-radius: 4px; 
    width: 100px; height: 40px;
    margin:20px;
  }
</style>
</head>

<body>
<%@ include file="../common/menubar.jsp" %>
  <div class="body"> 
  <div calss="title">
  <h1>사이트 이용 가이드</h1>
  </div>
  <div class="date">
  2021-05-02
  </div>
  <div class="content">
  <p>
  	사이트 이용에 대한 안내입니다.<br><br>
  	아래의 사항에 따라 이용해주세요.
  	<br><br><br><br><br><br><br><br><br><br>
  	감사합니다.
  </p>   
  </div>
  <hr>
 <div class="btn">
 	<button class="deletebtn">삭제</button>
 	<button class="modifybtn">수정</button>
 </div>
  
  
  </div>
   <%@ include file="../common/footerbar.jsp" %>
</body>
</html>