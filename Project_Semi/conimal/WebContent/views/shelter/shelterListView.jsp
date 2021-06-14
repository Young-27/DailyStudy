<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.shelter.model.vo.Shelter"%>
<%
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
		<!-- 
		<div class="search-area">
			<table>
				<tr>
					<td>
						<select name="area" id="area1">
							<option value="seoul">서울</option>
							<option value="gyeonggi">경기</option>
							<option value="busan">부산</option>
						</select>
					</td>
					<td>
						<input type="text" name="keyword">
					</td>
					<td>
						<input type="submit" value="검색">
					</td>
				</tr>
			</table>
		</div>
		
		<br clear="both">
		-->
		<form action="<%=contextPath%>/search.sh?currentPage=1" method="post">
			<div class="input-group mt-3 mb-3" style="width: 300px; margin-left: 10px">
				<div class="input-group-prepend">
					<button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown">지역</button>
				    <div class="dropdown-menu">
				      	<a class="dropdown-item" href="<%=contextPath%>/place.sh?place=1">서울</a>
				      	<a class="dropdown-item" href="<%=contextPath%>/search.sh?currentPage=1&place=2">경기도</a>
				      	<a class="dropdown-item" href="<%=contextPath%>/search.sh?currentPage=1&place=3">강원도</a>
				      	<a class="dropdown-item" href="<%=contextPath%>/search.sh?currentPage=1&place=4">충청도</a>
				      	<a class="dropdown-item" href="<%=contextPath%>/search.sh?currentPage=1&place=5">전라도</a>
				      	<a class="dropdown-item" href="<%=contextPath%>/search.sh?currentPage=1&place=6">경상도</a>
				      	<a class="dropdown-item" href="<%=contextPath%>/search.sh?currentPage=1&place=7">제주</a>
				    </div>
				</div>
				<!--
				<select class="form-select" aria-label="Default select example">
				  <option selected>지역</option>
				  <option value="1">서울</option>
				  <option value="2">경기도</option>
				  <option value="3">강원도</option>
				  <option value="4">충정도</option>
				  <option value="5">전라도</option>
				  <option value="6">경상도</option>
				  <option value="7">제주</option>
				</select>
				 -->
			  	<input type="text" class="form-control" placeholder="보호소명" name="keyword">
			  	<button class="btn btn-primary" type="submit">검색</button>
			</div>
		</form>
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
	            	<li class="page-item"><a href="<%=contextPath%>/list.sh?currentPage=<%=currentPage-1%>" class="page-link">이전</a></li>
	            <%} else {%>
	            	<li class="page-item disabled"><a class="page-link">이전</a></li>
	            <%} %>
	            
		        <%for(int p = startPage; p <= endPage; p++) { %>
		        
		        	<%if(p != currentPage) {%>
		        		<li class="page-item"><a href="<%=contextPath%>/list.sh?currentPage=<%=p%>" class="page-link"><%=p%></a></li>
		        	<%} else { %>
		        		<li class="page-item active"><a class="page-link"><%=p%></a></li>
		        	<%} %>
		        	
		        <%} %> 
		        
		        <%if(currentPage != maxPage) {%>
	            	<li class="page-item"><a href="<%=contextPath %>/list.sh?currentPage=<%=currentPage+1 %>" class="page-link">다음</a></li>
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