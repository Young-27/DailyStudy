<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #list-area{
        border: 1px solid midnightblue;
        text-align: center;
    }
    .outer a{color:midnightblue; text-decoration: none;}
</style>
<body>
	
	<jsp:include page="../common/menubar.jsp"/>

    <div class="outer">
        <br><h1 align="center">게시판</h1><br>

        <div id="search-area" align="center">
            <form action="">
                <select name="condition">
                    <option value="writer">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="keyword">
                <button type="submit">검색</button>
            </form>
        </div>
        <br>

        <table id="list-area" align="center">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th width="400">제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="b" items="${ list }">
	                <tr>
	                    <td>${ b.boardNo }</td>
	                    <td><a href="detail.bo?bno=${ b.boardNo }">${ b.boardTitle }</a></td>
	                    <td>${ b.boardWriter }</td>
	                    <td>${ b.count }</td>
	                    <td>${ b.createDate }</td>
	                </tr>
                </c:forEach>
            </tbody>
        </table>

        <br>

        <div id="paging-area" align="center">
        	
        	<c:if test="${ pi.currentPage ne 1}">
            	<a href="list.bo?currentPage=${ pi.currentPage-1 }">[이전]</a>
			</c:if>
			
			<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
            	<a href="list.bo?currentPage=${ p }">[${ p }]</a>
            </c:forEach>
			
			<c:if test="${ pi.currentPage ne maxPage  }">
            	<a href="list.bo?currentPage=${ pi.currentPage+1 }">[다음]</a>
            </c:if>
            
        </div>
        <br>
    </div>
	
	
</body>
</html>