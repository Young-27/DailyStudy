<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
	body{
		width: 1200px;
		margin: auto;
	}
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
    .shelter-area{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }
    .sh{
		background: #e0e0e0;
        width: 400px;
        height: 100px;
        margin: 15px;
	}
    table{
        margin: auto;
        margin-top: 4%;
        text-align: center;
    }
    td{padding: 3px;}
</style>
</head>
<body>

    <%@ include file="../common/menubar.jsp" %>

    <br><br>

    <h2 align="center">입소 절차</h2>

    <p class="info" align="center">
        코니멀은 아이가 정말로 좋아할 수 있는 안락하고 행복한 생활을 지향합니다
    </p>

    <br><br>

    <div class="process-area">
        <div class="pa" align="center">
            <br><br><br>
            <img src="../../resources/images/phone.png" width="80">
            <br><br>
            <h3>입소 상담 신청</h3>
        </div>
        <div class="pa" align="center">
            <br><br><br>
            <img src="../../resources/images/house.png" width="80">
            <br><br>
            <h3>보호소 방문</h3>
        </div>
        <div class="pa" align="center">
            <br><br><br>
            <img src="../../resources/images/people.png" width="80">
            <br><br>
            <h3>방문 상담</h3>
        </div>
        <div class="pa" align="center">
            <br><br><br>
            <img src="../../resources/images/success.png" width="80">
            <br><br>
            <h3>입소 완료</h3>
        </div>
    </div>

    <br><br>

    <div class="shelter-area">
        <div class="sh">
            <table>
                <tr>
                    <td width="250">XX보호소</td>
                    <td><button type="button" class="btn btn-primary">입소상담</button></td>
                </tr>
                <tr>
                    <td>서울시 강남구 테헤란로 14길 6</td>
                    <td>02-1234-5678</td>
                </tr>
            </table>
        </div>
        <div class="sh">
            <table>
                <tr>
                    <td width="250">XX보호소</td>
                    <td><button type="button" class="btn btn-primary">입소상담</button></td>
                </tr>
                <tr>
                    <td>서울시 강남구 테헤란로 14길 6</td>
                    <td>02-1234-5678</td>
                </tr>
            </table>
        </div>
        <div class="sh">
            <table>
                <tr>
                    <td width="250">XX보호소</td>
                    <td><button type="button" class="btn btn-primary">입소상담</button></td>
                </tr>
                <tr>
                    <td>서울시 강남구 테헤란로 14길 6</td>
                    <td>02-1234-5678</td>
                </tr>
            </table>
        </div>
        <div class="sh">
            <table>
                <tr>
                    <td width="250">XX보호소</td>
                    <td><button type="button" class="btn btn-primary">입소상담</button></td>
                </tr>
                <tr>
                    <td>서울시 강남구 테헤란로 14길 6</td>
                    <td>02-1234-5678</td>
                </tr>
            </table>
        </div>
        <div class="sh">
            <table>
                <tr>
                    <td width="250">XX보호소</td>
                    <td><button type="button" class="btn btn-primary">입소상담</button></td>
                </tr>
                <tr>
                    <td>서울시 강남구 테헤란로 14길 6</td>
                    <td>02-1234-5678</td>
                </tr>
            </table>
        </div>
        <div class="sh">
            <table>
                <tr>
                    <td width="250">XX보호소</td>
                    <td><button type="button" class="btn btn-primary">입소상담</button></td>
                </tr>
                <tr>
                    <td>서울시 강남구 테헤란로 14길 6</td>
                    <td>02-1234-5678</td>
                </tr>
            </table>
        </div>
        <div class="sh">
            <table>
                <tr>
                    <td width="250">XX보호소</td>
                    <td><button type="button" class="btn btn-primary">입소상담</button></td>
                </tr>
                <tr>
                    <td>서울시 강남구 테헤란로 14길 6</td>
                    <td>02-1234-5678</td>
                </tr>
            </table>
        </div>
        <div class="sh">
            <table>
                <tr>
                    <td width="250">XX보호소</td>
                    <td><button type="button" class="btn btn-primary">입소상담</button></td>
                </tr>
                <tr>
                    <td>서울시 강남구 테헤란로 14길 6</td>
                    <td>02-1234-5678</td>
                </tr>
            </table>
        </div>
    </div>

    <%@ include file="../common/footerbar.jsp" %>

</body>
</html>