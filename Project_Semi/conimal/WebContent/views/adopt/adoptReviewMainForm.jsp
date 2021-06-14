<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.adopt.model.vo.Adopt" %>
<%
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   ArrayList<Adopt> list = (ArrayList<Adopt>)request.getAttribute("list");
   
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
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
    .outer{
        margin: auto;
        margin-top:50px;
        margin-bottom: 50px;
        width: 1000px;
    }
    #cAdoptTable {
        text-align: center;
    }
    .cAdopt>ul{ display: flex; margin: 10px; left: 0; right: 0;}
    .cAdopt{display: table;}
      .cAdopt>table{
         width:1000px;
      }
    .cAdopt>button{
        margin: auto;
        text-align: center;
        vertical-align: auto;
        display: table;
    }
    .pagination {
        margin: auto;
    }
    .searchWord{
        margin-left: 650px;
        position:absolutes;
    }
    .pagination {
        justify-content: center;
    }
    
    .adopt-list>tbody>tr:hover{
       background: lightgray;
    }
    
    
</style>

</head>
<body>
  <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
        <h6 style="margin-left: 10px;">입양후기</h6>
        <br>
        <h5 style="text-align:left; font-weight: bolder; margin-left: 10px;"> 입양후기 </h5>
        <p style="margin-left: 10px;">소중한 생명들의 새로운 시작을 함께 축하해주세요:)</p><br><br>

        <div class="cAdopt">
            <!--여기에 검색하는 창 들어가야 하는데 이걸 Form으로 묶어줘야할지 말지..-->
            <nav class="navbar justify-content-center">
            	<form class="adoptSearchF" action="<%=contextPath%>/list.ad?currentPage=1" method="post">
		            <div class="searchWord">
		            	<input type="hidden" name="currentPage" value="1">
		                <input type="text" name="keyword" id="searchWordT" placeholder="검색어를 입력하세요.">
						<button type="submit" id="searchBtn" style="font-size:13px; width: 70px; height:30px; background:lightgray; border: 25px; border-radius: 3px;">검색 </button>
		            </div>
	            </form>
            </nav>
            <br>
            <table id="cAdoptTable" class="table table-striped adopt-list">
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
                  <% for(Adopt a : list) {%>
                         <tr>
                             <td><%= a.getAdoptNo() %></td>
                             <td><%= a.getAdoptTitle() %></td>
                             <td><%= a.getAdoptWriter() %></td>
                             <td><%= a.getAdoptDate() %></td>
                             <td><%= a.getCount() %></td>
                             
                         </tr>
                      <% } %>
               <% } %>
             
                </tbody>
            </table>

            <br>
      
       <ul class="pagination">
         <%if(currentPage != 1) { %>
               <li class="page-item"><a href="<%=contextPath%>/list.ad?currentPage=<%=currentPage-1%>" class="page-link">이전</a></li>
            <%} else {%>
               <li class="page-item disabled"><a class="page-link">이전</a></li>
            <%} %>
            
           <%for(int p = startPage; p <= endPage; p++) { %>
           
              <%if(p != currentPage) {%>
                 <li class="page-item"><a href="<%=contextPath%>/list.ad?currentPage=<%=p%>" class="page-link"><%=p%></a></li>
              <%} else { %>
                 <li class="page-item disabled"><a class="page-link"><%=p%></a></li>
              <%} %>
              
           <%} %> 
           
           <%if(currentPage != maxPage) {%>
               <li class="page-item"><a href="<%=contextPath %>/list.ad?currentPage=<%=currentPage+1 %>" class="page-link">다음</a></li>
            <%} else {%>
               <li class="page-item disabled"><a class="page-link">다음</a></li>
            <%} %>
      </ul>

       
          
          
           
            <% if(loginUser != null){ %>
            <!-- 로그인 한 회원에게만 보여지는 버튼 -->
            <button id="btn" class="submitB" onclick="adoptReview();" style=" text-align:center; margin-left: 700px; font-size:16px; width: 100px; background:lightgray; border: 25px; border-radius: 3px;" > 글쓰기 </button>
            <%} %>
            
        </div>

    </div>
    
    <script>
       $(function(){
          $(".adopt-list>tbody>tr").click(function(){
             location.href="<%=contextPath%>/detail.ad?ano=" + $(this).children().eq(0).text();
          })
       })
 	  
       function adoptReview(){
    	   location.href="<%=contextPath %>/written.ad"
       }
    
    </script>
    
    
    
    
    
    
    <%@ include file="../common/footerbar.jsp" %>

</body>
</html>