<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎进入研究生招生系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <iframe name="bannerFrame" width="100%" height="220px" src="/PostGraduate/JSP/banner.jsp" frameborder="0" scrolling="no"></iframe>
	<iframe name="contentFrame" src="/PostGraduate/JSP/homecontent.jsp" width="100%" height="700px" frameborder="0" scrolling="no"></iframe>  
  </body>
</html>
