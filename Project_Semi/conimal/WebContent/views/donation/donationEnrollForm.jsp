<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
       .body{
            width:700px;
            margin:auto;
            margin-top:50px;
        }
        table{margin:auto;}
        table th, table td{height:40px;}
        table th{width:150px; text-align:left;}
        table td{width:400px;}
      
        table input{line-height:25px;}
        #title, #name, #phone, #email{width:350px;}


        table p{font-size:13px;}

        .enroll>button{
            font-size: 16px; 
            color: rgb(255, 255, 255); 
            text-align: center; 
            line-height: 2.5em; 
            border-radius: 4px; 
            background-color: rgb(127, 127, 127);
            border:0px;
            margin-right: 62px;
        }
      
      
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="body">
        <h2 align="center">후원 등록 요청</h2>
        <br>
        <form action="" id="donation-form" method="post">
            <h3 align="center">등록 정보 입력</h3>
            <hr>
            <table>
                <tr>
                    <th>제목
                        <td><input type="text" id="title" placeholder="제목을 입력해주세요." required> </td>
                    </th>
                </tr>
                <tr>
                    <th>보소호명
                        <td><input type="text" id="name" placeholder="보호소명을 입력하세요." required> </td>
                    </th>
                </tr>
                <tr>
                    <th>연락처
                        <td><input type="phone" id="phone" placeholder="연락처를 입력하세요."></td>
                    </th>
                </tr>
                <tr>
                    <th>이메일
                        <td><input type="email" id="email" placeholder="이메일을 입력하세요."></td>
                    </th>
                </tr>
                <tr>
                    <th>상세설명
                        <td><textarea name="" id="" cols="50" rows="10" placeholder="내용을 입력하세요."></textarea></td>
                    </th>
                </tr>
                <tr>
                    <th>사진첨부
                        <td>
                            <input type="file">
                        </td>
                    </th>
                </tr>
                <tr>
                    <th>주의사항
                        <td>
                            <div>
                                <input type="checkbox" id="checkB"> <label for="checkB">아래사항에 동의합니다.</label> 
                                <p>
                                    ※ 자원봉사 모집 글은 목적의 변질 및 광고성 게시물 등으로의 수정을 방지하기 위하여 등록 후 수정, 삭제가 되지 않습니다. <br>
                                    ※ 해당 게시판의 목적에 맞지 않는 글을 등록할 경우, 글이 삭제될 수 있습니다.
                                </p>
                            </div>
                        </td> 
                    </th>
                </tr>

            </table>
            <br><br>
            <div class="enroll" align="center">
                <button>등록하기</button>
            </div>

        </form>

    </div>
    
    <%@ include file="../common/footerbar.jsp" %>
    
	
	

</body>
</html>