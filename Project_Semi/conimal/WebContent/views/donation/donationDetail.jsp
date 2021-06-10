<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.donation.model.vo.Donation"%>
   <% Donation dona = (Donation)request.getAttribute("dona");    
	  String keyword =(String)request.getAttribute("keyword");
	  String admission = "Y";
	  
   %>
   
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
      width:500px;
    	
    }
        
 
  .approvebtn, .rejectbtn{
   
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
  .btn{
  float:right;
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
  <tbody>
                 <tr>
		         <th>제목</th>
		         <td><%=dona.getDoTitle()%></td>
		        </tr>
		         <tr>
		         <th>보호소명</th>
		          <td><%=dona.getShName()%></td>
		         </tr>
		         <tr>
		         <th>시설 연락처</th>
		          <td><%=dona.getShPhone()%></td>
		         </tr>
		          <tr>
		         <th>등록 일자</th>
		          <td><%=dona.getDoWriteDate()%></td>
		         </tr>
		         </tbody>
		                
        </table>
  </div>
  <div class="imglist" align="center">
  	<img src="<%=contextPath %>/<%=dona.getFilePath() + dona.getChangeName()%>" width="200" height="150">   
  </div>
  
  
  <div class="content" align="center" >
  <hr>
  <div class="contentex">
  <p><%=dona.getDoContent()%></p>
  </div>
  </div>
  
  
  <div class="btn">	
  <% if(dona.getDoAdmission().equals("Y")||loginUser.getMemCode()!=1){%>
  <% }else{%>
 	<button class="approvebtn" onclick="location.href='<%=contextPath%>/Approve.do?doNo=<%=dona.getDoNo()%>&admission=<%=admission%>';">승인</button>
 	<button class="rejectbtn" onclick="confirm1();">거절</button>
 	<% }%>
 </div>
   <script>
 function confirm1(){
	 if(confirm("정말 거절하시겠습니까?")==true){
		 location.href='<%=contextPath%>/Reject.do?doNo=<%=dona.getDoNo()%>';
		
	 } else{
		 return;
	 }
 }
 </script>
 
  
  </div>
         <%@ include file="../common/footerbar.jsp" %>
</body>
</html>