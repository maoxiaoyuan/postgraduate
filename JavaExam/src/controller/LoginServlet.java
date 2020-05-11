package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;



import bean.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			this.doPost(request, response);
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String oper=request.getParameter("oper");
		//根据oper判断是哪个页面发出的请求
		if("login".equals(oper)){
			//登录页面发出的请求
			checkUserLogin(request,response);
			
		}else if("register".equals(oper)){
			//注册页面发出的请求
			addUserInfo(request,response);
			
		}else{
		System.out.print("没有找到操作符"+oper);
		}
	
	}
    //注册页面(添加新用户到数据库中)
	private void addUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//从前端获取注册信息
		 String  user_name=request.getParameter("user_name");
		 String password=request.getParameter("password");
		 String  phone_number=request.getParameter("phone_number");
		 String  credit_type=request.getParameter("credit_type");
		 String  credit_number=request.getParameter("credit_number");
		 String  email=request.getParameter("email");
		 String role=request.getParameter("role");
		 String college_name=request.getParameter("college_name");
		 User user=new User(user_name,password,phone_number,credit_type,credit_number,email,role,college_name);
		 System.out.println(user);
		 UserDao ud=new UserDao();
		 System.out.println(ud.add(user));
		 request.getRequestDispatcher("/JSP/index.jsp").forward(request, response);
		 
	}
    //登录页面（根据请求响应）
	private void checkUserLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out=response.getWriter();
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		
		String role=request.getParameter("role");
		String input_checkcode=request.getParameter("checkcode");
		String checkcode =(String) request.getSession().getAttribute("checkcode");
		
		String remember=request.getParameter("remember");
		//判断是否选中记住我3天
		if ("on".equals(remember)) {
            Cookie c = new Cookie("users", user_name + "-" + password);
            System.out.println(user_name+password);
            c.setMaxAge(60*60*24*3);
            response.addCookie(c);
		} else {
            Cookie c = new Cookie("users", user_name + "-" + password);
            c.setMaxAge(0);
            response.addCookie(c);
        }

       //根据请求做出不同的响应，跳转jsp
		User u=new User(user_name,password);
		request.getSession().setAttribute("u", u);
		if(u!=null && input_checkcode.toLowerCase().equals(checkcode)&&role.equals("student")){
			
			//跳转到学生页面
			request.getSession().setAttribute("user_name",user_name);
			out.print(user_name);
			response.sendRedirect("/PostGraduate/JSP/homepage.jsp");
			return;
			
		}else if(u!=null && input_checkcode.toLowerCase().equals(checkcode)&&role.equals("admin")){
			//跳转到管理员页面
			request.getSession().setAttribute("user_name",user_name);
			out.print(user_name);
			response.sendRedirect("/PostGraduate/JSP/admin.jsp");
			return;
		}
		else{
			//添加标识符到request
			request.setAttribute("flag", 0);
			request.getRequestDispatcher("/JSP/index.jsp").forward(request, response);
			return;

		}
		
	}
}
