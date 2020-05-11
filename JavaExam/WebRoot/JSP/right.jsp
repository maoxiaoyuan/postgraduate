<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商城右侧导航栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
	*{
	   		padding:0px;
	   }
	#rignt{
	
		     list-style:none;
		}
       #index{
            padding-top: 10px; 
            height:1200px;
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
             display: inline-block;
   			 width: 92px;
            text-align: center;
        }
        .change,a:hover{
            color:white;
            background: #ffa275;
            cursor: pointer;
        }
</style>
  </head>
   
  
  <body>
    <div id="right">
        <div align="center" style="margin:20px 0px">
        <%User u=(User)session.getAttribute("u");
            if(u!=null){ %>
                 欢迎 你！${user_name}  同学
        <% }else{%>
             <p> 请先登录</p>
            <%} %>
         </div>
         
	    <div id="index">
	        <ul>
	            <li><a href="/PostGraduate/JSP/bookstore.jsp" id="1" target="leftFrame" class="change" onclick="change()">书籍商城</a></li>
	            <li><a href="/PostGraduate/JSP/ordercar.jsp" id="2" target="leftFrame"  onclick="change()">购物车</a></li>
	            <li><a href="/PostGraduate/JSP/orderitem.jsp" id="3" target="leftFrame"  onclick="change()">我的订单</a></li>
	            
	        </ul>
	        
	    </div>
	    
</div>
  </body>
  <script>
  //
  function change(){
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
  	change();
  	
  
  </script>
 
</html>
