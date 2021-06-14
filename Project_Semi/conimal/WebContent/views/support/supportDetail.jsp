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
  	height:20%;
  	
  }
  
  .content{
  width:780px;
  height:440px;  
  }
  .contentex{
  width:476px;
  height:440px;  
  }


  .list-area{
        border:1px solid gray;
        text-align:center;
       
    }
     .list-area>tr>th{
      	
    	border: 1px solid gray;
    	word-break: break-all;
    	background: #eaeaea;    	
    	font-weight: bold;
    	display: table-cell;
   		vertical-align: inherit;
   		
  
   
     }
     .list-area>tr>td{
  		 border-bottom: 1px solid gray;
    	font-family: HanSans;
    	
     }
    .paging-area>button{
    width:10px;
    height:10px;
	color:black;
    border-top-left-radius: 100%; 
    border-top-right-radius: 100%; 
    border-bottom-right-radius: 100%;
     border-bottom-left-radius: 100%; 
     background-color: rgb(52, 152, 219);
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
  <table class="list-area">
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
		                
        </table>
  </div>
  <div class="imglist">
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
  <hr>
  
  <div class="content" align="center" >
  <div class="contentex">
  <p>안녕하세요 하얀 강아지는 전라북도 익산에 위치한 200여마리 강아지 고양이들의 안전하고 따뜻한 쉼터입니다.</p>
  </div>
  </div>
  
  
  <div class="btn">
 	<button class="approvebtn">승인</button>
 	<button class="rejectbtn">거절</button>
 </div>
  
 
  
  </div>
         <%@ include file="../common/footerbar.jsp" %>
</body>
</html>