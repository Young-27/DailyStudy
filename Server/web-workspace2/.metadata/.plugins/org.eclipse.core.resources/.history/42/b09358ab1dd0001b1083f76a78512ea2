<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.notice.model.vo.Notice"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background: lightblue;
        color: cornsilk;
        width: 1000px;
        height: 500px;
        margin: auto;
        margin-top: 50px;
    }
    .list-area{
        border: 1px solid white;
        text-align: center;
    }
    .list-area>tbody>tr:hover{
        background: lightgrey;
        cursor:pointer;
    }
</style>
</head>
<body>
	
	<%@ include file ="../common/menubar.jsp" %>

    <div class="outer">

        <br>
        <h2 align="center">공지사항</h2>
        <br>
	
		<!-- 현재 로그인한 사용자가 관리자일 경우 -->
		<!-- 로그인 유저가 널일경우 => 널포인트오류 발생 !! -->
		<!-- if && 조건은 첫번째 조건이 false일 경우 두번째 조건은 검사도 안하고 넘어감 -->
		<% if(loginUser!=null &&loginUser.getUserId().equals("admin")){ %>
	        <div align="right" style="width: 850px;">
	            <!-- <button onclick="location.href='';">글작성</button>  -->
	            <!-- a태그를 부트스트랩을 이용해서 버튼으로 만들기! -->
			    <a href="<%= contextPath %>/enrollForm.no" class="btn btn-secondary btn-sm">글작성</a>
	            <br><br>
	        </div>
		<% } %>

        <table class="list-area" align="center">

            <thead>
                <tr>
                    <th>글번호</th>
                    <th width="400">글제목</th>
                    <th width="100">작성자</th>
                    <th>조회수</th>
                    <th width="100">작성일</th>
                </tr>
            </thead>
            <tbody>
            	
            	<% if(list.isEmpty()){ %>
            		<!-- 리스트가 비어있을 경우 -->
            		<tr>
            			<td colspan="5">존재하는 공지사항이 없습니다.</td>
            		</tr>
            	<% } else { %>
            		<!-- 리스트가 비어있지 않을 경우 -->
            		<% for(Notice n : list) { %>
            		<tr>
	                    <td><%= n.getNoticeNo() %></td>
	                    <td><%= n.getNoticeTitle() %></td>
	                    <td><%= n.getNoticeWriter() %></td>
	                    <td><%= n.getCount() %></td>
	                    <td><%= n.getCreateDate() %></td>
                	</tr>
                	<% } %>
            	<% } %>
            
                
            </tbody>

        </table>


    </div>
    <script>
    	$(function(){
    		$(".list-area>tbody>tr").click(function(){
    			//console.log("클릭됨");
    			var nno = $(this).children().eq(0).text(); 
    			//console.log(nno);
    			
    			// 요청할url?키=밸류&키=밸류	=> 요청시 전달값(?키=밸류) == 쿼리스트링
    			// /jsp/detail.no?nno=클릭했을때의글번호
    			location.href = '<%=contextPath%>/detail.no?nno=' + nno;
    		})
    		
    		
    	})
    	
    
    </script>


	
</body>
</html>