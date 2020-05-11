<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
        
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
        header{
            width:100%;
            height:100px;

        }
        header #title{
             font-family:serif;
            font-size:51px;
            letter-spacing: 2px;
            font-weight: bold;
            float:left;
        }
        a{
            color:black;
        }
        header a:hover{
            color:deepskyblue;
            text-decoration: underline;
        }
    </style>
</head>

<body>
<header style="padding:5px 0px 0px 0px;">
    <div id="title">研招网管理部门端</div>
    <div style="margin: 40px 0px 0px 1000px;">
        欢迎你！${user_name}
        <a href="/PostGraduate/JSP/logout.jsp" style="border-left: 2px solid black" target="_parent">安全退出</a>
    </div>
</header>
</body>
</html>
