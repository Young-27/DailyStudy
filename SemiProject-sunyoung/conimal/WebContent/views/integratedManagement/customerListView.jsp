<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.customer.model.vo.Customer, com.kh.common.model.vo.PageInfo" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Customer> list = (ArrayList<Customer>)request.getAttribute("list");
	
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
		width: 900px;
		height: 1200px;
	}
    .outer>h2{
        text-align: left;
    }
    table{
    	width: 700px;
    }
    .paging-area{
    	text-align: center;
    	margin: auto;
    }
    .list-area>tbody>tr:hover{
    	cursor: pointer;
		background: gainsboro;
    }
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<%@ include file="../common/adminPageNavibar.jsp" %>
	
    <div class="outer" align="center">
        <br>
        <div data-text-content="true" style="font-size: 16px; font-weight: bold; color: rgb(127, 127, 127);" class="text-left" spellcheck="false">통합 관리&gt; 1:1문의</div>
        <div data-text-content="true" style="font-weight: bold; font-size: 32px; color: rgb(127, 127, 127);" class="text-left" spellcheck="false">1:1문의</div>
        <br>
        <div class=table-responsive-sm>
	        <table class="list-area table table-bordered" border="1" align="center">
	        	<% if(list.isEmpty()){ %>
	        		<tr>
	                	<td colspan="5">조회된 회원이 없습니다.</td>
	            	</tr>
	            <% }else{ %>
		            <thead class="thead-light text-center">
			            <tr>
			                <th>No</th>
			                <th>제목</th>
			                <th>작성자</th>
			                <th>문의날짜</th>
			                <th>상태</th>
			            </tr>
		            </thead>
		            <tbody class="text-center">
		            	<% for(Customer c : list){ %>
			            	<tr>
				                <td><%=c.getQueNo() %></td>
				                <td><%=c.getQueTitle() %></td>
				                <td><%=c.getQueId() %></td>
				                <td><%=c.getQueDate() %></td>
				                <td>
				                	<% if(c.getAnsStatus().equals("N")){ %>
				                		<label style="color: red;">처리중</label>
				                	<% }else{ %>
				                		<label style="font-weight:bold">답변완료</label>
				                	<% } %>
				                </td>
		            		</tr>
		            	<% } %>
		            </tbody>
	            <% } %>
	        </table>
	    </div>
        <br>

        <!-- 
			페이징바--------------------------------------------------------------------------------------- 
		-->
		<div align="center" class="paging-area text-center">
			
			  <ul class="pagination justify-content-center" align="center">
			  	<% if(currentPage != 1){ %>
			    	<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.cu?currentPage=<%=currentPage-1%>">Previous</a></li>
			    <% }else{ %>
			    	<li class="page-item disabled"><a class="page-link" href="<%=contextPath%>/list.cu?currentPage=<%=currentPage%>">Previous</a></li>
			    <% } %>
			    
			    <% for(int p=startPage; p<=endPage; p++){ %>
			    	<%if(currentPage == p){ %>
			    		<li class="page-item active"><a class="page-link" href="<%=contextPath%>/list.cu?currentPage=<%= p %>"><%= p %></a></li>
			    	<% }else{ %>
			    		<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.cu?currentPage=<%= p %>"><%= p %></a></li>
			    	<% } %>
			    <% } %>
			    
			    <% if(currentPage != maxPage){ %>
			    	<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.cu?currentPage=<%=currentPage+1%>">Next</a></li>
			    <% }else{ %>
			    	<li class="page-item disabled"><a class="page-link" href="<%=contextPath%>/list.cu?currentPage=<%=currentPage%>">Next</a></li>
			    <% } %>
			  </ul>
		</div>
        
        <br>
    </div>
    
    <script>
    	$(function(){
    		$(".list-area>tbody>tr").click(function(){
    			location.href = "<%=contextPath%>/detail.an?cno=" + $(this).children().eq(0).text();
    		})
    		
		})
    </script>
    
    <%@ include file="../common/footerbar.jsp" %>
</body>
</html>