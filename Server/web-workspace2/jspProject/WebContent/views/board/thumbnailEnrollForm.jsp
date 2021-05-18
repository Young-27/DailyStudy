<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background: lightsteelblue;
        color: black;
        width: 1000px;
        height: 700px;
        margin: auto;
        margin-top: 50px;
    }
    #enroll-form table{border:1px solid black;}
    #enroll-form input, #enroll-form textarea{width:100%; box-sizing: border-box;}
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <br><h2 align="center">사진게시판 작성하기</h2><br>

        <form action="<%= contextPath %>/insert.th" id="enroll-form" method="post" enctype="multipart/form-data">
			<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
            <table align="center">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3"><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3">
                        <textarea row="5" style="resize: none;" name="content" required></textarea>
                    </td>
                    
                </tr>
                <tr>
                    <th>대표이미지</th>
                    <td colspan="3" align="center">
                        <img id="titleImg" width="250" height="170">
                    </td>
                    
                </tr>
                <tr>
                    <th>상세이미지</th>
                    <td><img id="contentImg1" width="150" height="120"></td>
                    <td><img id="contentImg2" width="150" height="120"></td>
                    <td><img id="contentImg3" width="150" height="120"></td>
                </tr>
            </table>

            <div id="file-area">
                <input type="file" id="file1" name="file1" onchange="loadImg(this, 1);" required>
                <input type="file" id="file2" name="file2" onchange="loadImg(this, 2);">
                <input type="file" id="file3" name="file3" onchange="loadImg(this, 3);">
                <input type="file" id="file4" name="file4" onchange="loadImg(this, 4);">
            </div>

            <script>
            
	            $(function(){
	        		$("#file-area").hide();
	        		
	        		$("#titleImg").click(function(){
	        			$("#file1").click();
	        		})
	        		$("#contentImg1").click(function(){
	        			$("#file2").click();
	        		})
	        		$("#contentImg2").click(function(){
	        			$("#file3").click();
	        		})
	        		$("#contentImg3").click(function(){
	        			$("#file4").click();
	        		})
	        	})
	        	
                function loadImg(inputFile, num){
                    // inputFile : 현재 변호가 생긴 input type="file" 요소객체
                    // num : 몇번째 input요소인지 확인 후 해당 그 영역에 미리보기 하기 위해서
                    //console.log(inputFile.files.length);
                
                    if(inputFile.files.length == 1){ 
                		// 선택된 파일이 존재할 경우 
                		// => 선택된 파일을 읽어들여서 그 영역에 맞는 곳에 미리보기
                		
                		// 파일을 읽어들일 FileReader 객체 생성
                		var reader = new FileReader();
                		
                		// 파일을 읽어들이는 메소드 => 해당 파일을 읽어들이는 순간 해당 그 파일만의 고유한 url 부여됨
                		reader.readAsDataURL(inputFile.files[0]);
                		
                		// 파일 읽기가 다 완료되었을 때 실행할 함수를 정의
                		reader.onload = function(e){
                			// 각 영역에 맞춰서 이미지 미리보기
                			switch(num){
	                			case 1: $("#titleImg").attr("src", e.target.result); break;
	                			case 2: $("#contentImg1").attr("src", e.target.result); break;
	                			case 3: $("#contentImg2").attr("src", e.target.result); break;
	                			case 4: $("#contentImg3").attr("src", e.target.result); break;
	                		}
                		}
                		
                	}else{ // 선택된 파일이 사라졌을 경우 => 미리보기 사라지게
                		switch(num){
	            			case 1: $("#titleImg").attr("src", null); break;
	            			case 2: $("#contentImg1").attr("src", null); break;
	            			case 3: $("#contentImg2").attr("src", null); break;
	            			case 4: $("#contentImg3").attr("src", null); break;
            			}
                	}
				}
            </script>

            <br>

            <div align="center">
                <button type="submit">등록하기</button>
            </div>

        </form>

    </div>
</body>
</html>