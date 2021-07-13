<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노트관리</title>
<style>
	#nav{
	    width: 200px;
	    height: 1000px;
	    margin:0;
	    float: left;
	}
	
	#list-area{
	    width: 600px;
	    height: 800px;
	    margin-left: 50px;
	    float:right;
	    
	}
	
	#list-area>div{
	    width: 200px;
	    height: 300px;
	    margin: 50px;
	    background: url('${pageContext.request.contextPath}/resources/images/note.png');
	    background-size: 200px 300px;
	    background-position: center;
	    float: left;
	    position:relative;
	}
	
	#list-area>div>div{
	    position:absolute;
	}
</style>
</head>
<body>
    <!-- 
        수정해야할거.. 

        2. 노트리스트 가운데에 오게 하기
        
        3. hover속성,, 귀찬타 담에담에..

    -->

    <!-- 메뉴바 -->
    <jsp:include page="../common/header.jsp"/>

    <br><br>
    <section>
	    <div class="outer">
	        <div class="outer">
		    	<div id="nav">
		    		<b style="margin-left: 30px; font-size: 25px;">노트관리</b> 
		    		<button class="btn btn-sm btn-primary" style="margin-left: 15px;">뒤로</button>
		    		<br><br>
			        <button class="btn btn-primary" style="width:200px;" data-toggle="modal" data-target="#scAdd">노트 추가</button>
			        <br>
		    		<div class="table-bordered" id="do-navbar" style="width:200px; margin-top: 10px; padding: 5px;">
			            <b>오늘일정</b>
			            <a href=""><b style="float: right;">∨</b></a>
			            <br>
			            <!-- 체크박스 체크 시 취소선 function-->
			            <input type="checkbox"> Conference <br>
			            <input type="checkbox"> Meeting <br>
			            <input type="checkbox"> Lunch <br>
			        </div>
			        <div class="table-bordered" id="do-navbar" style="width:200px; margin-top: 10px; padding: 5px;">
			            
			            <a href=""><b style="float: right;">∨</b></a>
			            <br>
			            <label for="">
			                <a href="list.nt" id="note-list">노트 목록</a>
			            </label>
			            <br>
			            <label for="">
			                <a href="" id="note-list">업무 보고</a>
			            </label>
			            <br>
			            <label for="">
			                <a href="" id="note-list">자원 예약</a>
			            </label>
			            
			        </div>
			    </div>
		        <%-- 네비바 끝 ------------------------------------------------------------------------------- --%>
		
		        <div id="list-area" style="margin-right: 300px">
		            <div id="note1" style="display: block;">
		                <input type="checkbox">
		                <p style="margin: 5px; font-size: 11px;">
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
		                </p>
		                
		                <!-- hover시 노트 정보가 뜨도록-->
		                
		            </div>
		            <div id="noteInfo" style="margin-top:250px; height:100px; background: lightgray; opacity: 50%; display: none;">
		                <p>
					                    제목 : 노트제목 <br>
					                    최종 작성일 : 21-07-12 <br>
					                    관련일정 : 또르르 <br> <!-- 클릭 시 관련일정 뜨게?.. -->
		                    <a href="">관련일정 바로가기</a>
		                </p>
		            </div>
		            <div id="note2">
		                <input type="checkbox">
		                <p style="margin: 5px; font-size: 11px;">
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
		                </p>
		                
		                <!-- hover시 노트 정보가 뜨도록-->
		            </div>
		            <div id="note3">
		                <input type="checkbox">
		                <p style="margin: 5px; font-size: 11px;">
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
		                </p>
		                
		                <!-- hover시 노트 정보가 뜨도록-->
		            </div>
		            <div id="note4">
		                <input type="checkbox">
		                <p style="margin: 5px; font-size: 11px;">
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
					                    노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용노트내용
		                </p>
		                
		                <!-- hover시 노트 정보가 뜨도록-->
		            </div>
		        </div>
		
		
		        <div class="button-area" style="margin-left: 300px; margin-top: 50px;">
		            <button class="btn btn-primary">수정</button>
		            <button class="btn btn-danger">삭제</button>
		        </div>
		        
		        <div id="paging-area" align="center">
		            <ul class="pagination justify-content-center">
		                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
		                <li class="page-item active"><a class="page-link" href="#">1</a></li>
		                <li class="page-item"><a class="page-link" href="#">2</a></li>
		                <li class="page-item"><a class="page-link" href="#">3</a></li>
		                <li class="page-item"><a class="page-link" href="#">Next</a></li>
		            </ul>
		        </div>
	
	    </div>
	</section>
</body>
</html>