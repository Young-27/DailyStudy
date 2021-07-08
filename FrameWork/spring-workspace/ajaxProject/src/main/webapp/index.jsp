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
				success:function(result){
					console.log(result);
					$("#result1").text(result);
				},error:function(){
					console.log("ajax 통신 실패");
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
	
	<h3>2. 조회된 한 회원 객체를 응답 받아서 출력해보기</h3>
	조회할 회원번호 : <input type="number" id="userNo">
	<button id="btn">조회</button>
	
	<div id="result2"></div>
	
	<script>
		$(function(){
			$("#btn").click(function(){
				$.ajax({
					url:"ajax2.do",
					data:{num:$("#userNo").val()},
					success:function(obj){
						//console.log(obj);
						
						var value="<ul>"
									+ "<li>이름 : " + obj.userName + "</li>"
									+ "<li>나이 : " + obj.age + "</li>"
									+ "<li>아이디 : " + obj.userId + "</li>"
								+ "</ul>";
								
						$("#result2").html(value);
					},error:function(){
						console.log("ajax통신실패");
					}
				})
			})
		})
	</script>
	
	<h3>3. 조회된 회원 객체 리스트 응답받기</h3>
	<button onclick="test2();">회원 전체 조회</button>
	<br><br>
	<table border="1" id="tableList">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	
	<script>
		function test2(){
			$.ajax({
				url:"ajax3.do",
				success:function(arr){
					console.log(arr);
					
					var value="";
					for(var i in arr){
						value += "<tr>"
									+ "<td>" + arr[i].userId + "</td>"
									+ "<td>" + arr[i].userName + "</td>"
									+ "<td>" + arr[i].age + "</td>"
									+ "<td>" + arr[i].phone + "</td>"
							  + "</tr>";
					}
					
					$("#tableList tbody").html(value);
				},error:function(){
					console.log("ajax통신 실패");
				}
			})
		}
	</script>
	
	
	
	
	
	
	
</body>
</html>