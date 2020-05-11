<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'filetest.jsp' starting page</title>
    
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
    <h2>文件下载</h2>
     		<%
     				//获得响应客户的输出流
     				OutputStream o=response.getOutputStream();
     				byte b[]=new byte[500];
     				File fileLoad =new File("d:/story","book.zip");
     				response.setHeader("Content-disposition", "attachment;filename=book.zip");
     				response.setContentType("application/x-tar");
     				long fileLength=fileLoad.length();
     				String length=String.valueOf(fileLength);
     				response.setHeader("Content_Length", length);
     				FileInputStream in=new FileInputStream(fileLoad);
     				int n=0;
     				while((n=in.read(b))!=-1){
     					o.write(b,0,n);
     					
     				}
     				o.close();
     				in.close();
     				
     		 %>
   
  </body>
</html>
