<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.board.model.vo.Board" %>
<% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list"); 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .outer{
        width: 1000px;
        height: 550px;
        background-color:lightsteelblue;
        color: lightyellow;
        margin: auto;
        margin-top: 50px;
    }
    .list-area{
        border: 1px solid lightyellow;
        text-align: center;
    }
    .list-area>tbody>tr:hover{
        background-color: gray;
        cursor: pointer;
    }
</style>
<body>
	
	<%@include file="../common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">일반게시판</h2>
        <br>


        <!-- 로그인한 회원만 보여지는 버튼 -->
        <% if(loginUser != null){ %>
	        <div align="right" style="width: 850px;">
	            <a href="<%= contextPath %>/enrollForm.bo" class="btn btn-secondary btn-sm">글작성</a>
	            <br><br>
	        </div>
	    <% } %>

        <table align="center" class="list-area">
            <thead>
                <tr>
                    <th width="70">글번호</th>
                    <th width="70">카테고리</th>
                    <th width="300">제목</th>
                    <th width="100">작성자</th>
                    <th width="50">조회수</th>
                    <th width="100">작성일</th>
                </tr>
            </thead>
            <tbody>
            
            	<% if(list.isEmpty()){ %>
            		<tr>
            			<td colspan="6">조회된 리스트가 없습니다.</td>
            		</tr>
            	<% } else { %>
            		<% for(Board b : list){ %>
				   		<tr>
		                    <td><%= b.getBoardNo() %></td>
		                    <td><%= b.getCategory() %></td>
		                    <td><%= b.getBoardTitle() %></td>
		                    <td><%= b.getBoardWriter() %></td>
		                    <td><%= b.getCount() %></td>
		                    <td><%= b.getCreateDate() %></td>
	                	</tr>
                	<% } %>         	
            	<% } %>
            	
            </tbody>
        </table>
        
        <script>
        	$(function(){
        		$(".list-area>tbody>tr").click(function(){
        			location.href = "<%=contextPath%>/detail.bo?bno=" + $(this).children().eq(0).text();
        		})
        	})
        
        </script>

        <br><br>

        <div align="center" class="paging-area">
			
			<% if(currentPage != 1){ %>
				<button onclick="location.href='<%=contextPath%>/list.bo?currentPage=<%=currentPage-1%>';"> &lt; </button>
			<% } %>
			
			<% for(int p=startPage; p<=endPage; p++){ %>
				
				<% if(p != currentPage){ %>
            		<button onclick="location.href='<%=contextPath%>/list.bo?currentPage=<%= p %>';"><%= p %></button>
            	<% } else { %> <!-- 지금 보고있는 페이지일 경우 클릭이 되지 않게 설정 -->
            		<button disabled><%= p %></button>
            	<% } %>	
            		
            <% } %>
            
            <% if(currentPage != maxPage){ %>
            	<button onclick="location.href='<%=contextPath%>/list.bo?currentPage=<%=currentPage+1%>';"> &gt; </button>
            <% } %>
			
        </div>
        
        
        
        <div style="display:none"> <!-- 내가 해본거,, -->
        	<% if(pi.getStartPage() != 1){ %> <!-- 왼쪽버튼 눌렀을때 빈페이지가 뜨지 않도록 조건설정 -->
            	<button> <a href="<%=contextPath + "/list.bo?currentPage=" + (pi.getStartPage() - 1)%>">&lt;</a> </button>
            <% } else { %>
            	<button> <a href="<%=contextPath + "/list.bo?currentPage=" + (pi.getStartPage())%>">&lt;</a> </button>
            <% } %>
			
			
			<!-- 최대 페이징 수(10) 만큼 버튼이 반복되게 하기 -->
			<% for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++){ %> 
            	<button><a href="<%=contextPath + "/list.bo?currentPage=" + i%>"><%=i%></a></button>
            <% } %>
            
            
            
            <% if((pi.getEndPage()+1) <= pi.getMaxPage()){ %> <!-- 오른쪽버튼 눌렀을때 빈페이지가 뜨지 않도록 조건설정 -->
            	<button> <a href="<%=contextPath + "/list.bo?currentPage=" + (pi.getEndPage() + 1)%>"> &gt; </a> </button>
            <% } else { %> 
				<button> <a href="<%=contextPath + "/list.bo?currentPage=" + (pi.getEndPage())%>"> &gt; </a> </button>
			<% } %>
        </div>

    </div>
	
</body>
</html>