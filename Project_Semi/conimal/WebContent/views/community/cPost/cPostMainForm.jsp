<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.community.cPost.model.vo.Cpost" %>
<%
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   ArrayList<Cpost> list = (ArrayList<Cpost>)request.getAttribute("list");
   
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
        margin-top:50px;
        margin-bottom: 50px;
        width: 1000px;

    }
    #cPostTable {
        text-align: center;
    }
    .cPost>ul{ display: flex; margin: 10px; left: 0; right: 0;}
    .cPost{display: table; box-sizing:border-box;}
    .cPost>button{
        margin: auto;
        text-align: center;
        vertical-align: auto;
        display: table;
    }
    .cPost>table{
    	width:1000px;
    }
    .pagination {
    	margin:auto;
        justify-content: center;
    }
    .searchWord{
        margin-left: 650px;
        position:absolutes;
    }

     .cPost-list>tbody>tr:hover{
    	background: lightgray;
    }
     .searchWord{
        margin-left: 650px;
        position:absolutes;
    }
</style>

</head>
<body>
 <%@ include file="../../common/menubar.jsp" %>

    <div class="outer" style="margin: auto; margin-top:50px;  margin-bottom: 50px;">
        <h6 style="margin-left: 10px;">커뮤니티 > 자유게시판</h6>
        <br>
        <h5 style="text-align:left; font-weight: bolder; margin-left: 10px;"> 자유게시판</h5>
        <p style="margin-left: 10px;">이곳은 회원들이 자유롭게 글을 작성할 수 있는 자유게시판입니다.</p><br><br>

        <div class="cPost">
           
            <nav class="navbar justify-content-center">
            	<form class="cPostSearchF" action="<%=contextPath%>/list.cp?currentPage=1" method="post">
		            <div class="searchWord">
		            	<input type="hidden" name="currentPage" value="1">
		                <input type="text" name="keyword" id="searchWordT" placeholder="검색어를 입력하세요.">
						<button type="submit" id="searchBtn" style="font-size:13px; width: 70px; height:30px; background:lightgray; border: 25px; border-radius: 3px;">검색 </button>
		            </div>
	            </form>
            </nav>
            <br>
            <table id="cPostTable" class="table table-striped cPost-list">
                <thead width=850px>
                    <tr height=35px>
                        <th width=50px>No.</th>
                        <th width=450px>제목</th>
                        <th width=100px>작성자</th>
                        <th width=120px>작성일</th>
                        <th width=80px>조회수</th> 
                    </tr>
                    
                </thead>
                <tbody> <!--실제로는 반복문으로 나오게 할거임 -->
					<% if(list.isEmpty()){ %>
						<tr>
							<td colspan="5">조회된 리스트가 없습니다.</td>
						</tr>
						<% }else{ %>
							<% for(Cpost c : list) {%>
				                <tr>
				                    <td><%= c.getcPostNo() %></td>
				                    <td><%= c.getcPostTitle() %></td>
				                    <td><%= c.getcUserName() %></td>
				                    <td><%= c.getcPostDate() %></td>
				                    <td><%= c.getcPostCount() %></td>
				                    
				                </tr>
		                <% } %>
					<% } %>

                </tbody>
            </table>

            <br>

	             <ul class="pagination">
			         	<%if(currentPage != 1) { %>
			               <li class="page-item"><a href="<%=contextPath%>/list.cp?currentPage=<%=currentPage-1%>" class="page-link">이전</a></li>
			            <%} else {%>
			               <li class="page-item disabled"><a class="page-link">이전</a></li>
			            <%} %>
			            
				           <%for(int p = startPage; p <= endPage; p++) { %>
				           
				              <%if(p != currentPage) {%>
				                 <li class="page-item"><a href="<%=contextPath%>/list.cp?currentPage=<%=p%>" class="page-link"><%=p%></a></li>
				              <%} else { %>
				                 <li class="page-item disabled"><a class="page-link"><%=p%></a></li>
				              <%} %>
				              
				           <%} %> 
			           
			            <%if(currentPage != maxPage) {%>
			               <li class="page-item"><a href="<%=contextPath %>/list.cp?currentPage=<%=currentPage+1 %>" class="page-link">다음</a></li>
			            <%} else {%>
			               <li class="page-item disabled"><a class="page-link">다음</a></li>
			            <%} %>
	      </ul>

            
	            <%if(loginUser != null){ %>
	            	<!-- 로그인 한 회원에게만 보여지는 버튼 -->
	            	<button id="btn" class="submitB" onclick="cPostReview();" style=" text-align:center; margin-left: 700px; font-size:16px; width: 100px; background:lightgray; border: 25px; border-radius: 3px;" > 글쓰기 </button>
	            <%} %>
            
        </div>

    </div>
    
        <script>
    	$(function(){
    		$(".cPost-list>tbody>tr").click(function(){
    			location.href="<%=contextPath%>/detail.cp?cno=" + $(this).children().eq(0).text();
    		})
    	})
 
    	function cPostReview(){
    			location.href="<%=contextPath%>/enrollForm.cp"
    	}
    </script>
    
    
    <%@ include file="../../common/footerbar.jsp" %>

</body>
</html>