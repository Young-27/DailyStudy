<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.donation.model.vo.Donation"%>
<%
	ArrayList<Donation> list = (ArrayList<Donation>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	   /* body 마이페이지 사이드바*/
	   div{box-sizing:border-box;}
        .body{
            width:100%;
            /*height:800px;*/
            margin:auto;
            margin-top:10px;
        }
        .body>div{
            height:100%;
            float:left;
            }
        #left{width:25%;}
        #right{width:75%;}

        #mypage{
            font-weight: bold; 
            font-size: 32px; 
            color: rgb(127, 127, 127);
            text-align:center;
            padding:30px;
        }

        #sidebar{
            list-style-type:none; 
            margin:0;
            padding:0;
            height:100%;
        }
        #sidebar>li{
            background-color:lightgray;
           /* background-color: rgb(190, 190, 190);*/
            font-weight:bold;
            font-size:24px;
            text-align:center;
            line-height:75px;
        }
		#sidebar a{
            color:black;
            text-decoration:none;
        }
        #sidebar>li:hover{
            background-color:gray;
            cursor:pointer;
        }

        /* 사이드2 */
        .outer{
            width:900px;
            height:450px;
            background: rgb(252, 252, 252);
            margin:auto;
            margin-top:50px;
        }
        .list-area{
            border:1px solid #ccc;
            text-align:center;
        }
        .list-area>thead{background:#eaeaea;}
        .list-area>tbody>tr:hover{
            background:lightgray;
            cursor:pointer;
        }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<div class="body">
            
		<div id="left">
			<div id="mypage">마이페이지</div>
		  
			<ul id="sidebar">
				<li id="side1"><a href="<%= contextPath %>/myPage.me">정보수정</a></li>
                <li id="side2"><a href="<%= contextPath %>/myPagePost.me">작성 게시글</a></li>
                <li id="side3"><a href="<%= contextPath %>/deletePage.me">회원 탈퇴</a></li>
			</ul>
		</div>
	
		<div id="right">


			<div class="outer">
				<br>
				<h2 align="center">작성 게시글</h2>
				<br>
			
				<table class="list-area">
					<thead>
						<tr>
							<th width="70">No.</th>
							<th width="100">작성게시판</th>
							<th width="200">글제목</th>
							<th width="200">글내용</th>
							<th width="50">조회수</th>
							<th width="100">작성일자</th>
							<th width="100">승인여부</th>
						</tr>
					</thead>
					<tbody>
						
						<% if(list.isEmpty()) { %>
							<!-- 리스트가 비어있을 경우 -->
							<tr>
								<td colspan="7">존재하는 게시글이 없습니다.</td>
							</tr>				
						<% }else{ %>
							<!-- 리스트가 비어있지 않을 경우 -->
							<% for(Donation d : list) { %>
								<tr>
									<td><%= d.getDoNo() %></td>
									<td><%= d.getRefType() %></td>
									<td><%= d.getDoTitle() %></td>
									<td><%= d.getDoContent() %></td>
									<td><%= d.getDoCount() %></td>
									<td><%= d.getDoWriteDate() %></td>
									<td><%= d.getDoAdmission() %></td>
								</tr>
							<% } %>
						<% } %>


					</tbody>
				</table>
			
				<br><br>
			
				<div align="center" class="paging-area">
			
					<button> &lt; </button>
						
					<button>1</button>
					<button>2</button>
					<button>3</button>
					<button>4</button>
					<button>5</button>
						
					<button> &gt; </button>
			
				</div>
					
			</div>  

		</div>
	
	</div>
	
	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>