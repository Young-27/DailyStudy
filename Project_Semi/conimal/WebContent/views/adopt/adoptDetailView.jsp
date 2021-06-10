<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList, com.kh.adopt.model.vo.*"%>   
<%
	Adopt a =(Adopt)request.getAttribute("a");
	// 번호, 작성자, 제목, 내용, 조회수, 작성일 ?0? 이거 어디서 담아온건데?
	Attachment at = (Attachment)request.getAttribute("at");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
%>   
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
    .outer{
        margin: auto;
        margin-top:50px;
        margin-bottom: 50px;
        width: 1000px;

    }
    .innert>p{float: left;}
    .adoptContent{
        margin: auto;
        width: 950px;
        height: 750px;
        background: rgb(231, 231, 231);
    }
    #btn4{margin-right: 0px;}
    #replyBtn{width: 100px;}

    .replyContent{
        margin: auto;
        background: rgb(231, 231, 231);
        width: 950px;
        height: 250px;
    }
    .replyContent>table{
       
        margin-top:10px;
        margin-bottom: 5px;
        margin-left: 15px ;
    }
    #modify, #delbtn, #fire{
        float: right;
        margin-right: 10px;
    }
    #replyT{
        width: 900px;
    }
    .replyF{
        box-sizing: border-box;
        margin: auto;
        width: 950px;
        height: 110px;
       
        width: 950px;
    }
    .replyF>h6{
        margin-left: 15px;
    }
    .replyF input{
        margin-top: 10px;
        margin-left: 15px;
        width: 95%;
        height: 70px;
    }
    #replyText{float: right; margin-top: 5px; margin-right: 35px;}
    #toContent{
        margin: auto;
        display: table;
    }
    #modiAdopt{
        margin-left: 10px;
    }
    .inner>button{
        height: 30px;
    }
    .adoptContent{
        width: 950px;
        height: 750px;
        box-sizing: border-box;
    }
    .adoptContent>table{
        width: 900px;
        height:700px;
        box-sizing: border-box;
        margin: auto;
        vertical-align: middle;
        border:1px solid rgb(180, 178, 178) ;
    }
    .adoptContent th{ width: 100px; vertical-align: middle; text-align: center;}
    
    
</style>

</head>
<body>
<%@ include file="../common/menubar.jsp" %>
    <div class="outer" style="margin: auto; margin-top:50px;  margin-bottom: 50px;">
        <h6 style="margin-left: 10px;">입양후기</h6>
       
        <h5 style="text-align:left; font-weight: bolder; margin-left: 10px;">입양후기</h5>
        <p style="margin-left: 10px;">소중한 생명들의 새로운 시작을 함께 축하해주세요:)</p>
        <br>
        <div class="inner">
            <button  onclick="location.href='<%= contextPath%>/list.ad?currentPage=1'" id="btn1" class="submitB" style=" text-align:center; width: 55px;  font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 목록 </button>
            <%if(loginUser != null) {%>
            	<button type="submit" id="btn4" class="report-button btn-danger" data-toggle="modal" data-target="#reportForm" style="float: right; margin-right:20px; text-align:center; width: 70px;  font-size:13px;  border: 25px; border-radius: 3px;" > 신고하기 </button>
           	<%} %>
            <script>
            	$(function(){
            		$(document).on("click", ".report-button", function () {
                		$(".post-info #postNo").val(<%=a.getAdoptNo()%>);
                		$(".post-info #refType").val("ADOPT");
                		$(".post-info #memNo").val(<%=loginUser.getMemNo()%>);
                	}); 
            	})
            </script>
            <br><br>
            <h5 id="adoptTitle" style="text-align:left; font-weight: bolder; margin-left: 10px;"> <%=a.getAdoptTitle() %></h5>
         
            <table id="adopt" style="margin-left: 15px;">
                <tr>
                    <th style="width:70px; margin-left:15px;">글쓴이</th>
                    <td style=" width:100px;"><%= a.getAdoptWriter() %></td>
                    <th style=" width:47px; margin-left:10px;">조회</th>
                    <td style="width: 50px;"><%= a.getCount() %></td>
                    <th style="width:50px; margin-left:10px;">작성일</th>
                    <td style=" width: 100px;"><%= a.getAdoptDate() %></td>
                    <th style="width:70px; margin-left:10px;">보호소명</th>
                    <td style=" width: 100px;"><%= a.getMemNo() %></td>
                    
                </tr>
            </table>
            <Br>
            <div class="adoptContent">
                <Br>
                <table>
		            <tr>
		                <th style="border:1px solid rgb(180, 178, 178)" >내용</th>
		                <td colspan="3" style="vertical-align: middle;">
		                    <p style="height : 350px; ">
		                        	<%= a.getAdoptContent() %>
		                    </p>
		                </td>
		            </tr>
		            <tr style="border:1px solid rgb(180, 178, 178)">
		                <th style="border:1px solid rgb(180, 178, 178)" >첨부파일</th>
		                <td id="img1" colspan="3">
		                      <% if(list.isEmpty()){ %>
		                       		첨부파일이 없습니다. 
		                       <%}else{ %>
			                       <img src="<%=contextPath%>/<%=list.get(0).getFilePath() + list.get(0).getChangeName() %>" width=790px; height=341px;>
							   <% } %> 
		                </td>
		            </tr>
                
                </table>
            </div>
            
        </div>

        <br>
        <button onclick="location.href='<%= contextPath%>/list.ad?currentPage=1'" id="toContent" class="submitB" style=" text-align:center; margin: auto; width: 80px; height: 30px;  font-size:15px; background:lightgray; border: 25px; border-radius: 3px;" > 목록으로 </button>
        <br>
        <% if(loginUser != null && (loginUser.getMemNo()==Integer.parseInt(a.getAdoptWriter()))){ %>
        	<button  onclick="updateAdopt();" id="modiAdopt" class="submitB" style=" text-align:center; margin-left:20px; width: 50px; height: 30px;  font-size:10px; background:lightgray; border: 25px; border-radius: 3px;" > 수정</button>
        <%} %>
    </div>
    
    <script>
    
	    function updateAdopt(){
			location.href="<%=contextPath%>/updateForm.ad?ano=<%= a.getAdoptNo() %>";
		}
    </script>
    
    <%@ include file="../common/footerbar.jsp" %>

</body>
</html>