<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .outer{
        background: lightskyblue;
        color: white;
        width: 1000px;
        height: 500px;
        margin: auto;
        margin-top: 50px;
    }

    #enroll-form>table{border:1px solid white}
    #enroll-form input, #enroll-form textarea{
        width: 100%;
        box-sizing: border-box;
    }
</style>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <br><h2 align="center">공지사항 작성하기</h2>

        <form id="enroll-form" action="insert.no" method="post">
            <table align="center">
                <tr>
                    <th width="50"> 제목 </th>
                    <td width="350"><input type="text" name="title" required></td>
                </tr>

                <tr>
                    <th>내용</th>
                    <td></td>
                </tr>

                <tr>
                    <td colspan="2">
                        <textarea name="content" rows="10" style="resize:none" required></textarea>
                    </td>
                </tr>

            </table>
            <br><br>
            <div align="center">
                <button type="submit">등록하기</button>
                <button type="button" onclick="histoty.back();">뒤로가기</button>
            </div>
        </form>
    </div>


</body>
</html>