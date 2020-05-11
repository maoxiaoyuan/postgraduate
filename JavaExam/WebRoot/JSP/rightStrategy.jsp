<%@ page language="java" import="java.util.*,javax.naming.*,java.sql.*,javax.sql.*,mysql.jdbc.driver.*,java.io.*,dao.*,bean.Strategy" pageEncoding="utf-8"%>
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
   <link rel="stylesheet" type="text/css" href="/PostGraduate/Style/table_admin.css">
	
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
</style>
<body>
<div>
    <h2>政策信息</h2>
    <table align="center">
        <tr>
            <th>政策序号</th>
            <th>政策内容</th>
            <th>是否删除</th>
        </tr>
    <%
       request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        Connection conn = DBConnectionUtil.getConn();
		Statement st=null;
		ResultSet rs=null;
		String college_name=(String)session.getAttribute("college_name");
		//System.out.println("1111111111"+college_name);
		StrategyDao sd=new StrategyDao();
        List<Strategy> strategyList = new ArrayList<>();
        strategyList=sd.getByname(college_name);
        strategyList.get(0).getStrategy_id();
       // System.out.println("------------"+strategyList+"----------");
       if(strategyList!=null){

	      for(int i=0;i<strategyList.size();i++){	          
	   %>
	   <tr>
	        <td><%=strategyList.get(i).getStrategy_id() %></td>
	   		<td style="width:250px"><%=strategyList.get(i).getStrategy_content() %></td>
            <td><a href="<%=basePath %>AdminServlet.do?str=deleteStrategy&del_strategy=<%=strategyList.get(i).getStrategy_id()%>"  
            			 onclick="if(confirm('确定添加?')==false)return false;" target="_parent">删除</a></td>
	   </tr>        
        <% }  }%>
    </table>
    <input type="submit"  id="btn_strategy" value="+添加信息" style="background: white;color:deepskyblue;
                           border:1px gray solid;border-radius:2px;width:80px;height:30px;
                           position: relative;left:750px;cursor: pointer;outline: none">
</div>
<script>
    var btn_strategy=document.getElementById("btn_strategy");
    btn_strategy.onclick=function (ev) {
        window.location.href="/PostGraduate/JSP/addStrategy.jsp";
    }
</script>
</body>
</html>
