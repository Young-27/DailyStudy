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
		
			<form action="testInsert2.do">
				
				상품명 : <input type="text" name="proName"><br>
				상품설명 : <textarea name="proDesc"></textarea><br>
				
				<hr>
				
				<h4>옵션1</h4>
				옵션명 : <input type="text" name="optionList[0].optName"><br>
				옵션가격 : <input type="text" name="optionList[0].optPrice"><br><br>
				
				<h4>옵션2</h4>
				옵션명 : <input type="text" name="optionList[1].optName"><br>
				옵션가격 : <input type="text" name="optionList[1].optPrice"><br><br>
				
				<button type="submit">등록하기</button>
				
				
			</form>
		
		</div>
	</div>
</body>
</html>