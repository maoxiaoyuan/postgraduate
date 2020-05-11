<%@ page language="java" import="java.util.*,javax.naming.*,java.sql.*,javax.sql.*,mysql.jdbc.driver.*,java.io.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>985、211院校</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="/PostGraduate/Style/table_admin.css">
	

  </head>
  
  <body>
  <h3 align="center">985、211高校</h3>
 <table align="center">
	<tr><th>高校名称</th>
			<th>985/211</th>
	</tr>
  <%
       request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/postmysql";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String college_name="";
		String college_985_211="";
				
		try {
		    Class.forName(driverName);
		    conn= (Connection) DriverManager.getConnection(url,"root","root");
		    String sql="select * from college_985211";
	        st=(Statement) conn.createStatement();
		    rs=st.executeQuery(sql);
	           
			while(rs.next()){
			
		        college_name=rs.getString(1);
				college_985_211=rs.getString(2);
		    	 %>	 
	        <tr>
	            <td><%=college_name%></td>
	            <td><%=college_985_211%></td>
	        </tr>    
	    <% } %>
<%
     
	    }catch (Exception e) {
	    	e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}  
%>
     </table>

  </body>
</html>
