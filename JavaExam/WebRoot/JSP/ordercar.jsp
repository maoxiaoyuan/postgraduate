<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=UTF-8");
List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois"); 
float summary=0;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
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
    <h1 align="center" >购物车</h1>
    <%
    	if(ois!=null){ %> 
		<table align='center'>
			<tr>
				<th style="width:250px">书籍名称</th>
				<th>单价</th>
				<th>数量</th>
				<th>小计</th>
				<th>删除</th>
			</tr>
	   <%for (int i=0;i<ois.size();i++){
	        summary+=ois.get(i).getSum();%>
		 	<tr>
				<td> <%=ois.get(i).getBook().getBook_name()%> </td>
				<td> <%=ois.get(i).getBook().getPrice()%> </td>
				<td> <%=ois.get(i).getNum()%></td>
				<td><%=ois.get(i).getSum() %></td>
            <td><a href="<%=basePath %>OrderServlet.do?sign=delete&del_book=<%=ois.get(i).getBook().getBook_name()%>" target="leftFrame" >删除</a></td>
				
			</tr>
	   <%}%>
	   <tr>
            <td colspan="5" align="right">
               <span>总计：<%=summary %></span>
                <a href="<%=basePath %>OrderServlet.do?sign=sure" target="leftFrame" >确认购买</a>
            </td>
          </tr>	   	 
	</table>
	<%}else{%> 
			<h5>购物车空空如也~~~</h5>
		<% } %>
	
  </body>
</html>
