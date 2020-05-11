<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新高校信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
        #wrap{
            margin:100px 200px;
            padding:0px;
        }
        .coll_info{
            margin:2px;
            outline: none;
            height:30px;
            font-size: 16px;
        }
        #reset,#submit{
            margin:20px 50px 0px 0px;       
            padding: 5px 10px;
            font-size:16px;
            background: #85ff80;
            border-radius: 5px;
            outline: none;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>

<body>
<a href="/PostGraduate/JSP/rightCollege.jsp" target="rightFrame">返回上一页</a>
<div id="wrap">
    <form action="/PostGraduate/AdminServlet.do" method="post">
    <input type="hidden" name="str" value="updateCollegeInfo">
    <%
     		String update=request.getParameter("update");
     		session.setAttribute("update", update);
     		System.out.println(update);
     %>
        <table>
            <tr>
            <%
            		if("phone".equals(update)){
             %>
                <td>修改联系电话</td>
                <td><input type="text" name="college_phone" class="coll_info"></td>
            </tr>
            <%}else{ %>
            <tr>
                <td>修改联系邮箱</td>
                <td><input type="text" name="college_email" class="coll_info"></td>
            </tr>
            <%} %>
            <tr>
                <td><input type="reset" value="重置" id="reset"></td>
                <td><input type="submit" value="提交" id="submit" onclick="if(confirm('确定修改?')==false)return false;"></td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
