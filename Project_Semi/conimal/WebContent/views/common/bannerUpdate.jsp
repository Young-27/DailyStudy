<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.attachment.model.vo.Attachment"%>
    <% 
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
        margin-top:30px;
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
  

	
	.attachment{
	width:1200px;
	height:40px;
	margin-top:30px;		
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
	 border-radius:4px;
	 border:0px;
	
	}
	#inputfile{
	display:none;
	
	}
	.bannerImg{
	width:1835px;
	height:240px;
	}
	.enrollbtn{
	margin-top:130px;
	}
</style>
</head>
<body>
  <%@ include file="../common/menubar.jsp" %>
  <div class="body">  
 
  <div class="head1">
   <br><h2 align="center">배너 등록</h2><br> 
  </div>
  <div class="bannerImg">
    <img src="<%=contextPath %>/<%=at.getFilePath() + at.getChangeName()%>" id="BannerImg" width= "1200px"  height= "235px">
   </div>
    
   <form id ="updatebanner" action="<%=contextPath%>/bannerUpdateController.main" method="post" enctype="multipart/form-data">  
	<div class="body1" align="center">

   <div class="attachment">
   <input type="file" name="upfile" id="inputfile" onchange="loadImg(this);">   
  <label class="attachmentbtn" for="inputfile">이미지 변경</label>
  
   </div>  
    <button type="submit" class="enrollbtn">등록</button>
  </div>
    <script>
                function loadImg(inputFile){
                   
                
                	if(inputFile.files.length == 1){ 
                		
                		var reader = new FileReader();
                		
                		
                		reader.readAsDataURL(inputFile.files[0]);
                		
                		
                		reader.onload = function(e){
                			
                			
                			 $("#BannerImg").attr("src", e.target.result); 
                		}                		
                	}else{ 
                		
            			 $("#BannerImg").attr("src","<%=contextPath %>/<%=at.getFilePath() + at.getChangeName()%>");
                	}
                	
                }
            </script> 
  
  </form>
  </div>
   <%@ include file="../common/footerbar.jsp" %>

</body>
</html>