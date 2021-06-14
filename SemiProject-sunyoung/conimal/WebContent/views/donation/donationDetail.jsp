<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.body{
		width: 780px;
        height: 1240px;
        margin: 0 auto;
        margin-top:80px;
	}
 
  h1{
      margin: 0;  
      font-weight: bold; color: rgb(127, 127, 127);          
  }
  .head1{
  	width:100%;
  	height:10%;
  	
  }
  .head2{
  	width:100%;
  	height:15%;
  	margin:0 50px;
  	
  }
  
  .content{
  width:780px;
  height:440px;  
  margin-top:50px;
  }
  .contentex{
  width:476px;
  height:440px;  
  text-align:left;
  }
  .imglist{
 height:327px;
 width:772px;
  }
  
  .imglist>img{
  	height:268px;
  	width:477px;
  	margin:30px 0;
  }


  	.list-area{
        
        text-align:center;
    }
    .list-area>tbody>tr>th{
   		
    	background: #eaeaea;    	
    	font-weight: bold;
   
   		
    }
     .list-area>tbody>tr>td{
     border-top: 1px solid #ccc; 
      border-bottom: 1px solid #ccc; 
    	
    }
   
     
     .paging-area>button{
    font-size: 16px; 
    color: rgb(255, 255, 255); 
    text-align: center; 
    line-height: 2.5em; 
    border-radius: 4px; 
	background-color: rgb(244, 244, 244);
	color:black;
    border:0px;
    border-radius:50px;    
    width:30px;
    height:30px;
    }
  .approvebtn, .rejectbtn{
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
<div class="head1">  
  <h1>후원 신청 조회</h1>
 
  </div>
	<div class="head2">
  <table class="list-area" >
  <tbody>
                 <tr>
		         <th>제목</th>
		         <td>하얀 강아지는 익산에 위치한 200여마리 아이들의 진정한 보금자리입니다.</td>
		        </tr>
		         <tr>
		         <th>보호소명</th>
		          <td>하얀 강아지</td>
		         </tr>
		         <tr>
		         <th>시설 연락처</th>
		          <td>010-1234-7777</td>
		         </tr>
		          <tr>
		         <th>등록 일자</th>
		          <td>2021-05-04</td>
		         </tr>
		         </tbody>
		                
        </table>
  </div>
  <div class="imglist" align="center">
  	<img src="">
   <div align="center" class="paging-area">

            	<button > &lt; </button>		
	            	<button disabled></button>
	            	<button disabled></button>
	            	<button disabled></button>
                    <button disabled></button>  
            	<button > &gt; </button>
		
        </div>     
  </div>
  
  
  <div class="content" align="center" >
  <hr>
  <div class="contentex">
  <p>안녕하세요 하얀 강아지는 전라북도 익산에 위치한 200여마리 강아지 고양이들의 안전하고 따뜻한 쉼터입니다.</p>
  </div>
  </div>
  
  
  <div class="btn">
 	
 	<button class="rejectbtn">거절</button>
 	<button class="approvebtn">승인</button>
 </div>
  
 
  
  </div>
         <%@ include file="../common/footerbar.jsp" %>
</body>
</html>