<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String user_name=(String)session.getAttribute("user_name");
OrderItemDao oid=new OrderItemDao();
List<OrderItem> oiList=new ArrayList<>();
oiList=oid.getByname(user_name);
OrderDao od=new OrderDao();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/PostGraduate/Style/table_admin.css">
	<style>
		*{
        text-decoration: none;
	    }
	   a{
	         color:blue;
	       
	    }
	    a:hover{
	    	text-decoration: underline;
	    }
	</style>

  </head>
  
  <body>
  <h1 align="center" >我的订单</h1>
  <%User u=(User)session.getAttribute("u");
            if(u!=null){ %>
		<table align='center'>
			<tr>
				<th>订单编号</th>
				<th style="width:250px">书籍名称</th>
				<th>数量</th>
				<th>总计</th>
				<th>订购时间</th>
			</tr>
	   <%for (int i=0;i<oiList.size();i++){%>
		 	<tr>
				<td> <%=oiList.get(i).getOrderitem_id()%> </td>
				<td> <%=oiList.get(i).getBook().getBook_name()%> </td>
				<td> <%=oiList.get(i).getNum()%></td>
				<td><%=oiList.get(i).getSum() %></td>
				<td><%=od.getTime(oiList.get(i).getOrder().getId()) %></td>
				
			</tr>
	   <%}%>	   	 
	</table>
	<%}else{ %>
	<p>请先登录哟~~</p>
	<%} %>
  </body>
</html>
