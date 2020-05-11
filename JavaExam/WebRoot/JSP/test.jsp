<%@ page language="java" import="java.util.*,javax.naming.*,java.io.*,java.sql.*,javax.sql.*,mysql.jdbc.driver.*,bean.Book,dao.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试页面</title>
    
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
   <h2>javabean代码调试</h2>
	    <form action="/PostGraduate/TestServlet.do" method="post">
			    <input type="text" name="user">
			    <input type="password" name="uploadFile">
			    <input type="submit">
	    </form>
    <h2>文件上传测试</h2>
	    <form action="/PostGraduate/FileLoadTest.do" method="post" enctype="multipart/form-data">
			    <input type="file" name="uploadFile">
			    <input type="submit" value="上传">
	    </form>
    <h2>文件上传测试(键值封装)</h2>
	    <form action="/PostGraduate/TestServlet.do" method="post" enctype="multipart/form-data">
			       用户名<input type="test" name="user"><br>
			    <input type="file" name="uploadFile">
			    <input type="submit" value="上传">
	    </form>
    <h2>文件写入读出</h2>
    <font>
    <%
    	File dir=new File("d:/","Student");
    	dir.mkdir();
    	File f=new File(dir,"hello.txt");
    	try{
    		FileOutputStream outfile=new FileOutputStream(f);
    		BufferedOutputStream bufferout=new BufferedOutputStream(outfile);
    		byte b[]="你们好，我是毛小园啊，很高兴认识你们啊！<BR>nice to meet you".getBytes();
    		bufferout.write(b);
    		bufferout.flush();
    		bufferout.close();
    		outfile.close();
    		FileInputStream in =new FileInputStream(f);
    		BufferedInputStream bufferin=new BufferedInputStream(in);
    		byte c[]=new byte[90];
    		int n=0;
    		while((n=bufferin.read(c))!=-1){
    			String temp=new String(c,0,n);
    			out.print(temp);
    		}
    		bufferin.close();
    		in.close();
    	}catch(IOException e){
    	}
     %>
     </font>
    <a href="/PostGraduate/download/hello.txt">下载hello.txt</a><br>    
    <a href="/PostGraduate/TestServlet.do?path=hello.txt " method="post">hello.txt</a><br/>
    <a href="<c:url value='/TestServlet.do?path=hello.txt'/>">hello.txt</a><br/>
    
    
    
  </body>
</html>
