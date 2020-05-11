<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加购物车</title>
    
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
	        text-decoration: none;
	    }
	   a{
	         color:blue;
	       
	    }
	    a:hover{
	    	text-decoration: underline;
	    }
    #submit:hover{
		background:#a5eca5;
         }
</style>
<link rel="stylesheet" type="text/css" href="/PostGraduate/Style/table_admin.css">

  </head>
  
  <body>
  <div align="center"   style="margin-top:100px;">
  <%User u=(User)session.getAttribute("u");
       if(u!=null){ %>
	 当前用户: <%=session.getAttribute("user_name")%>
	 <%
	 String book_name=request.getParameter("book_name");
	 float book_price=Float.parseFloat(request.getParameter("book_price"));
	 Book book=new Book(book_name,book_price);
	 session.setAttribute("book", book);
	  %>
 <table style="margin-top:20px">
		<tr>
			<th>名称</th>
			<th>价格</th>
			<th>数量</th>
			<th>购买</th>
		</tr>
		 	<tr>
				<td> <%=book_name%> </td>
				<td> <%=book_price%></td>
				
					<form action="/PostGraduate/OrderServlet.do?sign=add" method="post">
					    <td><input type="text" value="1" name="num" style="text-align: center;"> </td>
						<td><input type="submit" value="加入购物车" id="submit" style="background: white;border: 1px solid green;cursor:pointer"></td>
					</form>
			</tr>		 		
	</table>
	<%}else{ %>
	<p>请先登录哟~~~</p>
	<%} %>
</div>
    
  </body>
</html>
