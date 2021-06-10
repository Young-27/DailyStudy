<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.introduce.model.vo.Introduce" import="com.kh.attachment.model.vo.Attachment"%>
    <% Introduce intro = (Introduce)request.getAttribute("intro"); 
    Attachment at= (Attachment)request.getAttribute("at");   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.body>form{
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
  h1>input{
  margin-top:20px;
  width:640px;
  height:50px;
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
  .enrollbtn{
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
  
	textarea{
	resize:none;
	width:99%;
	height:400px;
	border-radius:4px;
	}
	
	.attachment{
	width:741px;
	height:40px;
	margin:30px;
	}
	.attachmentbtn{
	padding: 10px 25px;
	border-radius:4px;
	font-size: 16px; 
	color: rgb(64, 64, 64);
	 text-align: center;
	 line-height: 2.5em;  
	background-color: rgb(224, 224, 224);
	
	}
	.attachment>input{
	 width: 580px; height: 40px;
	 margin-left:20px;
	 border-radius:4px;
	 border:0px;
	
	}
	#inputfile{
	display:none;
	
	}
</style>
</head>
<body>
  <%@ include file="../common/menubar.jsp" %>
  <div class="body">  
  <form id ="updateintro" action="<%=contextPath%>/Update.intro" method="post" enctype="multipart/form-data">
  <input type="hidden" name="introNo" value="<%=intro.getIntroNo()%>">
  <div class="head1">
  <h5>코니멀 소개>사이트 소개</h5> 
  <h1><input type="text" value="<%=intro.getIntroTitle()%>" name="introTitle" required maxlength="20"></h1>
 
  </div>
	<div class="body1">
  <img src="<%=contextPath %>/<%=at.getFilePath() + at.getChangeName()%>" class="introduceimg" id="introImg">
   <div class="attachment">
   <input type="file" name="upfile" id="inputfile" onchange="loadImg(this);">   
  <label class="attachmentbtn" for="inputfile">첨부 파일</label>
   </div>  
  </div>
    <script>
                function loadImg(inputFile){
                   
                
                	if(inputFile.files.length == 1){ 
                		
                		var reader = new FileReader();
                		
                		
                		reader.readAsDataURL(inputFile.files[0]);
                		
                		
                		reader.onload = function(e){
                			
                			
                			 $("#introImg").attr("src", e.target.result); 
                		}                		
                	}else{ 
                		
            			 $("#introImg").attr("src","<%=contextPath %>/<%=at.getFilePath() + at.getChangeName()%>");
                	}
                	
                }
            </script>
  <div class="body2">
  <hr>
  <p>
  
   <textarea placeholder="내용을 입력해주세요." maxlength="500" name="introContent"><%=intro.getIntroContent()%></textarea>
  	
  </p>  
  </div>
  <div class="foot1">
  <button type="submit" class="enrollbtn" >등록</button>
  </div>
  
  </form>
  </div>
   <%@ include file="../common/footerbar.jsp" %>

</body>
</html>