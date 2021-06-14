<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		width: 1200px;
		margin: auto;
	}
	.info{margin-left: 320px;}
	.process-area{
		display: flex;
		justify-content: space-between;
		margin-left: 15%;
		margin-right: 15%;
	}
	.pa{
		background: #e0e0e0;
		width: 180px;
		height: 240px;
		border-radius: 30px;
	}
	.pic{
		border: 1px solid black;
		width: 75px;
		height: 75px;
	}
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>

	<h2 align="center">입양 자격</h2>

	<p class="info">
		* 경제적 능력이 있고 반려동물을 사랑하는 18세 이상의 신원확인이 가능한 성인<br>
		* 입양 후 매달 아이 생활 사진을 보내주실 수 있는 분
	</p>

	<br><br><br>

	<h2 align="center">입양 절차</h2>

	<br>

	<div class="process-area">
		<div class="pa" align="center">
			<br><br><br>
			<img src="../../resources/images/phone.png" width="80">
			<br><br>
			<h4>보호중인 아이들 확인 후 문의</h4>
		</div>
		<div class="pa" align="center">
			<br><br><br>
			<img src="../../resources/images/house.png" width="80">
			<br><br>
			<h4>보호소 방문</h4>
		</div>
		<div class="pa" align="center">
			<br><br><br>
			<img src="../../resources/images/document.png" width="80">
			<br><br>
			<h4>책임분양계약 및 입양</h4>
		</div>
	</div>

	<br><br>
	
	<%@ include file="../common/footerbar.jsp" %>

</body>
</html>