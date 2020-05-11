<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/PostGraduate/Style/banner.css">
	<script type="text/javascript" src="/PostGraduate/JS/jquery-1.4.2.js"></script>
	<style>
	*{
	    text-decoration: none;
	    list-style: none;
	}
	#wrap{
	    margin:0px auto;
	    background:#a9e4c1c7;;
	    background-size:100% 100%;
	    height: 100%;
	}
	header #title{
	    color: black;
	    font:65px cursive;
	    letter-spacing: 20px;
	    text-shadow: 0px 1px 0px #999,0px 2px 0px #888, 0px 3px 0px #777;
	    font-weight: bold;
	    float:left;
	}
	header a{
	    color:black;
	}
	header a:hover,#banner ul li a:hover{
	    text-decoration: underline;
	}
	</style>
  </head>
  
  <body>
  <div id="wrap">
   <header style="padding:5px 0px 20px 0px;">
        <div id="title">中国研究生招生系统</div>
        
        <div style="margin: 40px 0px 0px 1100px">
        <%
        	User u=(User)session.getAttribute("u");
            if(u!=null){
         %>
                 欢迎 你！${user_name}  同学
        <a href="/PostGraduate/JSP/logout.jsp" style="border-left: 2px solid black" target="_parent">安全退出</a>
        <%}else{
         %>
          <a href="/PostGraduate/JSP/index.jsp"  target="_parent" style="font-size:18px">登录</a>
          <a href="/PostGraduate/JSP/register.jsp" style="border-left: 2px solid black;font-size:18px" target="_parent">注册</a>
          <%} %>
        </div>

    </header>
    <div id="menu">
    <ul id="nav">
        <li class="mainlevel" id="mainlevel_01"><a>首页</a>
            <ul id="sub_01">
                <li><a href="/PostGraduate/JSP/homecontent.jsp" target="contentFrame">进入首页</a></li>
            </ul>
        </li>

        <li class="mainlevel" id="mainlevel_02"><a>资讯</a>
            <ul id="sub_02">
                <li><a href="/PostGraduate/JSP/showStrategy.jsp" target="contentFrame">政策信息</a></li>
                <li><a href="/PostGraduate/JSP/showFiles.jsp" target="contentFrame">招生简章</a></li>

            </ul>
        </li>

        <li class="mainlevel" id="mainlevel_03"><a>信息库</a>
            <ul id="sub_03">
                <li><a href="/PostGraduate/JSP/showCollege.jsp" target="contentFrame">院校库</a></li>
                <li><a href="/PostGraduate/JSP/show985_211.jsp" target="contentFrame">985/211高校库</a></li>
                <li><a href="/PostGraduate/JSP/showMajor.jsp" target="contentFrame">专业库</a></li>
            </ul>
        </li>

        <li class="mainlevel" id="mainlevel_04"><a>考研商城</a>
            <ul id="sub_04">
                <li><a href="/PostGraduate/JSP/bookOrder.jsp" target="contentFrame">进入商城</a></li>
            </ul>
        </li>
       <!--  <div class="clear"></div> -->
    </ul>
</div>
  </div>
  </body>
  <script type="text/javascript">
  		//menu
	$(document).ready(function(){
	  
		  $('li.mainlevel').mousemove(function(){
		  $(this).find('ul').slideDown();//you can give it a speed
		  });
		  $('li.mainlevel').mouseleave(function(){
		  $(this).find('ul').slideUp("fast");
		  });
	  
	});
  </script>
</html>
