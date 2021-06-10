<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.shelter.model.vo.Shelter"%>
 <% Shelter sh = (Shelter)request.getAttribute("sh");
 	String admission ="Y";
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
  .body1{
  	height:800px;
  	width:777px;
  	
  }
  
  	.list-area{
        width:100%;
        height:100%;
        text-align:center;
    }
    .list-area>tbody>tr>th{
   		 border-top: 1px solid #ccc; 
    	 border-bottom: 1px solid #ccc; 
    	background: #eaeaea;    	
    	font-weight: bold;
   
   		
    }
     .list-area>tbody>tr>td{
     border-top: 1px solid #ccc; 
      border-bottom: 1px solid #ccc; 
    	
    }
   
     
    ul{
     list-style: none;
    margin-right:50px;
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
  margin-top:50px;
  margin-left:30px;
  }

    
</style>
</head>
<body>
<%@ include file="../../common/menubar.jsp" %>
<div class="body">  
<div class="head1">  
  <h1>보호소 등록 신청 조회</h1>
 
  </div>
	<div class="body1">
  <table class="list-area" >
  <tbody>
                 <tr>
		         <th>보호소명</th>
		         <td><%=sh.getShName()%></td>
		        </tr>
		         <tr>
		         <th>주소</th>
		          <td><%=sh.getShAddress()%></td>
		         </tr>
		         <tr>
		         <th>시설 연락처</th>
		          <td><%=sh.getShPhone() %></td>
		         </tr>
		          <tr>
		         <th>등록일자</th>
		          <td><%=sh.getEnrollDate()%></td>
		         </tr>
		         <tr>
		         <th>첨부파일</th>
		         <td>
		         <ul>
		         <li>
		         <a href="">사업자등록증</a>
		         </li>
		         <li>
		         <a href="">대표자통장사본</a>
		         </li>
		         <li>
		         <a href="">법인인감증명서</a>
		         </li>
		         </ul>
		         <td>
		         </tr>
		         <tr>
		         <th height="500">보호소 소개</th>
		         <td>
		         <%=sh.getShAbout() %>
		         </td>
		         </tr>
		         </tbody>
		                
        </table>
  </div>

  
  

  
  
  <div class="btn">
  
 	<button class="approvebtn" onclick="location.href='<%=contextPath%>/Approve.sh?memNo=<%=sh.getMemNo()%>&admission=<%=admission %>';">승인</button>
 	<button class="rejectbtn" onclick="confirm1();">거절</button>
 	
 </div>
  <script>
 function confirm1(){
	 if(confirm("정말 거절하시겠습니까?")==true){
		 location.href='<%=contextPath%>/Reject.sh?memNo=<%=sh.getMemNo()%>';
		
	 } else{
		 return;
	 }
 }
 </script>
 
  
  </div>
         <%@ include file="../../common/footerbar.jsp" %>
</body>
</html>