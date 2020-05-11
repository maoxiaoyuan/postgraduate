<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>专业信息</title>
    
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
  <h3 align="center">专业信息</h3>
<table align="center">
	<tr><th>专业名称</th>
			<th>排名</th>
			<th>隶属学院</th>
	</tr>
	  <%
     	String college_name="山东财经大学";	
		MajorDao md=new MajorDao();
        List<Major> majorList = new ArrayList<>();
        majorList=md.getByName(college_name);
	      for(int i=0;i<majorList.size();i++){	          
	   %>
        <tr>
            <td><%=majorList.get(i).getMajor_name()%></td>
            <td><%=majorList.get(i).getMajor_rank() %></td>
            <td><%=majorList.get(i).getInstitution() %></td>
        </tr>    
<% } %>
     </table>
  </body>
</html>
