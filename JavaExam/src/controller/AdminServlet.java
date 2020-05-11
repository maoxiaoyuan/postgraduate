package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;

import bean.*;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		  String str=request.getParameter("str");
			System.out.print(str);
		  HttpSession session=request.getSession();
		  String college_name=(String)session.getAttribute("college_name");		 
		  //判断用户请求是什么
			if("addMajor".equals(str)){
				//执行增加专业方法
				addMajor(request,response);
			      
			      return;
			}else if("deleteMajor".equals(str)){
				System.out.println("deleteMajor");
				//执行删除专业方法
				deleteMajor(request,response);
				return;
				
			}else if("addStrategy".equals(str)){  
				//执行增加政策方法
				addStrategy(request,response);
			     
				 return;
			      
			}else if("deleteStrategy".equals(str)){
				//执行删除政策方法
				deleteStrategy(request,response);
				
			}else if("updateCollegeInfo".equals(str)){
				//执行院校更新操作
			        Connection conn=(Connection)DBConnectionUtil.getConn();
			        Statement st=null;
					String college_phone=request.getParameter("college_phone");
					String college_email=request.getParameter("college_email");
					String update=(String)session.getAttribute("update");
					int count = 0;
					//判断是对手机号还是电子邮箱修改
						try {
							if("phone".equals(update)){				
							      String sql="update college set college_phone='"+college_phone+"' where college_name='"+college_name+"'";
							      st=(Statement) conn.createStatement();
							      count = st.executeUpdate(sql);			
									System.out.println(count);
								 request.getRequestDispatcher("/JSP/admin.jsp").forward(request, response);
							      return;
							}else{
								   String sql="update college set college_email='"+college_email+"' where college_name='"+college_name+"'";
						           st=(Statement) conn.createStatement();
								   count = st.executeUpdate(sql);
									System.out.println(count);

									response.sendRedirect("/PostGraduate/JSP/admin.jsp");	
									return;
							  }
							} catch (SQLException e) {
					            e.printStackTrace();
					        } finally {
					            DBConnectionUtil.closeup(st, conn);
					        }
					}else if("deleteFile".equals(str)){
						deleteFile(request,response);
						
					}
			   return;
	}



//增加专业信息
	private void addMajor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String college_name=(String)request.getSession().getAttribute("college_name");
		String major_name=request.getParameter("major_name");
	      String major_rank=request.getParameter("major_rank");
	      String institution=request.getParameter("institution");
	      String persons=request.getParameter("persons");
	      String form=request.getParameter("form");
	      Major major=new Major(college_name,major_name,major_rank,institution,persons,form);
	      MajorDao md=new MajorDao();		      
	      System.out.println(md.add(major));		
	      response.sendRedirect("/PostGraduate/JSP/rightMajor.jsp");			
	}
//删除专业信息
	private void deleteMajor(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String college_name=(String)request.getSession().getAttribute("college_name");
		String del_major=request.getParameter("del_major");
		System.out.println("del_major"+del_major);
        List<Major> majs = (List<Major>) request.getSession().getAttribute("majorList");
        if(null!=majs){
        	for (Major m : majs) {
        		System.out.println("进入for循环了哟");
				if(m.getMajor_name().equals(del_major)){
					System.out.println("进入判断");
					System.out.println("m.getMajor_name()"+m.getMajor_name());
//					Major major=new Major();
					MajorDao md=new MajorDao();
					md.delete(college_name, del_major);		
				}
			}
        }	
        response.sendRedirect("/PostGraduate/JSP/admin.jsp");	
		
	}
	//增加政策信息
	private void addStrategy(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String college_name=(String)request.getSession().getAttribute("college_name");
		String strategy_id=(String)request.getSession().getAttribute("strategy_id");		     
		 String strategy_content=request.getParameter("strategy_content");
		 String strategy_type="college";
		 Strategy strategy=new Strategy(strategy_id,strategy_type,strategy_content,college_name);
		 StrategyDao sd=new StrategyDao();
		 System.out.println(sd.add(strategy));
		 response.sendRedirect("/PostGraduate/JSP/rightStrategy.jsp");	
		
	}
//删除政策信息
	private void deleteStrategy(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String college_name=(String)request.getSession().getAttribute("college_name");
		String del_strategy=request.getParameter("del_strategy");
		System.out.println("删除的政策的id是del_strategy"+del_strategy);
		
		StrategyDao sd=new StrategyDao();
		sd.delete(del_strategy);		//调用DAO层方法
        response.sendRedirect("/PostGraduate/JSP/admin.jsp");				
	}
	//从数据库删除文件信息
	private void deleteFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int del_file=Integer.parseInt(request.getParameter("del_file"));
		FileDao fd=new FileDao();
		fd.delete(del_file);
		response.sendRedirect("/PostGraduate/JSP/admin.jsp");	
		
	}

}
