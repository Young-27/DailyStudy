<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.Member,
	com.kh.common.model.vo.PageInfo" %>
<%
	//ArrayList<Member> searchList = (ArrayList<Member>)request.getAttribute("searchList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Member> searchList = (ArrayList<Member>)request.getAttribute("searchList");
	
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
		margin: auto;
		width: 1000px;
		height: 1300px;
		position: relative;
	}
    table{
    	width: 700px;
    }
    .pagination{
    	display: block;
    	text-align: center;
    }
    .pagination>li>a{
    	float:none;
    }
    .list-area>tbody>tr:hover{
	   	cursor: pointer;
		background: gainsboro;
    }
</style>
</style>
</head>
<body>
	<%@ include file="../common/adminPageNavibar.jsp" %>
	<%@ include file="../common/menubar.jsp" %>
    

    <div class="outer" align="center">
		<br>
        <div data-text-content="true" style="font-size: 16px; font-weight: bold; color: rgb(127, 127, 127);" class="" spellcheck="false">통합 관리&gt; 회원 조회</div>
        <div data-text-content="true" style="font-weight: bold; font-size: 32px; color: rgb(127, 127, 127);" class="" spellcheck="false">회원 조회</div>
		<br>
		<!-- 
			회원 검색기능---------------------------------------------------------------------------------------
		!--> 
		<nav class="navbar navbar-dark justify-content-center">
			<form class="form-inline" action="<%=contextPath%>/listSearch.me" method="post">
				<div class="search">
					<input type="hidden" name="currentPage" value="1">
					<input type="text" name="keyword" class="form-control mr-sm-2" placeholder="검색할 아이디를 입력하세요" style="width:300px">
					<button type="submit" class="btn" style="background-color: rgb(187, 208, 227)">검색</button>
				</div>
			</form>
		</nav>
        <br>
	
		<div id=list-area class=table-responsive-sm>
			<table border="1" class="list-area table table-bordered" align="center">
				<% if(searchList.isEmpty()) { %>
					<tr>
						<td colspan="6">조회된 회원이 없습니다.</td>
					</tr>
				<% } else { %>
					<thead class="thead-light text-center">
						<tr>
							<th>No</th>
							<th>회원정보</th>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>가입일</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<% for (Member m : searchList) { %>
							<tr>
								<td><%=m.getMemNo()%></td>
								<td>
									<% if(m.getMemCode() == 1){ %>
										관리자
									<% }else if(m.getMemCode() == 2){ %>
										보호소
									<% }else{ %>
										일반회원
									<% } %>
								</td>
								<td><%=m.getMemId()%></td>
								<td><%=m.getMemName()%></td>
								<td><%=m.getEmail()%></td>
								<td><%=m.getEnrollDate()%></td>
							</tr>
						<% } %>
					</tbody>
					
				<% } %>
			</table>
		</div>
		<br>
		<script>
			$(function(){
	    		$(".list-area>tbody>tr").click(function(){
	    			location.href = "<%=contextPath%>/detail.me?mno=" + $(this).children().eq(0).text();
	    		})
			})
 		</script>
		
		
		<!-- 
			페이징바--------------------------------------------------------------------------------------- 
		-->
		<div align="center" class="paging-area text-center">
			
			  <ul class="pagination justify-content-center" align="center">
			  	<% if(currentPage != 1){ %>
			    	<li class="page-item"><a class="page-link" href="<%=contextPath%>/listSearch.me?currentPage=<%=currentPage-1%>">Previous</a></li>
			    <% }else{ %>
			    	<li class="page-item disabled"><a class="page-link" href="<%=contextPath%>/listSearch.me?currentPage=<%=currentPage-1%>">Previous</a></li>
			    <% } %>
			    
			    <% for(int p=startPage; p<=endPage; p++){ %>
			    	<%if(currentPage == p){ %>
			    		<li class="page-item active"><a class="page-link" href="<%=contextPath%>/listSearch.me?currentPage=<%= p %>"><%= p %></a></li>
			    	<% }else{ %>
			    		<li class="page-item"><a class="page-link" href="<%=contextPath%>/listSearch.me?currentPage=<%= p %>"><%= p %></a></li>
			    	<% } %>
			    <% } %>
			    
			    
			    <% if(currentPage != maxPage){ %>
			    	<li class="page-item"><a class="page-link" href="<%=contextPath%>/listSearch.me?currentPage=<%=currentPage+1%>">Next</a></li>
			    <% }else{ %>
			    	<li class="page-item disabled"><a class="page-link" href="<%=contextPath%>/listSearch.me?currentPage=<%=currentPage+1%>">Next</a></li>
			    <% } %>
			  </ul>
		</div>
		<%@ include file="../common/footerbar.jsp" %>
	</div>
	
</body>
</html>