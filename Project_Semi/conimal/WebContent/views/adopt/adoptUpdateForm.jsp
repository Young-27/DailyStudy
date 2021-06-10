<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList, com.kh.adopt.model.vo.*"%>   
<%
	Adopt a =(Adopt)request.getAttribute("a");
	// 번호, 작성자, 제목, 내용, 조회수, 작성일 ?0? 이거 어디서 담아온건데?
	Attachment at = (Attachment)request.getAttribute("at");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
	    margin-top: 50px;
	    margin-bottom: 50px;
	    margin: auto;
	    width: 950px;
	}
	#toolbar{
	    background: lightgray; 
	    width: 900px; 
	    height: 35px;
	    text-align: center;
	    vertical-align: middle;
	    margin: auto;
	}
	.inner{
	    margin: auto;
	   
	
	}
	#adoptImg>img{
	    box-sizing: border-box;
	    width: 900px;
	    height: 300px;
	    border: 1px solid lightgray;
	    margin-left:20px;
	}
	#delBtn,#fileBtn{
	    float: right;
	}
	#delBtn{margin-right: 35px;}
	#fileBtn{margin-right: 10px;}
	#adoptCan,#adoptDel{
	    float: left;
	    margin-left: 10px;
	}
	#adoptEnroll{
	    margin-left: 320px;
	    position: absolute;
	}
	#adoptTitle{
		width: 520px;
	    margin-left: 13px;
	    height: 25px;
	}
	#textA{
		margin:auto;
		text-align:center;
	}
	#adoptConF{
		margin-left:15px;
	}
	#titleBar{
		margin-left: 20px;
	}
	textarea{
		resize: vertical;
</style>
</head>
<body>

<%@ include file="../common/menubar.jsp" %>

	   <div class="outer">
        <br>
        <h6 style="margin-left: 10px;">입양후기 > 입양후기 작성 </h6>
       
        <h5 style="text-align:left; font-weight: bolder; margin-left: 10px;"> 입양후기 작성 </h5>
        <p style="margin-left: 10px;">이곳은 회원들이 자유롭게 글을 작성할 수 있는 자유게시판입니다.</p>
        <br>

        <div class="inner">
            <form id="adoptConF" action="<%=contextPath%>/update.ad" method="post" enctype="multipart/form-data">
            	<input type="hidden" name="ano" value="<%=a.getAdoptNo()%>">
            	<input type="hidden" name="adoptWriter" value="<%=loginUser.getMemNo()%>">
            	<input type="hidden" name="memNo" value="<%=a.getMemNo()%>">
				<input type="hidden" name="memName" value="<%=loginUser.getMemName()%>">
				
				<div id="titleBar">
                	 제목 <input style="margin-right:10px;" name="adoptTitle" type="text" id="adoptTitle" value="<%= a.getAdoptTitle() %>" required>
               		 <!--  
               		 보호소 번호만 가지고는 여기서 %를 이용한 구문으로 보호소 명을 가져올 수 가 없음
               		 따라서 shelter라는 객체를 생성해서 가져와서 써야만함 마치 loginUser 처럼!!
           	 	보호소명 <select name="shelterNo">
           	 			checked되었던 보호소명이 뜰 수 있도록 하던가 아니면 아예 수정이 불가능하게 하던가
           	 			<option value="도그보호소">도그보호소</option>
           	 			<option>마루보호소</option>
           	 
           	 	   	  </select>
           	 	    -->
			   </div>
           	      
                <br><br>
                <div id="toolbar" >
                    
                </div>
                <br>

                <div id="adoptImg" style="margin: auto;">
                    <img src="" id="mainImg" >
                    <br><Br>
                </div>
                <div id="fileBtn">
                	<%if(at != null){ %>
                           <%= at.getOriginName() %>(사진을 수정하고자 한다면 이미지 부분을 클릭해주세요.)
		            		<input type="hidden" name="originFileNo" value="<%=at.getFileNo()%>">
                            <input type="hidden" name="originFileName" value="<%=at.getChangeName()%>">
                   <% } %> 
                 <br>
	                <input style="margin-left:680px;" type="file" id="file1" name="file1" onchange="loadImg(this, 1);"required>
	            </div>
                <br><br>
               
                <textarea name="content" style="margin-left: 20px; width:900px; height:300px" required>
                    <%=a.getAdoptContent() %>
                </textarea>
                <br><br>
                <h6 style="margin: auto; text-align: center;">게시글 작성 시 회원님의 소중한 개인정보가 포함되지 않도록 주의 부탁드립니다.</h6>
                <br>
                
                <button  type="reset" id="adoptCan" class="submitB" style=" text-align:center; width: 70px; height:25px; font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 취소 </button>
                
                <button id="adoptEnroll" type="submit" class="submitB" style=" text-align:center; width: 80px; height:28px; font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 등록하기 </button>
                <Br>
				
				<script>
					$(function(){
						$(".fileBtn").hide();
						
						$("#mainImg").click(function(){
							$("#file1").click();
						})
					})
					
				</script>
				<script>
					function loadImg(inputFile, num){
						
						if(inputFile.files.length == 1){	// 선택된 파일이 존재할 경우
                    										// => 선택된 파일을 읽어들여서 그 영역에 맞는 곳에 미리보기
                    		// 파일을 읽어들일 FileReader 객체 생성
                    		var reader = new FileReader();
                    			
                    		// 파일을 읽어들이는 메소드 => 해당 파일을 읽어들이는 순간 해당 그 파일만의 고유한 url부여됨
                    		reader.readAsDataURL(inputFile.files[0]);
                    		
                    		// 파일 읽기가 다 완료되었을 때 실행할 함수를 정의
                    		reader.onload = function(e){
                    			// 각 영역에 맞춰서 이미지 미리보기 
                    			switch(num){
                    			case 1 :$("#mainImg").attr("src", e.target.result);break;
                    			}
                    		}
                    	}else{	// 선택된 파일이 사라졌을 경우 => 미리보기 사라지게 함
                    		switch(num){
                			case 1 :$("#mainImg").attr("src", null);break;
                    		}
                    	
						}
					}
				
				</script>

            </form>

        </div>

    </div>
    <Br>


	<%@ include file="../common/footerbar.jsp" %>







</body>
</html>