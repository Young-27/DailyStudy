<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.common.model.vo.PageInfo, java.util.ArrayList, com.kh.community.notice.model.vo.Notice"%>
   <% ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
      PageInfo pi = (PageInfo)request.getAttribute("pi");
      int currentPage = pi.getCurrentPage();
	  int startPage = pi.getStartPage();
	  int endPage = pi.getEndPage();
	  int maxPage = pi.getMaxPage();
	  String keyword =(String)request.getAttribute("keyword");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.body{
		width: 1100px;
        height: 1240px;
        margin: 0 auto;
        margin-top:30px;
	}
	
  h1,h5{
      margin: 0;  
      font-weight: bold; 
      color: rgb(127, 127, 127);          
  }
  .head1{
  	width:100%;
  	height:10%;
  	margin-top:50px;
  	
  }
  .head2{
   width:100%;
  	height:5%;
  }
  .search{
  width:264px;
  height:36px; 
  
  }
  .searchbar{
  color: rgb(94, 94, 94); 
  border-width: 1px 0px 1px 1px;
  border-radius:4px;
   border-style: solid; 
   border-color: rgb(204, 204, 204);
   width:180px;
   height:100%;
   float:right;
  }
  .searchbutton{
 
      border-width: 1px 1px 1px 1px; 
      border-style: solid; 
      border-color: rgb(204, 204, 204); 
      box-shadow: rgba(0, 0, 0, 0.0666667) 0px 1px 1px 0px inset;
       background-color: rgb(237, 237, 237);
       width:64px;
        height:100%;
        float:right;
       }
  .body1{
  	width:100%; 
  	margin-bottom:50px; 	
  } 
  .foot1{
  width:100%;
  height:10%;  
  }
	  .list-area{
        border:1px solid white;
        text-align:center;
       
    }
     .list-area>thead>tr>th{
      	
    	border: 1px solid #ccc;
    	word-break: break-all;
    	background: #eaeaea;    	
    	font-weight: bold;
    	display: table-cell;
   		vertical-align: inherit;
   		
  
   
     }
     .list-area>tbody>tr>td{
  		 border-bottom: 1px solid #ccc;
    	font-family: HanSans;
    	
     }
    .list-area>tbody>tr:hover{
        cursor:pointer;
    }
    .paging-area>button{
    font-size: 16px; 
    color: rgb(255, 255, 255); 
    text-align: center; 
    line-height: 2.5em; 
    border-radius: 4px; 
	background-color: rgb(244, 244, 244);
	color:black;
    border:0px;    
    width:40px;
    height:40px;
    }
   
     .writebutton{
    float:right;
    font-size: 16px;
    color: rgb(64, 64, 64);
    text-align: center;
    line-height: 2.5em;
    background-color: rgb(224, 224, 224);   
    border:0px;
    border-radius: 4px; 
    width: 100px; 
    height: 40px;
  }
  .current{
  	
  	;
  
  }
	</style>
</head>

	
<body>

<%@ include file="../../common/menubar.jsp" %>
<div class="body">  
<div class="head1">
  <h5>커뮤니티>공지사항</h5> 
  <h1>공지사항</h1>
 
  </div>
  <div class="head2"align="right">
  <form action="<%=contextPath%>/Main.no?currentPage=1" id="Search-Notice" method="post">
  <div class="search" >
  <button type="submit" class="searchbutton">검색</button>
  <input type="text" class="searchbar" name="keyword">
  </div>
  </form>
  </div>
	<div class="body1">
  <table class="list-area">
            <thead>
                <tr>
                    <th width="100">No.</th>
                    <th width="700">제목</th>
                    <th width="300">작성일</th>
                </tr>
            </thead>
            <tbody>
            <%if(list.isEmpty()){ %>
            <tr>
            <td colspan="3">존재하는 공지사항이 없습니다.</td>
            </tr>
            <% } else {%>
            <% for(Notice n: list){ %>
                 <tr>
		                 <td><%=n.getNoticeNo()%></td>
		                 <td><%=n.getNoticeTitle()%></td>
		                 <td><%=n.getNoticeDate()%></td>
		         </tr>		         
                <%} %>
                <%} %>
            </tbody>
        </table>
  </div>
  <script>
  	$(function(){
  		$(".list-area>tbody>tr").click(function(){
  			var noticeNo =$(this).children().eq(0).text();
  			location.href='<%=contextPath%>/Detail.no?noticeNo='+noticeNo;
  		})
  	})
  </script>
  
  <div class="foot1">
  
        <div align="center" class="paging-area">
				<% if(currentPage != 1){ %>
            	<button onclick="location.href='<%=contextPath%>/Main.no?currentPage=<%=currentPage-1%>&keyword=<%=keyword%>';" > &lt; </button>
            	<% } %>
            	 <% for(int p=startPage; p<=endPage; p++){ %>	
            	 <% if(p != currentPage){ %>	
	            	<button onclick="location.href='<%=contextPath%>/Main.no?currentPage=<%= p %>&keyword=<%=keyword%>';"><%= p %></button> 
	             <% }else { %>
	            	<button style="background-color: gray" disabled><%= p %></button>
            	<% } %>
            	
            <% } %>    
            	<% if(currentPage != maxPage){ %>       
            	<button onclick="location.href='<%=contextPath%>/Main.no?currentPage=<%=currentPage+1%>&keyword=<%=keyword%>';"> &gt; </button>
            	<% } %>
		
        </div>        
  </div>
  <div>
  <% if(loginUser != null && loginUser.getMemCode()==1){ %>
   <button onclick="location.href='<%=contextPath%>/WriteForm.no'"class="writebutton">글쓰기</button>
   <% } %>
  </div>
  
  
  </div>
         <%@ include file="../../common/footerbar.jsp" %>
</body>
</html>