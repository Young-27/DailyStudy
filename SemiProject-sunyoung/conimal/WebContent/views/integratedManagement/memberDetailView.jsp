<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<%
	Member m = (Member)request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        height: 1000px;
        width: 800px;
        margin: auto;
        margin-top: 50px;
    }

    .memberDetail{
        height: 100%;
        width: 100%;
    }

    .memberDetail button{
        text-align: center;
        margin: auto;
    }
    .list-area{
        margin: auto;
        width: 80%;
        height: 50%;
        border: black solid 1px;
    }
    
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
    
    <div class="outer">
        <a href="<%=contextPath%>/list.me?currentPage=1" class="btn" style="background-color: rgb(187, 208, 227)">목록</a>
        <br><br>
        <div class="memberDetail">
            <form action="<%=contextPath%>/update.me" method="post">
                <table class="table" id="memberDetail" border="1" align="center">
                	<input type="hidden" name="mno" value="<%=m.getUserNo()%>">
                    <tr>
                        <th width="100px">아이디</th>
                        <td width="400px"><%=m.getUserId() %></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" name="userName" value="<%=m.getUserName() %>"></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="text" name="email" value="<%=m.getEmail() %>"></td>
                    </tr>
                    <tr>
                        <th>가입일</th>
                        <td><%=m.getEnrollDate() %></td>
                    </tr>
                    <%if(m.getUserCode() == 2){ %> <!-- 회원이 보호소라면 추가정보 출력 -->
                    	<tr>
                    		<th>연락처</th>
                    		<td><input type="text" name="shPhone" value="<%=m.getShelterPhone() %>"></td>
                    	</tr>
                    	<tr>
                    		<th>주소</th>
                    		<td><input type="text" name="shAddress" value="<%=m.getShelterAddress() %>"></td>
                    	</tr>
                    	<tr>
                    		<th>소개글</th>
                    		<td><input type="text" name="shAbout" value="<%=m.getShelterAbout()%>"></td>
                    	</tr>
                    <%} %>
                </table>
                <br>
                <div class=button-area align="center">
                    <button class="btn btn-sm" style="background-color: rgb(187, 208, 227)">정보수정</button>
                    <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
                </div>
                <br>
            </form>
        </div>
        
    </div>
	<%@ include file="../common/footerbar.jsp" %>
	
	<!-- 회원탈퇴 버튼 클릭시 보여질 Modal -->
	<div class="modal" id="deleteForm">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">회원탈퇴</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body" align="center">
	        
	        <b>탈퇴 후 복구가 불가능합니다. <br>정말로 해당 회원을 탈퇴 시키겠습니까?</b> <br><br>
	        
	        <form action="<%= contextPath %>/delete.me" method="post">
	        	<input type="hidden" name="memNo" value="<%=m.getUserNo()%>">
	        	<!-- value=>memNo값 전달 -->
	        	<br><br>
	        	<button type="submit" class="btn btn-danger btn-sm">탈퇴하기</button>
	        </form>
		        	
	      </div>
		</div>
    </div>
    
    
</body>
</html>