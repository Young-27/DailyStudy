<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
    <div class="outer">
        <br><h1 align="center">게시판 상세조회</h1>

        <table align="center" class="table-area" border="1">
            <tr>
                <td width="100">글번호</td>
                <td width="500">10</td>
            </tr>
            <tr>
                <td>제목</td>
                <td>글제목~~~~~~~~~</td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>admin</td>
            </tr>
            <tr>
                <td>조회수</td>
                <td>100</td>
            </tr>
            <tr>
                <td>작성일</td>
                <td>2021-06-05</td>
            </tr>
            <tr>
                <td>내용</td>
                <td height="100">
                   	 글 내용 아아아ㅏㄱ
                </td>
            </tr>
        </table>
        <br>

        <table align="center" class="table-area" border="1">
            <tr>
                <th width="100">댓글작성</th>
                <td width="400"><textarea rows="3" cols="60" style="resize:none"></textarea></td>
                <th width="100"><button>등록</button></th>
            </tr>
            <tr>
                <td colspan="3"><b>댓글(3)</b></td>
            </tr>
            <tr>
                <td>user01</td>
                <td>댓글내용</td>
                <td>2021-06-08</td>
            </tr>
            <tr>
                <td>user01</td>
                <td>댓글내용</td>
                <td>2021-06-08</td>
            </tr>
            <tr>
                <td>user01</td>
                <td>댓글내용</td>
                <td>2021-06-08</td>
            </tr>
        </table>
        <br>
    </div>
</body>
</html>