<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>研究生招生系统</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/PostGraduate/Style/index.css">
</head>

<body>
<div id="wrap">
   <p id="title">研究生招生系统登录</p>
    <div id="login">
        <form action="/PostGraduate/LoginServlet.do" method="post">
        <input type="hidden" name="oper" value="login">
        <%
           Object obj=request.getAttribute("flag");
           if(obj!=null){
         %>
         <p style="text-algin:center;padding-left:100px;color:red;font-weight:bold;font-size:15px">用户名或密码错误</p>
        <%} %>
            <table>
                <tr>
                    <td> 用户账号：<input type="text" name="user_name" class="inp"></td>
                </tr>
                <tr>
                    <td> 用户密码：<input type="password" name="password" class="inp"> </td>
                </tr>
                <tr>
                    <td>验证码: <input type="text" name="checkcode" style="margin:10px 0px;width:200px;height:40px">
                    <img src="/PostGraduate/CreateCodeServlet.do" onclick="this.src = this.src + '?'"  title="点击更换验证码" style="cursor: pointer" ></td>
                </tr>
                <tr>
                    <td><input type="radio" name="role" value="admin">管理部门
                            <input type="radio" name="role" value="student">学生 
                            <input type="checkbox" name="remember" style="zoom:140%;font-size:15px"> 记住密码3天</td>
                </tr>

                <tr>
                    <td><input type="reset" value="重置" id="reset">     
                            <input type="submit" value="登录" id="submit"></td>
                </tr>
            </table>
        </form>
        <ul>
            <li><a href="#">找回用户名</a><a href="#">找回密码</a></li>
            <li><a href="/PostGraduate/JSP/register.jsp">注册</a></li>
        </ul>
    </div>
</div>
</body>
</html>
