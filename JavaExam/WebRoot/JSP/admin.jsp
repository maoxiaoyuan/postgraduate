<%@ page language="java" import="java.util.*,java.io.*,dao.*,bean.*,javax.naming.*,java.sql.*,javax.sql.*,mysql.jdbc.*,java.io.*"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>研招网管理部门端</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
<iframe name="topFrame" width="100%" height="100px" src="/PostGraduate/JSP/top.jsp" frameborder="0" scrolling="no"></iframe>
<iframe name="leftFrame" src="/PostGraduate/JSP/left.jsp" width="30%" height="600px" frameborder="0" scrolling="no" style="float:left;border:1px gray solid;padding:0px; margin:0px;"></iframe>
<iframe name="rightFrame" src="/PostGraduate/JSP/rightCollege.jsp" width="69.6%" height="600px"  frameborder="0" scrolling="no" style="float:right;border:1px gray solid;padding:0px; margin:0px;"></iframe>
</body>
</html>
