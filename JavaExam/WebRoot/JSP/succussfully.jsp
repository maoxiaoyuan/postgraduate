<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单创建成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="5;URL=/PostGraduate/JSP/bookstore.jsp">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
		a{
			text-decoration: none;
		}
</style>
  </head>
  
  <body>
  <div align="center">
    <h3>订单创建成功!</h3>
    <span id="spa">5</span><span>秒钟后为您跳转商城! !</span>
  </div>
  
  </body>
  <script>
    var spa=document.getElementById("spa");
    var i=4;
    var timer;
    (function () {
      timer= setInterval(function () {
         spa.innerText=i--;
        },1000)
    })()
</script>
</html>
