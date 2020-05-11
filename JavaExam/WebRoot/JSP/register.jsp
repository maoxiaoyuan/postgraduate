<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>研招网注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="/PostGraduate/Style/register.css">
  </head>
  
  <body>
<div id="wrap">
    <header style="padding:5px 0px 20px 0px;">
        <div id="title">中国高等教育学生信息网</div>
        <div style="margin: 40px 0px 0px 1100px">
            <a href="/PostGraduate/JSP/logout.jsp" target="_parent">登录</a>
        </div>
    </header>
    <div id="content">
        <form action="/PostGraduate/LoginServlet.do" method="post">
                <input type="hidden" name="oper" value="register">
            <table>
                <tr>
                    <td>手机号</td>
                    <td><input type="text" name="phone_number"  id="phone_number" placeholder="请输入11位手机号"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password" id="password" placeholder="密码至少8位"></td>
                </tr>
                <tr>
                    <td>密码确认</td>
                    <td><input type="password" name="sure" id="sure" placeholder="必须与上次输入一致"></td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="user_name"id="user_name"  placeholder="请输入正确姓名"></td>
                </tr>
                <tr>
                    <td>证件类型</td>
                    <td><select name="credit_type">
                        <option value="居民身份证">居民身份证</option>
                        <option value="港澳台身份证">港澳台身份证</option>
                        <option value="华侨身份证/passport(无身份证者可填写护照号)">华侨身份证/passport(无身份证者可填写护照号)</option>
                        <option value="其他">其他</option>
                    </select></td>
                </tr>
                <tr>
                    <td>证件号码</td>
                    <td><input type="text" name="credit_number" id="credit_number" placeholder="请正确输入证件号"></td>
                </tr>
                <tr>
                    <td>安全邮箱</td>
                    <td><input type="email" name="email" id="email" placeholder="请正确输入邮箱"></td>
                </tr>
                <tr>
                <td><input type="radio" name="role" value="admin">管理部门</td>
                <td><input type="radio" name="role" value="student">学生</td>
                </tr>
                <tr>
                    <td>高校选择</td>
                    <td>
                        <select name="college_name">
                            <option value="山东财经大学">山东财经大学</option>
                            <option value="清华大学">清华大学</option>
                            <option value="北京大学">北京大学</option>
                            <option value="西安电子科技大学">西安电子科技大学</option>
                        </select>
                    </td>
                </tr>

            </table>
            <ul>
                <li><input type="checkbox" id="read">我已阅读并同意“服务条款”</li>
                <li><button type="submit" id="submit">立即注册</button></li>
            </ul>
            <p style="color:red" class="errorMessage"></p>
        </form>

    </div>
</div>
</body>

<script type="text/javascript" src="/PostGraduate/JS/jquery-1.4.2.js"></script>
<script type="text/javascript">
 	 $("#submit").click(function () {
        console.log($("#phone_number").val())
        if(!$("#phone_number").val()){
            $(".errorMessage").text("请输入手机号")
        }else if(!$("#password").val()){
            $(".errorMessage").text("请输入密码")
        }else if($("#password").val()!=$("#sure").val()){
            $(".errorMessage").text("两次输入的密码不一致")
        }else if(!$("#user_name").val()){
            $(".errorMessage").text("请输入姓名")
        }else if(!$("#credit_number").val()){
            $(".errorMessage").text("请输入证件号码")
        }else if(!$("#email").val()){
            $(".errorMessage").text("请输入邮箱")
        }else if(!$("#read").val()==0){
            $(".errorMessage").text("请同意“服务条款”")
        }else{
            $(".errorMessage").text("");
        }
        console.log($(".errorMessage").text());
        if($(".errorMessage").text()==""){
            $(".errorMessage").css({
                display:'none',
            })
            return true;
        }else{
            return false;
        }
    })
		
</script>

</html>
