<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考研政策</title>
    
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
   <h3 align="center">政策信息</h3>
  <table align="center">
	<tr><th>政策类型</th>
			<th>政策院校</th>
			<th>政策内容</th>
	</tr>
	  
    <%
    		StrategyDao sd=new StrategyDao();
    		List<Strategy> strategyList=new ArrayList<>();
    		strategyList=sd.query();
    		for(int i=0;i<strategyList.size();i++){
     %>
     <tr><td><%=strategyList.get(i).getStrategy_type() %></td>
     		 <td><%=strategyList.get(i).getCollege_name() %></td>
    		 <td style="width:300px;"><a><%=strategyList.get(i).getStrategy_content() %></a></td></tr>
     <%} %>
     </table>
     
  </body>
</html>
