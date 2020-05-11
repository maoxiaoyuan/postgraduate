<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考研参考书目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		#wrap{
			margin:0px;
			padding:0px;
		}
	</style>

  </head>
  
  <body>
  <div id="wrap">
		<iframe name="leftFrame" src="/PostGraduate/JSP/bookstore.jsp" width="74.5%" height="100%" frameborder="0"  style="float:left;border:1px gray solid;padding:0px; margin:0px;"></iframe>
		<iframe name="rightFrame" src="/PostGraduate/JSP/right.jsp" width="25%" height="100%"  frameborder="0" scrolling="no" style="float:right;border:1px gray solid;padding:0px; margin:0px;"></iframe>
  </div>
  </body>
</html>
