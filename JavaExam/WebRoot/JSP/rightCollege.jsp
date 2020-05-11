<%@ page language="java" import="java.util.*,javax.naming.*,java.sql.*,javax.sql.*,mysql.jdbc.driver.*,java.io.*" pageEncoding="utf-8"%>
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
	*{
	     list-style:none;
	}
	li{
	     margin:30px;
	         font-size: 18px;
	}
	 .coll_info{
            color: #9d9d9d;
            font_size:14px;
        }
        a{
            font-size: 16px;
            text-decoration: none;
            padding-left:100px;
            color:blue;
                       
        }
        a:hover{
            text-decoration: underline;
        }
	</style>
</head>
<body>
<div>
<%
       request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/postmysql";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String college_name="";
		String college_type="";
		String college_city="";
		String college_rank="";
		String  college_phone="";
		String college_email="";
		String user_name=(String)session.getAttribute("user_name");
		//System.out.println("--------------"+user_name);
		
		try {
		    Class.forName(driverName);
		    conn= (Connection) DriverManager.getConnection(url,"root","root");
		    String sql="select college.college_name, college_type, college_city, college_rank, college_phone, college_email from users, college where users.college_name=college.college_name and user_name='"+user_name+"'";
		    //System.out.println("--------------"+sql);
	        st=(Statement) conn.createStatement();
		    rs=st.executeQuery(sql);
	           
		while(rs.next()){
		
	        college_name=rs.getString(1);
			college_type=rs.getString(2);
	        college_city=rs.getString(3);
	        college_rank=rs.getString(4);
	        college_phone=rs.getString(5);
	        college_email=rs.getString(6);	
	        //将college_name放到session中，并在rightMajor中获取
	        request.getSession().setAttribute("college_name",college_name);
	        request.getSession().setAttribute("college_phone",college_phone);
	        
        }
	    	 %>
    <h2>高校信息</h2>
    <ul>
        <li>
            <span>高校名称：</span><span class="coll_info"><%= college_name%></span>
        </li>
        <li>
            <span>高校类型：</span><span class="coll_info"><%=college_type %></span>            
        </li>
        <li>
            <span>所在地：</span><span class="coll_info"><%= college_city%></span>            
        </li>
        <li>
            <span>排名：</span><span class="coll_info"><%= college_rank%></span>
        </li>
        <li>
            <span>电话：</span><span class="coll_info"><%=college_phone %></span>
                <a href="/PostGraduate/JSP/updateCollegeInfo.jsp?update=phone" target="rightFrame">修改</a>
        </li>
        <li>
            <span>邮箱：</span><span class="coll_info"><%=college_email %></span>
                <a href="/PostGraduate/JSP/updateCollegeInfo.jsp?update=email" target="rightFrame">修改</a>
            
        </li>
    </ul>
</div>

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
</body>
</html>
