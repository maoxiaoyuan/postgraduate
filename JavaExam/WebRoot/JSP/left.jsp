<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员端左侧导航栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	   <style>
	   *{
	   		padding:0px;
	   }
        #information{
            height:100px;
            padding-top:10px;
        }
        #information p{
            font-size:26px;
            position:relative;
            left:112px;
        }
       #index{
            padding-top: 10px; 
            height:454px;
            background: #fff2c9;
        }
        ul li {
            margin:5px;
            list-style:none;
            position:relative;
            left:100px;
            padding:20px 20px 2px 0px;
            font-size:18px;

        }
        a{
            padding:10px;
            background: #90ffba;
            text-decoration: none;
            color:black;
        }
        .change,a:hover{

            color:white;
            background: #ffa275;
            cursor: pointer;
        }
        
    </style>
</head>
<body>
<div id="left">
    <div id="information">
        <p>山东财经大学</p>
    </div>
    <div id="index">
        <ul>
            <li><a href="/PostGraduate/JSP/rightCollege.jsp" id="1" target="rightFrame" class="change" onclick="leftchange()">高校信息</a></li>
            <li><a href="/PostGraduate/JSP/rightMajor.jsp" id="2" target="rightFrame"  onclick="leftchange()">专业信息</a></li>
            <li><a href="/PostGraduate/JSP/rightStrategy.jsp" id="3"  target="rightFrame"  onclick="leftchange()">政策信息</a></li>
            <li><a href="/PostGraduate/JSP/rightFile.jsp" id="4" target="rightFrame"  onclick="leftchange()">文件上传</a></li>
        </ul>
    </div>
</div>
</body>
  <script>
  //
  function leftchange(){
		  	var as=document.getElementsByTagName("a");
		  	for(var i=0;i<as.length;i++){
		  	as[i].onclick=function(){
		  	 //alert("进入点击事件了");
		  	   this.className="change";
		  	    for(var j=0;j<as.length;j++){
		  	       if(as[j].id!=this.id){
		  	           // alert(as[j].id+"   "+this.id+"  "+this.className);
		  	       		as[j].className="";
		  	       }
		  	      }
		  	}
		
		}
  	}
  	leftchange();
  	
  
  </script>
 
</html>
