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
    }
    
    #customerAnswer{
    	width: 80%;
    }
    #ansContent{
    	margin: auto;
        width: 80%;
        height: 50%;
        border: black solid 1px;
    }
    .btn-float{
    	float:right;
    }
    
</style>
</head>
<body>
	<%@ include file="../common/adminPageNavibar.jsp" %>
    <%@ include file="../common/menubar.jsp" %>
    
    <div class="outer">
    	<br>
    	<div data-text-content="true" style="font-size: 16px; font-weight: bold; color: rgb(127, 127, 127);" class="text-left" spellcheck="false">통합 관리&gt; 1:1문의</div>
        <div data-text-content="true" style="font-weight: bold; font-size: 32px; color: rgb(127, 127, 127);" class="text-left" spellcheck="false">1:1문의</div>
    	<br>
        <a href="<%=contextPath %>/list.ca?currentPage=1" class="btn btn-float text-left" style="background-color: rgb(187, 208, 227)">목록</a>
        <br><br>
        <div class="customerDetail">
			<input type="hidden" name="cno" value="<%=c.getQueNo()%>">
            <table id="customerAnswer" class="text-center" border="1" align="center">
                <tr>
                    <th>작성자 아이디</th>
                    <td width="400px"><%=c.getQueId() %></td>
                </tr>
                <tr>
                    <th>문의 제목</th>
                    <td width="400px">
                    	<%=c.getQueTitle() %>
                    </td>
                </tr>
                <tr>
                    <th>문의 내용</th>
                    <td width="400px" height="200px"><%=c.getQueContent()%></td>
                </tr>
            </table>

            <br>

            <h3 style="font-weight: bold; font-size: 25px; color: rgb(127, 127, 127); margin-left: 150px;">문의 답변 작성</h3>
                
            	<div class="answer-area">
                    <form action="<%=contextPath%>/update.ca" method="post">
                        <input type="hidden" name="cno" value="<%=c.getQueNo()%>">
                        <%if(c.getAnsContent()!=null){%>
                        	<textarea name="ansContent" cols="88" rows="20" style="resize: none;"><%=c.getAnsContent() %></textarea>
                        <% }else{ %>
                        	<textarea name="ansContent" cols="88" rows="20" style="resize: none;"></textarea>
                        <% } %>
                        <br><br>
                        
			            <div class=button-area align="center">
			                <button type="reset" class="btn" style="background-color: lightgray">초기화</button>
			                <button type="submit" class="btn" style="background-color: rgb(187, 208, 227)">등록</button>
			            </div>
                    </form>
                    
            	</div>
            
            
        
        </div>
    </div>
    <%@ include file="../common/footerbar.jsp" %>
</body>
</html>