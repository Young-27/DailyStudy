<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- jQuery 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Spring에서 AJAX 사용법</h1>
	
	<h3>1. 요청시 값 전달, 응답 결과 받아보기</h3>
	이름 : <input type="text" id="name"><br>
	나이 : <input type="number" id="age"><br>
	<button onclick="test1();">전송</button>
	
	<div id="result1"></div>
	
	<script>
		/*
		function test1(){
			$.ajax({
				url:"ajax1.do",
				data:{
					name:$("#name").val(),
					age:$("#age").val()
				},type:"post",
				success:function(){
					
				},error:function(){
					console("ajax 통신 실패");
				}
			});
		}
		*/
		
		function test1(){
			$.ajax({
				url:"ajax1.do",
				data:{
					name:$("#name").val(),
					age:$("#age").val()
				},success:function(result){
					console.log(result);
					//var value = "이름 : " + result[0] + "<br>나이 : " + result[1];
					//$("#result1").html(value);
					var value = "이름 : " + result.name + "<br>나이 : " + result.age;
					$("#result1").html(value);
				},error:function(){
					console.log("ajax통신실패");
				}
			})
		}
	</script>
	
	
	
	
	
	
</body>
</html>