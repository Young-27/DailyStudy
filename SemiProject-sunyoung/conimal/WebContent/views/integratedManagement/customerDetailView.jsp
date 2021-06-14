<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.customer.model.vo.Customer" %>
<% 
	Customer c = (Customer)request.getAttribute("c");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        height: 1200px;
        width: 800px;
        margin: auto;
        margin-top: 50px;
    }

    .customerDetail{
        height: 100%;
        width: 100%;
    }

    .customerDetail button{
        text-align: center;
        margin: auto;
    }
    .answer-area{
        margin: auto;
        width: 80%;
        height: 50%;
        border: black solid 1px;
    }
    
    .btn-float{
    	float: right;
    }
    #customerAnswer{
    	width: 80%;
    }
    #enrollAnswer-btn{
    	text-align: center;
    }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <%@ include file="../common/adminPageNavibar.jsp" %>
    <div class="outer">
    	<br>
        <div data-text-content="true" style="font-size: 16px; font-weight: bold; color: rgb(127, 127, 127);" class="text-left" spellcheck="false">통합 관리&gt; 1:1문의</div>
        <div data-text-content="true" style="font-weight: bold; font-size: 32px; color: rgb(127, 127, 127);" class="text-left" spellcheck="false">1:1문의</div>
        <br>
    	
        <a href="<%=contextPath%>/list.cu?currentPage=1" class="btn btn-float" style="background-color: rgb(187, 208, 227)">목록</a>
        <br><br>
        <div class="customerDetail">

            <table id="customerAnswer" class="text-center" border="1" align="center">
                <tr>
                    <th>작성자 아이디</th>
                    <td width="400px"><%=c.getQueId() %></td>
                </tr>
                <tr>
                    <th >문의 제목</th>
                    <td width="400px">
                    	<%=c.getQueTitle() %>
                    </td>
                </tr>
                <tr>
                    <th>문의 내용</th>
                    <td width="400px" height="200px">
                    	<%=c.getQueContent() %>
                    </td>
                </tr>
            </table>

            <br>
            <h3 style="font-weight: bold; font-size: 25px; color: rgb(127, 127, 127); margin-left: 150px;">문의 답변 작성</h3>
            	<div class="answer-area" border="1" position:relative >
                    
            		<%if(c.getAnsStatus().equals("N")){ %>
            			<br><br><br>
            			<div align="center">
	                    	등록된 답변이 없습니다. 
	                        <br><br>
	                        <a href="<%=contextPath%>/updateForm.an?cno=<%=c.getQueNo()%>" class="btn" id="enrollAnswer-btn" style="background-color: rgb(187, 208, 227)">답변등록하기</a>
                        </div>
                    <% }else{ %>
            			<%=c.getAnsContent() %>
            		<% } %>
            		
            	</div>
            
            <br><br>
        	<a href="<%=contextPath%>/updateForm.an?cno=<%=c.getQueNo()%>" class="btn btn-float" style="background-color: rgb(187, 208, 227)">수정</a>
        </div>
        
        
        
    </div>
    <%@ include file="../common/footerbar.jsp" %>
</body>
</html>