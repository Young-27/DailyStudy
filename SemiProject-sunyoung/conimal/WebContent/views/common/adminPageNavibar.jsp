<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .admin_nav{
    	margin: auto;
        width: 200px;
        box-sizing: border-box;
        float:left;
        margin: 100px;
        position: absolute;
    }

    .admin_nav>h2{
        color: darkgray;
       
    }
    #ad_nav1{
        list-style-type:none;
        margin:0;
        padding:0;
        text-decoration:none;
        background-color: lightgray;
    }
    #ad_nav1>li{
        list-style-type: none;
        font-size: 20px;
        width: 100%;
        height:20%;
        text-align:center;
    }
    
    #ad_nav1 a{
        text-decoration: none;
        color: black;
        font-weight: bold;
        line-height: 100px;
        height: 100%;
        width: 100%;
        cursor: pointer;
        display: block;
    }

    #ad_nav1>li>ul{
        list-style-type: none;
        font-size: 17px;
        font-weight: bold;
        padding: 0;
        margin: 0;
        display: none;
    }

    #ad_nav1 a:hover{
        background: rgb(127, 127, 127);
    }
    
    #ad_nav1>li>a:hover+ul{display:block;}
    #ad_nav1>li>ul:hover{display:block;}
    


</style>
</head>
<body>
	<div class="admin_nav">
		<br>
        <div data-text-content="true" style="font-weight: bold; font-size: 32px; color: rgb(127, 127, 127);" class="" spellcheck="false" align="center">통합관리</div>
        <ul id="ad_nav1">
            
            <li><a href="/conimal/list.me?currentPage=1">회원조회</a></li>
            <li><a href="/conimal/list.re?currentPage=1">신고조회</a></li>
            <li>
                <a href="">보호소 관리</a>
                <ul>
                    <li><a>보호소 등록 관리</a></li>
                    <li><a href="">후원 등록 관리</a></li>
                </ul>
            </li>

            <li>
                <a href="">사이트소개 관리</a>
                <ul>
                    <li><a href="">사이트 소개</a></li>
                    <li><a href="">공지사항</a></li>
                </ul>
            </li>
            <li>
                <a href="/conimal/list.bo?currentPage=1">게시판 관리</a>
                <ul>
                    <li><a href="/conimal/list.bo?currentPage=1">게시판 글 조회</a></li>
                    <li><a href="/conimal/list.cu?currentPage=1">1:1 문의</a></li>
                </ul>
            </li>
            
        </ul>
    </div>


	
	
	
</body>
</html>