<%@ page language="java" import="java.util.*,javax.naming.*,java.sql.*,javax.sql.*,java.io.*,dao.*,bean.Major" pageEncoding="utf-8"%>
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

  </head>
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
    <h2>专业信息</h2>
    <table align="center">
        <tr>
            <th>专业名称</th>
            <th>专业排名</th>
            <th>隶属学院</th>
            <th>录取人数</th>
            <th>录取形式</th>
            <th>删除</th>
        </tr>
  <%
       request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String college_name=(String)session.getAttribute("college_name");
		
		//System.out.println("1111111111"+college_name);
		MajorDao md=new MajorDao();
        List<Major> majorList = new ArrayList<>();
        
        majorList=md.getByName(college_name);
        session.setAttribute("majorList", majorList);
//	    System.out.println("------------"+majorList+"----------");

	      for(int i=0;i<majorList.size();i++){	          
	   %>
 
        <tr>
            <td><%=majorList.get(i).getMajor_name()%></td>
            <td><%=majorList.get(i).getMajor_rank() %></td>
            <td><%=majorList.get(i).getInstitution() %></td>
            <td><%=majorList.get(i).getPersons() %></td>
            <td><%=majorList.get(i).getForm() %></td>
            <td><a href="<%=basePath %>AdminServlet.do?str=deleteMajor&del_major=<%=majorList.get(i).getMajor_name()%>" target="_parent"
                       onclick="if(confirm('确定删除?')==false)return false;" >删除</a></td>
        </tr>    
<% } %>
   </table>
<input type="submit" id="btn_major" value="+添加信息" style="background: white;color:deepskyblue;border:1px gray solid;
                           border-radius:2px;width:80px;height:30px;position: relative;
                           left:750px;cursor: pointer;outline: none">
</div>
<script>
    var btn_major=document.getElementById("btn_major");
    btn_major.onclick=function (ev) {
         window.location.href="/PostGraduate/JSP/addMajor.jsp";
        
    }
</script>
  </body>
</html>
