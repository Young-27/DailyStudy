<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.animal.model.vo.Animal"%>
<%
	String keyword = (String)request.getAttribute("keyword");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Animal> list = (ArrayList<Animal>)request.getAttribute("list");
	
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
	
		<h2 align="center">보호중인 아이들</h2>
	
		<br>
		
		<div class="type-area" align="center">
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='<%=contextPath%>/list.dog?currentPage=1'">강아지</button>
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='<%=contextPath%>/list.cat?currentPage=1'">고양이</button>
		</div>
	
		<br>
		
		<div class="content-area">
			
			<%if(list.isEmpty()) {%>
				조회된 결과가 없습니다
			<%} else { %>
				<%for(Animal a : list) {%>
					<div class="pet" style="text-align: center;">
						<a href="<%=contextPath%>/detail.an?ano=<%=a.getAnNo()%>" ><img src="resources/images/cat.jpg" class="img-thumbnail" alt="Cinque Terre"></a><br>
						<%=a.getAnTitle() %>
					</div>
				<%} %>	
			<%} %>

		</div>
		
		<script>
		
		</script>
	
		<br><br>
		
		<div align="center" class="paging-area">
			<ul class="pagination">
				<%if(currentPage != 1) { %>
	            	<li class="page-item"><a href="<%=contextPath%>/search.cat?currentPage=<%=currentPage-1%>&keyword=<%=keyword%>" class="page-link">이전</a></li>
	            <%} else {%>
	            	<li class="page-item disabled"><a class="page-link">이전</a></li>
	            <%} %>
	            
		        <%for(int p = startPage; p <= endPage; p++) { %>
		        
		        	<%if(p != currentPage) {%>
		        		<li class="page-item"><a href="<%=contextPath%>/search.cat?currentPage=<%=p%>&keyword=<%=keyword%>" class="page-link"><%=p%></a></li>
		        	<%} else { %>
		        		<li class="page-item active"><a class="page-link"><%=p%></a></li>
		        	<%} %>
		        	
		        <%} %> 
		        
		        <%if(currentPage != maxPage) {%>
	            	<li class="page-item"><a href="<%=contextPath %>/search.cat?currentPage=<%=currentPage+1 %>&keyword=<%=keyword%>" class="page-link">다음</a></li>
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