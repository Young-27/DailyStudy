<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.attachment.model.vo.Attachment,com.kh.banner.model.service.BannerService
    							,com.kh.animal.model.vo.Animal, com.kh.animal.model.service.AnimalService
    							,java.util.ArrayList"%>
    <% Attachment at = new BannerService().selectBanner("MAINPAGE");
    	ArrayList<Animal> list = new AnimalService().selectAnimalList();%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
      
    
    .body{
        width: 1200px;
        height: 1240px;
        margin: 0 auto;
    }
    /**/
    .img1{
        position: relative;
        z-index: 1;
    }
     .animal{
        height: 20%;
        
     }
     .adoption{
        height: 20%;
     }
    
    .extitle{
        height: 15%;
        color: rgb(94, 94, 94);
        font-family: HanSans; 
        font-weight: bold;
        text-align: left; 
        width: 100%;
        margin: 10px;
    }
    .careingimg{
         height: 65%;
         width: 100%;       
         
    }
    .more{
        height: 15%;
        width: 100%;
        margin: 30px;
    }
    .animalimg{
        width: 23%;
        float: left;
        margin: 10px;        
    }
    .animalimg>img{
        width:261px;
        height:188px;
    }
        
    .more>button{
    font-size: 16px; 
    color: rgb(255, 255, 255); 
    text-align: center; 
    line-height: 2.5em; 
    border-radius: 4px; 
    background-color: rgb(127, 127, 127);
    border:0px;
    margin-right: 62px;
    }
    .product-title {
    text-align:center;
    display:table;
    border:1px solid #cecece;
    width:280px;
    height:250px;
}

.banner{
	float:right;
}


</style>
</head>

<body>

    <%@ include file="menubar.jsp" %>    
               
            <div class="body">
            <div class="imgsilde">
             <img src="<%=contextPath %>/<%=at.getFilePath() + at.getChangeName()%>" class="img1" width= "1200px"  height= "235px" >
               
            </div>
              <% if(memcode==1){ %>
            <button onclick="location.href='<%=contextPath%>/bannerUpdateForm.main'" class="banner">배너 수정</button>
            <% }%>
            <br><br><br><br>
            <div class="animal">

                <div class="extitle">
                    <h3>보호중인 아이들</h3>
                </div> 
                <div class="careingimg">
                    <div class="animalimg">
                        <image src="resources/images/dog.png" ></image>
                    </div>
                    <div class="animalimg">
                        <image src="resources/images/dog.png"></image>
                    </div>
                    <div class="animalimg">
                        <image src="resources/images/dog.png" ></image>
                    </div>
                    <div class="animalimg">
                        <image src="resources/images/dog.png"></image>
                    </div>

                </div>
                
                <div class="more" align="right">
                    <button>더보기</button>
                </div>
            </div>
            <br><br><br><br>

            <div class="adoption">
                <div class="extitle">
                    <h3>입양 후기</h3>
                </div> 
                <div class="careingimg">
                    <div class="animalimg">
                        <image src="resources/images/dog.png"></image>
                    </div>
                    <div class="animalimg">
                        <image src="resources/images/dog.png"></image>
                    </div>
                    <div class="animalimg">
                        <image src="resources/images/dog.png"></image>
                    </div>
                    <div class="animalimg">
                        <image src="resources/images/dog.png"></image>
                    </div>

                <div class="more" align="right">
                    <button>더보기</button>
                </div>

                </div>

            </div>
            </div>
       
 <%@ include file="footerbar.jsp" %>
        
</body>
</html>
