<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/header.jsp"/>
	
	
	<div class="content">
        <br><br>
        <div class="innerOuter" style="padding:5% 10%;">
        
        	<a href="testEnroll1.do">다수의 객체정보 작성하기 페이지테스트1</a>
        	<br>
        	<a href="testEnroll2.do">다수의 객체정보 작성하기 페이지테스트2</a>
        
            <h4>게시글 Top5</h4>
            <br>
            <!-- 로그인후 상태일 경우만 보여지는 글쓰기 버튼-->
            <a class="btn btn-secondary" style="float:right" href="list.bo">더보기</a>
            <br><br>
            <table id="boardList" class="table table-hover" align="center">
                <thead>
                  <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>첨부파일</th>
                  </tr>
                </thead>
                <tbody>
                    <!-- 현재 조회수가 가장 높은 상위 5개의 게시글 조회해서 뿌리기 (ajax) -->
                </tbody>
            </table>
            <br>
        </div>
        <br><br>
    </div>
    <script>
    	$(function(){
    		topBoardList();
    		
    		setInterval(topBoardList, 1000);
    		
    		/* => 이방법으로는 동적으로 만들어진 요소에 이벤트 부여 불가
    		$("#boardList tbody tr").click(function(){
    			location.href = "detail.bo?bno=" + $(this).children(".bno").text();
    		})
    		*/
    		
    		// 다음과 같은 방법으로만 동적으로 만들어진 요소에 이벤트 부여 가능
    		$(document).on("click", "#boardList tbody tr", function(){
    			location.href = "detail.bo?bno=" + $(this).children(".bno").text();
    		})
    		
    	})
    	
    	function topBoardList(){
    		$.ajax({
    			url:"topList.bo",
    			success:function(list){
    				var value = "";
    				
    				for(var i in list){
    					value += '<tr>'
			                       + '<td class="bno">' + list[i].boardNo + '</td>'
			                       + '<td>' + list[i].boardTitle + '</td>'
			                       + '<td>' + list[i].boardWriter + '</td>'
			                       + '<td>' + list[i].count + '</td>'
			                       + '<td>' + list[i].createDate + '</td>'
			                       + '<td>';
			                       
			            if(list[i].originName != null){
			            	value += "★";
			            }
			                        	
			            value += '</td></tr>';
    				}
    				
    				$("#boardList tbody").html(value);
    				
    			},error:function(){
    				console.log("조회수 top5 조회용 ajax 통신 실패");
    			}
    		})
    	}
    </script>
	
	
	<jsp:include page="common/footer.jsp"/>
</body>
</html>