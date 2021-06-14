<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList, com.kh.community.cPost.model.vo.*"%> 
<%
	Cpost c =(Cpost)request.getAttribute("c");
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
    .cPostContent{
        margin: auto;
        width: 950px;
        height: 750px;
        background: rgb(231, 231, 231);
    }
    #btn4{margin-right: 0px;}
    #replyBtn{width: 100px;}
    #reply-area{
        margin: auto;
        background-color:  rgb(231, 231, 231);;
        width: 950px;
        height: auto;
        margin-top:15px;
    }
    #reply-area>table{
        width: 900px;
        text-align: center;
    }
    #reply-area>table textarea{
        box-sizing: border-box;
        width: 100%;
        height: 100%;
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
    #modiCpost, #delCpost{
        margin-left: 10px;
    }
    .inner>button{
        height: 30px;
    }
    .cPostContent{
        width: 950px;
        height: 750px;
        box-sizing: border-box;
    }
    .cPostContent>table{
        width: 900px;
        height:700px;
        box-sizing: border-box;
        margin: auto;
        vertical-align: middle;
        border:1px solid rgb(180, 178, 178) ;
    }
    .cPostContent th{ width: 100px; vertical-align: middle; text-align: center;}
    #img1{
    margin:auto;
    }
</style>

</head>
<body>
<%@ include file="../../common/menubar.jsp" %>
    <div class="outer" style="margin: auto; margin-top:50px;  margin-bottom: 50px;">
        <h6 style="margin-left: 10px;">커뮤니티 > 자유게시판</h6>
       
        <h5 style="text-align:left; font-weight: bolder; margin-left: 10px;"> 자유게시판</h5>
        <p style="margin-left: 10px;">이곳은 회원들이 자유롭게 글을 작성할 수 있는 자유게시판입니다.</p>
        <br>
        <div class="inner">
            <button onclick="location.href='<%= contextPath%>/list.cp?currentPage=1'" id="btn1" class="submitB" style=" text-align:center; width: 55px;  font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 목록 </button>
            <button id="btn2" class="submitB" style=" text-align:center; width: 55px;  font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 이전글 </button>
            <button id="btn3" class="submitB" style=" text-align:center; width: 55px;  font-size:13px; background:lightgray; border: 25px; border-radius: 3px;" > 다음글 </button>
            <%if(loginUser != null) {%>
            	<button type="submit" id="btn4" class="report-button report-board btn-danger" data-toggle="modal" data-target="#reportForm" style="float: right; margin-right:20px; text-align:center; width: 70px;  font-size:13px;  border: 25px; border-radius: 3px;" > 신고하기 </button>
           	<%} %>
           	
           	<script>
            	$(function(){
            		$(document).on("click", ".report-board", function () {
                		$(".post-info #postNo").val(<%=c.getcPostNo()%>);
                		$(".post-info #refType").val("POST");
                		$(".post-info #memNo").val(<%=loginUser.getMemNo()%>);
                	}); 
            	})
            </script>
           
            <br><br>
            <h5 id="cPostTitle" style="text-align:left; font-weight: bolder; margin-left: 10px;"><%= c.getcPostTitle() %></h5>
            <br>
            <table style="margin-left: 15px;">
                <tr>
                    <th style="width:70px; margin-left:15px;">글쓴이</th>
                    <td style=" width: 110px;"><%= c.getcUserName() %></td>
                    <th style=" width:50px; margin-left:10px;">조회</th>
                    <td style="width: 50px;"><%= c.getcPostCount() %></td>
                    <th style="width:60px; margin-left:10px;">작성일</th>
                    <td style=" width: 100px;"><%= c.getcPostDate()%></td>
                </tr>
            </table>
            <Br>
            <div class="cPostContent">
                <Br>
                <table>
		            <tr>
		                <th style="border:1px solid rgb(180, 178, 178)" >내용</th>
		                <td colspan="3" style="vertical-align: middle;">
		                    <p style="height : 350px; ">
		                        	<%= c.getcPostContent() %>
		                    </p>
		                </td>
		            </tr>
		            <tr style="border:1px solid rgb(180, 178, 178)">
		                <th style="border:1px solid rgb(180, 178, 178)" >첨부파일</th>
		                <td id="img1" colspan="3">
		                       <!-- 첨부파일이 없는 이유-->
		                       <% if(list.isEmpty()){ %>
		                       		첨부파일이 없습니다. 
		                       <%}else{ %>
			                       <!-- 첨부파일이 있는 경우 -->
			                       <img src="<%= contextPath %>/<%=list.get(0).getFilePath() + list.get(0).getChangeName() %>" width=790px; height=341px;>
							   <% } %>
		                </td>
		            </tr>
                
                </table>
            </div>
            
        </div>

	        <div id="reply-area">
                <br>
	            <table  align="center">
	                <thead>
	                	<% if(loginUser != null) { %>
	                    <!--로그인이 되어있을 경우 -->
	                    
	                    <tr>
	                        <th>댓글작성</th>
	                        <td>
	                            <textarea id="replyContent" cols="50" rows="3" style="resize: none;"> 타인의 눈살을 찌푸리는 비방과 욕설이 담긴 댓글은 무통보 삭제됨을 미리 알려드립니다.</textarea>
	                        </td>
	                        <td><button onclick="insertReply();">댓글등록</button></td>
	
	                    </tr>
	                    <%}else{ %>
	
	
	                    <!--로그인이 되어있지 않은 경우-->
	                    <tr>
	                        <th>댓글작성</th>
	                        <td>
	                            <textarea cols="50" rows="3" style="resize: none;" readonly> 로그인 후에 이용가능한 서비스입니다.</textarea>
	                        </td>
	                        <td><button disabled>댓글등록</button></td>
	
	                    </tr>
	
					 <%}%>
	
	                </thead>
	                <tbody>
	                    <tr>
	                        <td>admin</td>
	                        <td>댓글내용</td>
	                        <td>2021년 5월 14일</td>
                            <td style="vertical-align: middle;"><button onclick="reportCp();" class="btn-danger" style="border-radius: 5px; font-size: 11px; vertical-align: center;" id="reportBtn">신고하기</button></td>
	                    </tr>
	
	
	                </tbody>
	            </table>
	            
	            
	            <br><br>
            
            <script>
            	$(function(){
            		selectReplyList();
            		
            		setInterval(selectReplyList,1000);
            		
            		
            		$(document).on("click", ".report-reply", function(){
            			$(".post-info #postNo").val($(this).parent().siblings("input").val());
                		$(".post-info #refType").val("REPLY");
                		$(".post-info #memNo").val(<%=loginUser.getMemNo()%>);
            		})
            		
            		
            		
            	})
            	function reportCp(){
                    location.href="<%= contextPath%>/report.cp";
                }
            	function insertReply(){
            		$.ajax({
            			url:"rinsert.cp",
            			data:{
            				content:$("#replyContent").val(),
            				cno:<%=c.getcPostNo()%>
            			}, 
            			type:"post",
            			success:function(result){
            				
            				if(result>0){ // 댓글작성 성공 => 갱신된 댓글 리스트 조회
            					selectReplyList();
            					$("#replyContent").val(""); //작성후에 댓글 작성창을 빈칸으로 만들기 위해서 이렇게 해주는거임 
            				}
            			},error:function(){
            				console.log("댓글 작성용 ajax 통신실패 "); //
            			}
            		});
            	}
            
            	function selectReplyList(){
            		$.ajax({
            			url:"rlist.cp",
            			data:{cno:<%=c.getcPostNo()%>},
            			success:function(list){
            				
            				console.log(list);//[{}, {}, ..] | []
            				
            				var result="";
            				for(var i in list){
            					result +=  "<tr>"
            							  + 	"<input type='hidden' value='" + list[i].reNo + "'>"
				                          +	   "<td>" + list[i].cUserName    + "</td>"
				                          +    "<td>" + list[i].replyContent + "</td>"
				                          +    "<td>" + list[i].writtenDate  + "</td>"
				                          +    "<td><button type='submit' id='btn4' class='report-button btn-danger report-reply' data-toggle='modal' data-target='#reportForm'>신고하기</button></td>"
				                          +"</tr>";
            				}
            				$("#reply-area tbody").html(result);
            				
            			}, error:function(){	
            				console.log("댓글조회용 ajax실패다")
            			}
            		})
            	}
            	function updateCpost(){
            		location.href="<%=contextPath%>/updateForm.cp?cno=<%= c.getcPostNo() %>";
            	}
            	function deleteCpost(){
            			if(confirm('게시글을 정말 삭제하시겠습니까? 확인버튼 클릭 이후 게시글 복구는 불가능합니다.')){
            				location.href="<%=contextPath%>/deleteForm.cp?cno=<%=c.getcPostNo()%>";
            				
            			}else{
            				location.href ="<%=contextPath%>/list.cp?currentPage=1"
            			}
            	}
            </script>
        
		</div>
		<br>
		<% if(loginUser != null && (loginUser.getMemName().equals(c.getcUserName()))){ %>
	    	
	        <button onclick="updateCpost();" id="modiCpost" class="submitB" style=" text-align:center; margin-left:20px; width: 50px; height: 30px;  font-size:10px; background:lightgray; border: 25px; border-radius: 3px;" > 수정</button>
	        <button onclick="deleteCpost();" id="delCpost" class="submitB" style=" text-align:center; width: 50px; height: 30px;  font-size:10px; background:lightgray; border: 25px; border-radius: 3px;" > 삭제</button>
	    <%} %>
		
        <br>
        <button id="toContent" class="submitB" onclick="location.href='<%= contextPath%>/list.cp?currentPage=1'" style=" text-align:center; margin: auto; width: 80px; height: 30px;  font-size:15px; background:lightgray; border: 25px; border-radius: 3px;" > 목록으로 </button>
        <br>
    </div>
    
    <%@ include file="../../common/footerbar.jsp" %>

</body>
</html>