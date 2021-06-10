<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.community.notice.model.vo.Notice"%>
 <% Notice n = (Notice)request.getAttribute("n");%>
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
	width:100%;	
	}
	.title>h1{
	font-weight:bold;font-size:40px;
	}
	.date{
	height:20px;
	width:300px;
	margin-top:30px;	
	font-size: 20px; color: rgb(158, 158, 158);
	}
	.content{
	width:761px;
	height:415px;
	margin-top:80px;	
	}
	.content>p{
	font-size: 15px; border-width: 0px; border-style: none;
	}
 	
 	.btn{
 	 float:right;
 	}
  .deletebtn, .modifybtn{
   
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
<%@ include file="../../common/menubar.jsp" %>
  <div class="body"> 
  <div class="title">
  <h1><%=n.getNoticeTitle() %></h1>
  </div>
  <div class="date">
  <%=n.getNoticeDate()%>
  </div>
  <div class="content">
  <p>
  	<%=n.getNoticeContent()%>
  </p>   
  </div>
  <hr>
 <div class="btn">
 <% if(loginUser != null && loginUser.getMemNo()==n.getNoticeMem()){ %>
 	<button  onclick="confirm1();" class="deletebtn">삭제</button>
 	<button  onclick="location.href='<%= contextPath %>/UpdateForm.no?noticeNo=<%= n.getNoticeNo() %>'" class="modifybtn">수정</button>
 <% } %>
 </div>
 <script>
 function confirm1(){
	 if(confirm("정말 삭제하시겠습니까?")==true){
		 location.href='<%= contextPath %>/delete.no?noticeNo=<%=n.getNoticeNo()%>';
		
	 } else{
		 return;
	 }
 }
 </script>
  
  
  </div>
   <%@ include file="../../common/footerbar.jsp" %>
</body>
</html>