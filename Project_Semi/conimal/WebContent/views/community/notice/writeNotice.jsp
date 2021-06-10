<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.body{
		width: 1000px;
        height: 1240px;
        margin: 0 auto;
        margin-top:30px;
	}
h3{
float:left;
}
.headTitle{
	margin:100px;
}
.title{
width:741px;
height:40px;
margin:100px;
}
.title>input{
width:100%;
height:100%;
border-radius:4px;
border:1px solid;
margin-top:10px;
}

.content{
width:741px;
height:519px;
margin:100px;

}
.content>textarea{
resize:none;
width:100%;
height:100%;
border-radius:4px;
}

#inputfile{
display:none;
}

 .write>button{
    float:right;
    font-size: 16px;
    color: rgb(64, 64, 64);
    text-align: center;
    line-height: 2.5em;
    background-color: rgb(224, 224, 224);   
    border:0px;
    border-radius: 4px; 
    width: 100px; 
    height: 40px;
    margin-right: 155px;
  }

 
</style>
<body>
<%@ include file="../../common/menubar.jsp" %>

  <div class="body">  
  <form id="write-form" action="<%=contextPath%>/insert.no" method="post">
  <div class="headTitle">
  <h1>공지사항</h1>
  </div>
  
  <h3>제목</h3>
  <div class="title">  
  <input type="text" name="title" placeholder="제목을 입력해주세요." required>
  </div>
   <h3>내용</h3>
  <div class="content">
  <textarea placeholder="내용을 입력해주세요." name="content" style="resize:none" required></textarea>
  </div> 
 
  <div class="write">
  <button type="submit">등록</button>  
  </div>
  </form>
  
  </div>

<%@ include file="../../common/footerbar.jsp" %>

</body>
</html>