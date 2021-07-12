<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>일정관리</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    
<%-- 풀캘린더------------------------------------------------------------------------------------------------------ --%>
    <link href='${pageContext.request.contextPath}/resources/fullcalendar-5.8.0/lib/main.css' rel='stylesheet' />
    <script src='${pageContext.request.contextPath}/resources/fullcalendar-5.8.0/lib/main.js'></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
        });
        calendar.render();
      });

    </script>
   
    <style>
    	#nav{
    		width: 20%;
    		float:left;
    	}
        #calendar{
        	width: 70%;
        	margin-right:75px;
        	float:right;
        }
    </style>
</head>
<body>

    <jsp:include page="../common/header.jsp"/>
   
    
    <section>
    
	    <div class="outer">
	    	<div id="nav">
	    		<h4 style="margin-left: 30px;">일정관리</h4>
		        <button class="btn btn-primary" style="width:200px;">일정 추가</button>
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
		                <a href="" id="note-list">노트 목록</a>
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
		        <div class="table-bordered" id="do-navbar" style="width:200px; margin-top: 10px; padding: 5px;">
		            
		            <!-- 일정 카테고리 선택하는 부분 -->
		            <input type="checkbox"> 전체 <br>
		            <input type="checkbox"> 개인 <input type="color"><br> 
		            <input type="checkbox"> 팀 <br>
		            <input type="checkbox"> 회사 <br>
		            <input type="checkbox"> 비품 <br>
		            <input type="checkbox"> 회의실 <br>
		            
		        </div>
		    </div>
	        <%-- 네비바 끝 ------------------------------------------------------------------------------- --%>
	        
	        
	   		<%-- 캘린더 영역 ------------------------------------------------------------------------------- --%>
			<div id="calendar" align="center"></div>
	        
	        
	        
	    </div>
	    
	    
   </section>

</body>
</body>
</html>