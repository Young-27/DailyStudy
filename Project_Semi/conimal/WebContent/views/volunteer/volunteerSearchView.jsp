<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.volunteer.model.vo.Volunteer"%>
<%
	String keyword = (String)request.getAttribute("keyword");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Volunteer> list = (ArrayList<Volunteer>)request.getAttribute("list");
	
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
	.content-area{
		text-align: center;
		width: 1200px;
		margin: auto;
	}
	#list-area>tbody>tr:hover{
        background: lightgray;
        cursor: pointer;
    }
	.pagination{
    	justify-content: center;
    }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>
	
	<div class="content-area">

		<table id="list-area" class="table table-striped">
			<thead>
				<tr>
					<th>글번호</th>
					<th width="600">글제목</th>
					<th width="150">작성자</th>
					<th>조회수</th>
					<th width="150">작성일</th>
				</tr>
			</thead>
			<tbody>
				<%if(list.isEmpty()) {%>
					<tr>
						<td colspan="5">조회된 리스트가 없습니다</td>
					</tr>
				<%} else { %>
					<%for(Volunteer v : list) { %>
						<tr>
							<td><%=v.getVolNo()        %></td>
							<td><%=v.getVolTitle()     %></td>
							<td><%=v.getMemNo()        %></td>
							<td><%=v.getVolCount()     %></td>
							<td><%=v.getVolWritedate() %></td>
						</tr>
					<%} %>
				<%} %>
			</tbody>
		</table>

	</div>
	
	<script>
    	$(function(){
        	$("#list-area>tbody>tr").click(function(){
        		location.href="<%=contextPath%>/detail.vo?vno=" + $(this).children().eq(0).text();
        	})
    	})
    </script>
	
	<div align="center" class="paging-area">
		<ul class="pagination">
			<%if(currentPage != 1) { %>
            	<li class="page-item"><a href="<%=contextPath%>/search.vo?currentPage=<%=currentPage-1%>&keyword=<%=keyword%>" class="page-link">이전</a></li>
            <%} else {%>
            	<li class="page-item disabled"><a class="page-link">이전</a></li>
            <%} %>
            
	        <%for(int p = startPage; p <= endPage; p++) { %>
	        
	        	<%if(p != currentPage) {%>
	        		<li class="page-item"><a href="<%=contextPath%>/search.vo?currentPage=<%=p%>&keyword=<%=keyword%>" class="page-link"><%=p%></a></li>
	        	<%} else { %>
	        		<li class="page-item active"><a class="page-link"><%=p%></a></li>
	        	<%} %>
	        	
	        <%} %> 
	        
	        <%if(currentPage != maxPage) {%>
            	<li class="page-item"><a href="<%=contextPath %>/search.vo?currentPage=<%=currentPage+1 %>&keyword=<%=keyword%>" class="page-link">다음</a></li>
            <%} else {%>
            	<li class="page-item disabled"><a class="page-link">다음</a></li>
            <%} %>
		</ul>
	</div>

	<br><br>
	
	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>