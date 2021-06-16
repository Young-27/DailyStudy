<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	
	<h1>AJAX개요</h1>
	
	<p>
		Asynchronous JavaScript And XML의 약자로 <br>
		서버로부터 데이터를 가져와 전체 페이지를 새로 고치지 않고 일부만 로드할 수 있게 하는 기법 <br>
		우리가 기존에 a태그로 요청 및 form을 통해 요청했던 방식은 동기식 요청이었음 => 응답페이지가 돌아와야 볼 수 있음 (페이지 깜빡거림) <br>
		비동기식 요청을 보내기 위해서는 AJAX라는 기술이 필요함 <br><br>
		
		* 동기식 / 비동기식 <br>
		- 동기식 : 요청 처리 후 그에 해당하는 응답페이지가 돌아와야만 그 다음 작업 가능함 <br>
		만약 서버에서 호출된 결과까지의 시간이 지연되면 무작정 계속 기다려야됨 (흰 페이지로 보여질거임) <br>
		전체 페이지가 리로드됨 (즉, 페이지가 기본적으로 깜빡거림) <br><br>
		
		- 비동기식 : 현재페이지를 그대로 유지하면서 중간중간마다 추가적인 필요한 요청을 보내줄 수 있음 <br>
		요청을 한다고 해서 다른페이지로 넘어가지 않음 (현재페이지 그대로임) <br>
		요청 보내놓고 그에 해당하는 응답이 돌아올때까지 현재페이지에서 다른 작업을 할 수 있음
		(즉, 페이지가 깜빡거리지 않음) <br>
		ex) 실시간 급상승 실시간 검색어 로딩, 검색어 자동완성, 아이디 중복체크, 찜하기/해제하기, 댓글작성, 추천, 무한스크롤링 등등... <br><br>
		
		* 비동기식의 단점 <br>
		- 현재 페이지에 지속적으로 리소스가 쌓임 => 페이지가 현저히 느려질 수 있음 <br>
		- 페이지 내 복잡도가 기하 급수적으로 증가 => 에러 발생시 디버깅이 어려움 <br>
		- 요청 후에 돌아온 응답데이터를 가지고 현재페이지에서 새로운 요소를 만들어서 뿌려줘야됨 => dom요소를 새로이 만들어내는 구문을 잘 익혀둬야됨 <br><br>
		
		* AJAX구현방식 --> JavaScript방식/ jQuery방식(코드가 간결하고 사용하기 쉬움)
		 
		<pre>
			* jQuery 방식에서의 AJAX 통신
			
			$.ajax({
				속성명:속성값,
				속성명:속성값,
				속성명:속성값,
				...
			})
			
			* 주요속성 (강사님 첨부 복사해오기)
			- url : 요청할 url (필수로 작성!!)
			- type|method : 요청방식 (get/post)
			- data : 요청시 전달할 값
			- success : ajax통신 성공했을 때 실행할 함수 정의
			- error : ajax통신 실패했을 때 실행할 함수 정의
			- complete : ajax 통신 실패했든 성공했든 간에 무조건 실행할 함수 정의
		</pre>
	
		<h1>jQuery 방식을 이용한 AJAX테스트</h1>
		
		<h3>1. 버튼 클릭시 get방식으로 서버에 데이터 전송 및 응답</h3>
		
		입력 : <input type="text" id="input1">
		<button id="btn1">전송</button>
		<br>
		
		응답 : <label id="output1">현재응답없음</label>
		
		<script>
			$(function(){
				$("#btn1").click(function(){
					
					// 기존에 동기식 통신 
					//location.href = 'jqAjax1.do?input=' + $("#input1").val();
					
					// 비동기식 통신 (현재페이지 그대로 유지)
					$.ajax({
						url: "jqAjax1.do",
						data: {input:$("#input1").val()},
						type: "get",
						success:function(result){
							//console.log("ajax통신성공");
							//console.log(result);
							$("#output1").text(result);
						},
						error:function(){
							console.log("ajax통신실패");
						},
						complete:function(){
							console.log("ajax통신성공여부와 상관없이 무조건 호출!!");
						}
					});
				})
			})
		</script>
		
		<br>
		
		<h3>2. 버튼 클릭시 post방식으로 서버에 여러개의 데이터 전송 및 응답</h3>
		이름 : <input type="text" id="input2_1"> <br>
		나이 : <input type="number" id="input2_2"> <br>
		<button onclick="test2();">전송</button> <br>
		
		응답 : <label id="output"></label>
		
		<ul id="output2">
		
		</ul>
		
		
		<script>
			function test2(){
				
				$.ajax({
					url:"jqAjax2.do",
					data:{
						name:$("#input2_1").val(),
						age:$("#input2_2").val()
					},
					type:"post",
					success:function(result){
						
						/*
						console.log(result);
						console.log(result[0]);
						console.log(result[1]);
						*/
						
						console.log(result);
						console.log(result.name);
						console.log(result.age);
						
						var value = "<li>" + result.name + "</li>"
								  + "<li>" + result.age + "</li>";
								  
						$("#output2").html(value);
						
						
					},error:function(){
						console.log("ajax통신 실패");
					}
					
				});
				
			}
		</script>
		
		<h3>3. 서버로 데이터 전송후, 조회된 객체를 응답데이터로 받기</h3>
		
		회원번호 입력 : <input type="number" id="input3">
		<button onclick="test3();">조회</button>
		
		<div id="output3"></div>
		
		<script>
			function test3(){
				$.ajax({
					url:"jqAjax3.do",
					data:{no:$("#input3").val()},
					success:function(result){
						
						console.log(result);
						
						var value = "이름 : " + result.userName + "<br>"
								   + "나이 : " + result.age + "<br>"
								   + "성별 : " + result.gender;
						
						$("#output3").html(value);
						
					},error:function(){
						console.log("ajax통신실패");
					}
				});
			}
		</script>		
	
		<h3>4. 응답데이터로 여러개의 객체들이 담겨있는 ArrayList 받기</h3>
		
		<button onclick="test4();">회원 전체조회</button>
		
		<br><br>
		
		<table id="output4" border="1" style="text-align:center">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>성별</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
		
		<script>
			function test4(){
				$.ajax({
					url:"jqAjax4.do",
					success:function(list){
						
						console.log(list); // 배열(객체들이 담겨있는)
						
						var result = ""
						for(var i=0; i<list.length; i++){
							//console.log(list[i].userName);
							result += "<tr>"
								   		+ "<td>" + list[i].userNo + "</td>"
								   		+ "<td>" + list[i].userName + "</td>"
								   		+ "<td>" + list[i].age + "</td>"
								   		+ "<td>" + list[i].gender + "</td>"
								    + "</tr>";
						}
						
						$("#output4 tbody").html(result);
						
					},error:function(){
						console.log("ajax통신실패");
					}
				});
			}
		</script>
	
	
	
		
	</p>
	
	
	
</body>
</html>