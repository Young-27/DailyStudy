<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.body{
		width: 1025px;
        height: 1240px;
        margin: 0 auto;
        margin-top:80px;
	}
 
  h1,h5{
      margin: 0;  
      font-weight: bold; color: rgb(127, 127, 127);          
  }
  .head1{
  	width:100%;
  	height:10%;
  	
  }
  .body1{
  	margin-bottom:30px;
  }
  .body2{
  width:100%;
  height:40%;
  }
  .foot1{
  width:100%;
  height:10%;  
  }
  .list-area{
        border:1px solid white;
        text-align:center;
       
    }
     .list-area>thead>tr>th{
      	
    	border: 1px solid #ccc;
    	word-break: break-all;
    	background: #eaeaea;    	
    	font-weight: bold;
    	display: table-cell;
   		vertical-align: inherit;
   		
  
   
     }
     .list-area>tbody>tr>td{
  		 border-bottom: 1px solid #ccc;
    	font-family: HanSans;
    	
     }
    .list-area>tbody>tr:hover{
        cursor:pointer;
    }
    .paging-area>button{
    font-size: 16px; 
    color: rgb(255, 255, 255); 
    text-align: center; 
    line-height: 2.5em; 
    border-radius: 4px; 
	background-color: rgb(244, 244, 244);
	color:black;
    border:0px;    
    width:40px;
    height:40px;
    }
     .search{
  width:264px;
  height:36px; 
  margin-bottom:30px;
  
  }
     .searchbar{
  color: rgb(94, 94, 94); 
  border-width: 1px 0px 1px 1px;
  border-radius:4px;
   border-style: solid; 
   border-color: rgb(204, 204, 204);
   width:180px;
   height:100%;
   float:right;
  }
    .searchbutton{
 
      border-width: 1px 1px 1px 1px; 
      border-style: solid; 
      border-color: rgb(204, 204, 204); 
      box-shadow: rgba(0, 0, 0, 0.0666667) 0px 1px 1px 0px inset;
       background-color: rgb(237, 237, 237);
       width:64px;
        height:100%;
        float:right;
       }
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<div class="body">  
<div class="head1">
  <h5>통합관리>후원 신청 조회</h5> 
  <h1>후원 신청 조회</h1>
 
  </div>
  <div class="head2"align="right">
  <div class="search" >
  <button class="searchbutton">검색</button>
  <input type="search" class="searchbar">
  </div>
  </div>
	<div class="body1">
  <table class="list-area">
            <thead>
                <tr>
                    <th width="50">No.</th>
                    <th width="200">사진</th>
                    <th width="100">보호소명</th>
                    <th width="175">시설 연락처</th>
                    <th width="400">내용</th>
                    <th width="100">등록일자</th>
                </tr>
            </thead>
            <tbody>
                 <tr>
		                 <td>1</td>
		                 <td><img src="resources/images/slide.png" width="200px" height="100px" ></td>
		                 <td>하얀 강아지</td>
		                 <td>010-1234-7777</td>
		                 <td>하얀 강아지는 전라북도 익산에 위치한 200여마리 강아지, 고양이들의 안전하고 따뜻한 쉼터입니다</td>
		                 <td>2021-05-16</td>
		         </tr>
		          
               
                
            </tbody>
        </table>
  </div>
  <div class="foot1">
  
        <div align="center" class="paging-area">

            	<button > &lt; </button>		
	            	<button disabled>1</button>
	            		<button >2</button>
	            		<button >3</button>
                        <button >4</button>  
                        <button >5</button>              
            	<button > &gt; </button>
		
        </div>        
  </div>
 
  
  </div>
         <%@ include file="../common/footerbar.jsp" %>
</body>
</html>