<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.animal.model.vo.Animal"%>
<%
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
						<a href="<%=contextPath%>/detail.an?ano=<%=a.getAnNo()%>" ><img src="resources/images/dog.png" class="img-thumbnail" alt="Cinque Terre"></a><br>
						<%=a.getAnTitle() %>
					</div>
				<%} %>	
			<%} %>

		</div>
	
		<br><br>
		
		<form action="<%=contextPath%>/search.dog?currentPage=1" method="post">
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
	            	<li class="page-item"><a href="<%=contextPath%>/list.dog?currentPage=<%=currentPage-1%>" class="page-link">이전</a></li>
	            <%} else {%>
	            	<li class="page-item disabled"><a class="page-link">이전</a></li>
	            <%} %>
	            
		        <%for(int p = startPage; p <= endPage; p++) { %>
		        
		        	<%if(p != currentPage) {%>
		        		<li class="page-item"><a href="<%=contextPath%>/list.dog?currentPage=<%=p%>" class="page-link"><%=p%></a></li>
		        	<%} else { %>
		        		<li class="page-item active"><a class="page-link"><%=p%></a></li>
		        	<%} %>
		        	
		        <%} %> 
		        
		        <%if(currentPage != maxPage) {%>
	            	<li class="page-item"><a href="<%=contextPath %>/list.dog?currentPage=<%=currentPage+1 %>" class="page-link">다음</a></li>
	            <%} else {%>
	            	<li class="page-item disabled"><a class="page-link">다음</a></li>
	            <%} %>
			</ul>
		</div>

				<!-- 현재 로그인한 사용자일 경우 -->
				<% if(loginUser != null && loginUser.getMemCode() == 2){ %>
					<div align="right" style="width:1150px;">
						<a href="<%=contextPath %>/animalForm.ao" class="btn btn-secondary">글쓰기</a>
					</div>
				<% } %>
					<script>
							function animalPage(){
								//location.href = "<%=contextPath%>/views/animal/animalWriteForm.jsp";
								// 웹 애플리케이션의 디렉토리 구조가 url에 노출되면 보안에 위험
								
								// 단순한 정적인 페이지 요청이라고 해도 반드시 servlet거쳐갈것 => url에 서블릿 매핑값만 노출됨
								location.href = "<%=contextPath%>/anWriteForm.me";
							}
					</script>	
		
		<br><br>
	
	</div>


	
	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>