<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.body{
		width: 1100px;
        height: 1240px;
        margin: 0 auto;
        margin-top:30px;
	}
	
  h1,h5{
      margin: 0;  
      font-weight: bold; 
      color: rgb(127, 127, 127);          
  }
  .head1{
  	width:100%;
  	height:10%;
  	margin-top:50px;
  	margin-left:100px;
  	
  }
  .head2{
   width:100%;
  	height:5%;
  }
  .search{
  width:264px;
  height:36px; 
  
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
  .body1{
  	width:100%; 
  	margin-bottom:50px; 
  	margin-left:100px;	
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
   
     .writebutton{
    float:right;
    font-size: 16px;
    color: rgb(64, 64, 64);
    text-align: center;
    line-height: 2.5em;
    background-color: rgb(224, 224, 224);   
    border:0px;
    border-radius: 4px; 
    width: 100px; 
    height: 40px;
  }
	</style>
</head>

	
<body>

<%@ include file="../../common/menubar.jsp" %>
<div class="body">  
<div class="head1">
  <h5>통합관리>보호소 등록 신청 조회</h5> 
  <h1>보호소 등록 신청 조회</h1>
 
  </div>
  <div class="head2"align="right">
  <div class="search" >
  <button class="searchbutton">검색</button>
  <input type="search" class="searchbar">
  </div>
  </div>
	<div class="body1">
  <table class="list-area" >
            <thead>
                <tr>
                    <th width="50">No.</th>
                    <th width="100">지역</th>
                    <th width="150">보호소명</th>
                    <th width="365">주소</th>
                    <th width="200">연락처</th>
                    <th width="100">신청일자</th>
                </tr>
            </thead>
            <tbody>
                 <tr>
		                 <td>1</td>
		                 <td>서울특별시</td>
		                 <td>아이조아</td>
		                  <td>서울시 송파구 석촌호수로</td>
		                   <td>010-2282-2828</td>
		                    <td>2021-05-24</td>
		         </tr>
		           <tr>
		                 
		                 <td>1</td>
		                 <td>서울특별시</td>
		                 <td>아이조아</td>
		                  <td>서울시 송파구 석촌호수로</td>
		                   <td>010-2282-2828</td>
		                    <td>2021-05-24</td>
		         </tr>
		           <tr>
		                
		                <td>1</td>
		                 <td>서울특별시</td>
		                 <td>아이조아</td>
		                  <td>서울시 송파구 석촌호수로</td>
		                   <td>010-2282-2828</td>
		                    <td>2021-05-24</td>
		         </tr>
		         <tr>
		         	<td>1</td>
		                 <td>서울특별시</td>
		                 <td>아이조아</td>
		                  <td>서울시 송파구 석촌호수로</td>
		                   <td>010-2282-2828</td>
		                    <td>2021-05-24</td>
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
         <%@ include file="../../common/footerbar.jsp" %>
</body>
</html>