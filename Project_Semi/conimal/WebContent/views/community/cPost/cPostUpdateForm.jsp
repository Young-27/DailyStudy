<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList, com.kh.community.cPost.model.vo.*"%> 
<%
	Cpost c =(Cpost)request.getAttribute("c");
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
		margin-right: 30px;;
	}
	.inner{
	    margin: auto;
	   
	
	}
	#cPostImg>img{
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
	#cPostCan,#cPostDel{
	    float: left;
	    margin-left: 10px;
	}
	#cPostEnroll{
	    margin-left: 250px;
	    position: absolute;
	}
	#cPostTitle{
	    width: 820px;
	    margin-left: 13px;
	    height: 25px;
	}
	#titleBar{
		margin-left: 20px;
	}
	textarea{
		resize: vertical;
	}
	#cPostDel{
		text-align:center; 
		width: 70px; 
		height:25px; 
		font-size:13px;
		background:lightgray;
		border: 25px; 
		border-radius:3px;
	}
	#fileBtn{
		margin:auto;
		width :900px;
		margin-left: 750px;
		text-align:center;
		vertical-align : middle;
	
	}
</style>
</head>
<body>
		<%@ include file="../../common/menubar.jsp" %>
				<div class="outer">
	        <br>
	        <h6 style="margin-left: 10px;">커뮤니티 > 자유게시판</h6>
	       
	        <h5 style="text-align:left; font-weight: bolder; margin-left: 10px;"> 자유게시판 수정 페이지</h5>
	        <p style="margin-left: 10px;">이곳은 자유게시판에 작성된 게시글을 수정하는 페이지입니다..</p>
	        <br>
	
	        <div class="inner">
	            <form action="<%=contextPath%>/update.cp" id="cPostConF" method="POST" enctype="multipart/form-data">
	            	<input type="hidden" name="cno" value="<%= c.getcPostNo() %>">
	            	<input type="hidden" name="memNo" value="<%=loginUser.getMemNo()%>">
					<input type="hidden" name="memName" value="<%=loginUser.getMemName()%>">
					
					<div id="titleBar">
	                	 제목 <input name="cPostTitle" type="text" id="cPostTitle" value="<%=c.getcPostTitle() %>" required>
	               		 <br><br>
				   </div>
	                <div id="toolbar" >
	                    
	                </div>
	                <br>
	
	                <div id="cPostImg" style="margin: auto;">
	                    <img src="" id="mainImg">
	                    <br><Br>
	                    
	                </div>
	                <div id="fileBtn">
	                <%if(at != null){ %>
                           <%= at.getOriginName() %>(사진을 수정하고자 한다면 이미지 부분을 클릭해주세요.)
		            		<input type="hidden" name="originFileNo" value="<%=at.getFileNo()%>">
                            <input type="hidden" name="originFileName" value="<%=at.getChangeName()%>">
                   <% } %> 
                   <Br>
		                <input style="margin-left:680px;" type="file" id="file1" name="reUpfile1" onchange="loadImg(this, 1);"required>
		            </div>
	                <br><br><br>
	                <textarea name="content" style="margin-left: 20px;" cols="115" rows="10">
	                	<%=c.getcPostContent() %>
	                </textarea>
	                <br><Br>
	                <h6 style="margin: auto; text-align: center;">게시글 작성 시 회원님의 소중한 개인정보가 포함되지 않도록 주의 부탁드립니다.</h6>
	                <br><br>
	                <!--이거는 본인 게시글을 수정하려고 하는 경우에만 활성화됨!-->
	                <button type="reset" id="cPostCan" class="submitB" style=" text-align:center; width: 70px; height:25px; font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 취소 </button>
	                <button onclick="deleteCpost();" id="cPostDel" class="submitB" > 삭제 </button>
	                
	                <!--처음에 글 작성할 때 그리고 수정할 때 모두 활성화되는 버튼임!-->
	                <button type="submit" id="cPostEnroll" type="submit" class="submitB" style=" text-align:center; width: 80px; height:28px; font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 등록하기 </button>
	                <Br>
					<script>
						$(function(){
							$("#file1").hide();
							
							$("#mainImg").click(function(){
								$("#file1").show();
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
						
						function deleteCpost(){
	            			if(confirm('게시글을 정말 삭제하시겠습니까? 확인버튼 클릭 이후 게시글 복구는 불가능합니다.')){
	            				location.href="<%=contextPath%>/deleteForm.cp?cno=<%=c.getcPostNo()%>";
	            			}else{
	            				location.href ="<%=contextPath%>/list.cp?currentPage=1"
	            			}
	            	   }
					</script>
	
	
	
	
	
	
	
	            </form>
	
	        </div>
	
	    </div>
	    <Br>
	<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>