<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.shelter.model.vo.Shelter"%>
<%
	String keyword = (String)request.getAttribute("keyword");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Shelter> list = (ArrayList<Shelter>)request.getAttribute("list");
	
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
	.content{
		width: 1200px;
		margin: auto;
	}
	.content-area{
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
	}
	.pet img{
		width: 280px;
		height: 200px;
		margin: 10px;
	}
	.pagination{
    	justify-content: center;
    }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<div class="content">
	
		<br><br>
		
		<h2 align="center">보호소 소개</h2>

		
		<div class="content-area">
			<%if(list.isEmpty()) {%>
				조회된 결과가 없습니다
			<%} else { %>
				<%for(Shelter s : list) {%>
					<div class="pet" style="text-align: center;">
						<a href="<%=contextPath%>/detail.sh?sno=<%=s.getMemNo()%>" ><img src="resources/images/dog.png" class="img-thumbnail" alt="Cinque Terre"></a><br>
						<%=s.getShName() %>
					</div>
				<%} %>	
			<%} %>

		</div>
		
		<br><br>
		
		
		<div align="center" class="paging-area">
			<ul class="pagination">
				<%if(currentPage != 1) { %>
	            	<li class="page-item"><a href="<%=contextPath%>/search.sh?currentPage=<%=currentPage-1%>&keyword=<%=keyword%>" class="page-link">이전</a></li>
	            <%} else {%>
	            	<li class="page-item disabled"><a class="page-link">이전</a></li>
	            <%} %>
	            
		        <%for(int p = startPage; p <= endPage; p++) { %>
		        
		        	<%if(p != currentPage) {%>
		        		<li class="page-item"><a href="<%=contextPath%>/search.sh?currentPage=<%=p%>&keyword=<%=keyword%>" class="page-link"><%=p%></a></li>
		        	<%} else { %>
		        		<li class="page-item active"><a class="page-link"><%=p%></a></li>
		        	<%} %>
		        	
		        <%} %> 
		        
		        <%if(currentPage != maxPage) {%>
	            	<li class="page-item"><a href="<%=contextPath %>/search.sh?currentPage=<%=currentPage+1 %>&keyword=<%=keyword%>" class="page-link">다음</a></li>
	            <%} else {%>
	            	<li class="page-item disabled"><a class="page-link">다음</a></li>
	            <%} %>
			</ul>
		</div>
		
		<br><br>
	
	</div>
	
	<%@ include file="../common/footerbar.jsp" %>
	
</body>
</html>