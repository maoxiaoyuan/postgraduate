<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员添加专业信息</title>
    
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
        .maj{
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
<a href="/PostGraduate/JSP/rightMajor.jsp" target="rightFrame">返回上一页</a>
<div id="wrap">

    <form action="/PostGraduate/AdminServlet.do" method="post"   target="rightFrame">
       <input type="hidden" name="str" value="addMajor">
       <p style="color:red" class="errorMessage"></p>
        <table>
            <tr>
                <td>专业名称</td>
                <td><input type="text" name="major_name" id="major_name" class="maj"></td>
            </tr>
            <tr>
                <td>专业排名</td>
                <td><input type="text" name="major_rank" id="major_rank" class="maj"></td>
            </tr>
            <tr>
                <td>隶属学院</td>
                <td><input type="text" name="institution"  id="institution" class="maj"></td>
            </tr>
            <tr>
                <td>录取人数</td>
                <td><input type="text"  name="persons" id="persons" class="maj"></td>
            </tr>
            <tr>
                <td>录取形式</td>
                <td><input type="text"  name="form" id="form"  class="maj"></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置" id="reset"></td>
                <td><button type="submit" value="提交" id="submit" >提交</td>
            </tr>
        </table>
    </form>

</div>
</body>
<script type="text/javascript" src="/PostGraduate/JS/jquery-1.4.2.js"></script>
<script type="text/javascript">
 	 $("#submit").click(function () {
       // console.log($("#phone_number").val())
        if(!$("#major_name").val()){
            $(".errorMessage").text("请输入专业名称")
        }else if(!$("#major_rank").val()){
            $(".errorMessage").text("请输入专业排名")
        }else if(!$("#institution").val()){
            $(".errorMessage").text("请输入所属学院")
        }else if(!$("#persons").val()){
            $(".errorMessage").text("请输入录取人数")
        }else if(!$("#form").val()){
            $(".errorMessage").text("请输入录取形式")
        }else{
            $(".errorMessage").text("");
        }
        console.log($(".errorMessage").text());
        if($(".errorMessage").text()==""){
            $(".errorMessage").css({
                display:'none',
            })
           if(confirm('确定添加?')==true)
            return true;
        }else{
            return false;
        }
    })
		
</script>
</html>
