<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>高校信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="/PostGraduate/Style/table_admin.css">

  </head>
  
  <body>
  <h3 align="center">高校信息</h3>
<table align="center">
	<tr><th>高校名称</th>
			<th>类型</th>
			<th>排名</th>
			<th>所在城市</th>
			<th>联系电话</th>
			<th>联系邮箱</th>
	</tr>
	  
    <%
    		CollegeDao cd=new CollegeDao();
    		List<College> collegeList=new ArrayList<>();
    		collegeList=cd.query();
    		for(int i=0;i<collegeList.size();i++){
     %>
     <tr>
     		<td><%=collegeList.get(i).getCollege_name() %></td>
     		<td><%=collegeList.get(i).getCollege_type() %></td>
     		<td><%=collegeList.get(i).getCollege_rank() %></td>
     		<td><%=collegeList.get(i).getCollege_city() %></td>
     		<td><%=collegeList.get(i).getCollege_phone()%></td>
     		<td><%=collegeList.get(i).getCollege_email()%></td>
     		
     <%} %>
     </table>
  </body>
</html>
