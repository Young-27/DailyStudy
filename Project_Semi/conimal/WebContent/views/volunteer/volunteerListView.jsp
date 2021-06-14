<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.volunteer.model.vo.Volunteer"%>
<%
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

	<h2 align="center">자원봉사 게시판</h2>

	<br>

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

	<br><br>
	
	<form action="<%=contextPath%>/search.vo?currentPage=1" method="post">
		<div class="input-group mx-auto mb-3" style="width: 250px;">
			<input type="text" class="form-control" placeholder="Search" name="keyword">
			<div class="input-group-append">
			 	<button class="btn btn-primary" type="submit">검색</button>
			</div>
	  	</div>	
	</form>
	
	<div align="center" class="paging-area">
		<ul class="pagination">
			<%if(currentPage != 1) { %>
            	<li class="page-item"><a href="<%=contextPath%>/list.vo?currentPage=<%=currentPage-1%>" class="page-link">이전</a></li>
            <%} else {%>
            	<li class="page-item disabled"><a class="page-link">이전</a></li>
            <%} %>
            
	        <%for(int p = startPage; p <= endPage; p++) { %>
	        
	        	<%if(p != currentPage) {%>
	        		<li class="page-item"><a href="<%=contextPath%>/list.vo?currentPage=<%=p%>" class="page-link"><%=p%></a></li>
	        	<%} else { %>
	        		<li class="page-item active"><a class="page-link"><%=p%></a></li>
	        	<%} %>
	        	
	        <%} %> 
	        
	        <%if(currentPage != maxPage) {%>
            	<li class="page-item"><a href="<%=contextPath %>/list.vo?currentPage=<%=currentPage+1 %>" class="page-link">다음</a></li>
            <%} else {%>
            	<li class="page-item disabled"><a class="page-link">다음</a></li>
            <%} %>
		</ul>
	</div>

	<!-- 현재 로그인한 사용자일 경우 -->
	<% if(loginUser != null && loginUser.getMemCode() == 2){ %>
		<div align="right" style="width:1150px;">
			<a href="<%=contextPath %>/enrollForm.vo" class="btn btn-secondary">글쓰기</a>
		</div>
	<% } %>
		<script>
			function volunteerPage(){
							
			// 단순한 정적인 페이지 요청이라고 해도 반드시 servlet거쳐갈것 => url에 서블릿 매핑값만 노출됨
				location.href = "<%=contextPath%>/volWriteForm.me";
			}
		</script>	

	<br><br>			

	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>