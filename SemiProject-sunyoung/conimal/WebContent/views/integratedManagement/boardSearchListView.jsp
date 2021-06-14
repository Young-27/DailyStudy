<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page 
	import="java.util.ArrayList, com.kh.common.model.vo.PageInfo,
			com.kh.board.model.vo.Board"
%>
<%
	ArrayList<Board> searchList = (ArrayList<Board>)request.getAttribute("searchList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	String keyword = (String)request.getAttribute("keyword");
	
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
<style>
    .outer{
		margin-top:50px;
		margin:auto;
		width: 1000px;
		height: 1200px;
        
	}
    .outer>h2{
        text-align: left;
    }
    table{
    	width: 700px;
    }
    .pagination{
    	display: block;
    	text-align: center;
    }
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<%@ include file="../common/adminPageNavibar.jsp" %>
	<div class="outer" align="center">
		<br>
        <div data-text-content="true" style="font-size: 16px; font-weight: bold; color: rgb(127, 127, 127);" class="text-left" spellcheck="false">통합 관리&gt; 게시판 글 조회</div>
        <div data-text-content="true" style="font-weight: bold; font-size: 32px; color: rgb(127, 127, 127);" class="text-left" spellcheck="false">게시판 글 조회</div>
        <!-- 
			게시판 글 검색기능--------------------------------------------------------------------------------------- 
		    http://localhost:8888/conimal/list.me?search_op=id&keyword=dd
		-->
		<nav class="navbar navbar-dark justify-content-center">
			<form class="form-inline" action="<%=contextPath%>/listSearch.bo" method="post">
				<div class="search">
					<input type="hidden" name="currentPage" value="1">
					<input type="text" name="keyword" class="form-control mr-sm-2" placeholder="검색할 게시글 제목을 입력하세요." value="<%if(keyword!=null){ %><%=keyword%><%}%>" style="width:500px">
					<button class="btn" type="submit" style="background-color: rgb(187, 208, 227)">검색</button>
				</div>
			</form>
		</nav>
        
	    <div class="container">
	      
	        
	          <div class="container"><br>
	            <table border="1" class="list-area table table-bordered" align="center">
		            
		            		<%if(searchList.isEmpty()){ %>
			            		<tr>
			            			<td colspan="6">검색 결과가 없습니다.</td>
			            		</tr>
		            		<%} else { %>
		            			<thead class="thead-light text-center">
						            <tr>
						                <th>No</th>
						                <th>게시판 이름</th>
						                <th width="400">제목</th>
						                <th>작성자</th>
						                <th>작성날짜</th>
						                <th>조회수</th>
						            </tr>
				            	</thead>
				            	<tbody class="text-center">
		            			<% for(Board b : searchList){ %>
			            			<tr>
						                <td><%=b.getBno() %></td>
						                <% if(b.getbRefType().equals("POST")){ %>
						                	<td>자유게시판</td>
						                <% }else if(b.getbRefType().equals("ANIMAL")){ %>
				                			<td>보호중인 아이들</td>
					                	<% }else if(b.getbRefType().equals("ADOPT")){ %>
					                		<td>입양 후기</td>
					                	<% }else if(b.getbRefType().equals("DONATION")){ %>
					                		<td>후원</td>
					                	<% }else if(b.getbRefType().equals("VOLUNTEER")){ %>
					                		<td>자원봉사</td>
					                	<% } else {%>
					                		<td></td>
					                		<td></td>
					                	<% } %>
						                <td><%=b.getbTitle() %></td>
						                <td><%=b.getbWrtier() %></td>
						                <td><%=b.getbDate() %></td>
						                <td><%=b.getbCount() %></td>
				            		</tr>
			            		<% } %>
			            	<% } %>
		            </tbody>
	        	</table>
	          </div>
	          
	        	<!-- 
					페이징바--------------------------------------------------------------------------------------- 
				-->
				<br>
				<div align="center" class="paging-area">
				  <ul class="pagination justify-content-center" align="center">
				  	<% if(currentPage != 1){ %>
				    	<li class="page-item"><a class="page-link" href="<%=contextPath%>/listSearch.bo?currentPage=<%=currentPage-1%>&keyword=<%=keyword%>">Previous</a></li>
				    <% }else{ %>
				    	<li class="page-item disabled"><a class="page-link" href="<%=contextPath%>/listSearch.bo?currentPage=<%=currentPage%>&keyword=<%=keyword%>">Previous</a></li>
				    <% } %>
				    
				    <% for(int p=startPage; p<=endPage; p++){ %>
				    	<%if(currentPage == p){ %>
				    		<li class="page-item active"><a class="page-link" href="<%=contextPath%>/listSearch.bo?currentPage=<%= p %>&keyword=<%=keyword%>"><%= p %></a></li>
				    	<% }else{ %>
				    		<li class="page-item"><a class="page-link" href="<%=contextPath%>/listSearch.bo?currentPage=<%= p %>&keyword=<%=keyword%>"><%= p %></a></li>
				    	<% } %>
				    <% } %>
				    
				    <% if(currentPage != maxPage){ %>
				    	<li class="page-item"><a class="page-link" href="<%=contextPath%>/listSearch.bo?currentPage=<%=currentPage+1%>&keyword=<%=keyword%>">Next</a></li>
				    <% }else{ %>
				    	<li class="page-item disabled"><a class="page-link" href="<%=contextPath%>/listSearch.bo?currentPage=<%=currentPage%>&keyword=<%=keyword%>">Next</a></li>
				    <% } %>
				  </ul>
				</div>
	        </div>
	      </div>
        <br>

        <br>
    </div>
    <%@ include file="../common/footerbar.jsp" %>
</body>
</html>