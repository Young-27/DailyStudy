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
    
    
   
    <style>
    	#nav{
    		width: 20%;
    		float:left;
    	}
        
    </style>
</head>
<body>

    <jsp:include page="../common/header.jsp"/>
   
    
    <section>
    
	    <div class="outer">
	    	<div id="nav">
	    		<b style="margin-left: 30px; font-size: 25px;">일정관리</b>
		        <button class="btn btn-primary" style="width:200px;" data-toggle="modal" data-target="#scAdd">일정 추가</button>
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
		        <div class="table-bordered" id="do-navbar" style="width:200px; margin-top: 10px; padding: 5px;">
		            <b>필터</b>
		            <br>
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
			<jsp:include page="fullcalendar.jsp"/>
	        
	        <%-- 일정추가 (모달창) -------------------------------------------------------------------------------%>
	        <form action="일정추가url">
				<!-- The Modal -->
				<div class="modal" id="scAdd">
				  <div class="modal-dialog modal-lg">
				    <div class="modal-content">
				
				      <!-- Modal Header -->
				      <div class="modal-header">
				        <h4 class="modal-title">일정 추가</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
				
				      <!-- Modal body -->
				      <div class="modal-body">
					    <table class="" align="center">
					        <tr>
					            <th width="120px">일정 제목</th>
					            <td colspan="2"><input type="text" name="scheduleTitle" style="width: 380px;" placeholder="일정 제목을 입력해주세요"></td>
					            <td>
					                <select name="scType" id="scType">
					                    <option value="personal">개인</option>
					                    <option value="dep">부서</option>
					                    <option value="com">회사</option>
					                </select>
					            </td>
					        </tr>
					        
					        <tr>
					            <th>시작일</th>
					            <td><input type="date" name="startDate"></td>
					            <td><input type="text" name="startTime"></td>
					            <td rowspan="2"><input type="checkbox">시간설정</td> <!-- 시간설정 체크 해제시 시간 input 사라지게 / 기본값: 체크설정-->
					        </tr>
					        <tr>
					            <th>종료일</th>
					            <td><input type="date" name="endDate"></td>
					            <td><input type="text" name="endTime"></td>
					        </tr>
					        <tr>
					            <th>내용</th>
					            <td colspan="2"><textarea name="sheduleContent" id="" cols="50" rows="10" style="resize: none;"></textarea></td>
					        </tr>
					
					    </table>
					    
				      </div>
				
				      <!-- Modal footer -->
				      <div class="modal-footer center">
					      <div class="button-area">
						        <button class="btn btn-secondary" data-dismiss="modal">취소</button>
						        <button class="btn btn-primary" type="submit">저장</button>
						  </div>
				      </div>
				
				    </div>
				  </div>
				</div>
	        </form>
	        
	    </div>
	    
   </section>

</body>
</body>
</html>