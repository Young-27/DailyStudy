<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="content">
		<br><br>
		<div class="innerOuter">
			<form action="testInsert1.do">
				제목 : <input type="text" name="boardList[0].boardTitle"> <br>
				작성자 : <input type="text" name="boardList[0].boardWriter" value="user01"> <br>
				내용 : <textarea name="boardList[0].boardContent"></textarea>
				<br><br>
				
				제목 : <input type="text" name="boardList[1].boardTitle"> <br>
				작성자 : <input type="text" name="boardList[1].boardWriter" value="user01"> <br>
				내용 : <textarea name="boardList[1].boardContent"></textarea>
				<br><br>
				
				<button type="submit">등록하기</button>
			</form>
		</div>
	</div>
</body>
</html>