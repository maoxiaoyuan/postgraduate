<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员添加政策信息</title>
    
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
        .stra{ 
            margin:2px;
            outline: none;
            height:100px;
            font-size: 16px;
            width:200px;
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
<a href="/PostGraduate/JSP/rightStrategy.jsp" target="rightFrame">返回上一页</a>
<div id="wrap">

    <form action="/PostGraduate/AdminServlet.do" method="post">
    
       <input type="hidden" name="str" value="addStrategy">
       <p style="color:red" class="errorMessage"></p>
       <%
	       SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
	       String strategy_id=(String)df.format(new Date());
             session.setAttribute("strategy_id", strategy_id);
		     //System.out.println(strategy_id);
		     
		      %>
        <table>
            <tr>
                <td>政策内容</td>
                <td><textarea  name="strategy_content" id="strategy_content" class="stra"></textarea></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置" id="reset"></td>
                <td><button type="submit" id="submit">提交</td>
            </tr>
        </table>
    </form>

</div>
</body>
<script type="text/javascript" src="/PostGraduate/JS/jquery-1.4.2.js"></script>
<script type="text/javascript">
 	 $("#submit").click(function () {
       // console.log($("#phone_number").val())
        if(!$("#strategy_content").val()){
            $(".errorMessage").text("请输入政策内容")
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
