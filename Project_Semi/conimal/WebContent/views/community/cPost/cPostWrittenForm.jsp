<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>
</head>
<body>
	<%@ include file="../../common/menubar.jsp" %>
			<div class="outer">
        <br>
        <h6 style="margin-left: 10px;">커뮤니티 > 자유게시판</h6>
       
        <h5 style="text-align:left; font-weight: bolder; margin-left: 10px;"> 자유게시판</h5>
        <p style="margin-left: 10px;">이곳은 회원들이 자유롭게 글을 작성할 수 있는 자유게시판입니다.</p>
        <br>

        <div class="inner">
            <form id="cPostConF" action="<%=contextPath%>/insert.cp" method="post" enctype="multipart/form-data">
            	<input type="hidden" name="memNo" value="<%=loginUser.getMemNo()%>">
				<input type="hidden" name="memName" value="<%=loginUser.getMemName()%>">
				
				<div id="titleBar">
                	 제목 <input name="cPostTitle" type="text" id="cPostTitle" placeholder="제목을 입력하세요." required>
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
	                <input style="margin-left:680px;" type="file" id="file1" name="file1" onchange="loadImg(this, 1);"required>
	            </div>
                <br><br>
                <textarea name="content" style="margin-left: 20px; width:900px; height:300px"  required>
                
                    
                </textarea>
                <br><Br>
                <h6 style="margin: auto; text-align: center;">게시글 작성 시 회원님의 소중한 개인정보가 포함되지 않도록 주의 부탁드립니다.</h6>
                <br><br>
                
                <button type="reset" id="cPostCan" class="submitB" style=" text-align:center; width: 70px; height:25px; font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 취소 </button>
                
                <!--처음에 글 작성할 때 그리고 수정할 때 모두 활성화되는 버튼임!-->
                <button type="submit" id="cPostEnroll" type="submit" class="submitB" style=" text-align:center; width: 80px; height:28px; font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 등록하기 </button>
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




	<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>