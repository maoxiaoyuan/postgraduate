package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;


import bean.Book;
import dao.BookDao;

public class TestServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out=response.getWriter();
		
//		Map<String, Object>map=new HashMap<String, Object>();
//		String user=(String)request.getParameter("user");
//		Object file=(Object)request.getParameter("uploadFile"); 
//		map.put("user", user);
//		map.put("file", file);
//		System.out.println(map);
		
		
		String filename = request.getParameter("path");
		System.out.println(filename);
		// GET请求中，参数中包含中文需要自己动手来转换。
		// 当然如果你使用了“全局编码过滤器”，那么这里就不用处理了
		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		 
//		String filepath = this.getServletContext().getRealPath("/download/" + filename);
//		String filepath = this.getServletContext().getRealPath("/WEB-INF/" + filename);
		String filepath = this.getServletContext().getRealPath( filename);
		System.out.println(filepath);
		File file = new File(filepath);
		if(!file.exists()) {
		 response.getWriter().print("您要下载的文件不存在！");
		 return;
		}
		// 所有浏览器都会使用本地编码，即中文操作系统使用GBK
		// 浏览器收到这个文件名后，会使用iso-8859-1来解码
		filename = new String(filename.getBytes("GBK"), "ISO-8859-1");
		response.addHeader("content-disposition", "attachment;filename=" + filename);
		IOUtils.copy(new FileInputStream(file), response.getOutputStream());
		 
//        BookDao book=new BookDao();
//        List<Book> bookList = new ArrayList<>();
//        List<Book> bookList2 = new ArrayList<>();
//        List list=new ArrayList();
//        bookList =book.getByBookname("中国近代史纲要");
//        bookList2 = book.getByBookname("思想道德修养与法律基础");
//        list.add(bookList.get(0));
//        list.add(bookList2.get(1));        
//        request.getSession().setAttribute("book",bookList);
//        System.out.println(bookList.get(0).getBook_name());
//        System.out.println(bookList.get(0).getPrice());
//		System.out.println(list); 
//		try {
//		    Class.forName(driverName);
//		    conn= (Connection) DriverManager.getConnection(url,"root","root");
//		    String sql="select college_name, college_type, college_city, college_rank, college_phone, college_email from uc_college where user_name='毛小园";
//	        st=(Statement) conn.createStatement();
//		    rs=st.executeQuery(sql);
//		
//		while(rs.next()){
//			out.print(rs.getString(1)+" ;"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getString(4)+";"+rs.getString(5)+";"+rs.getString(6));
//		}
//
//	    }catch (Exception e) {
//	    	e.printStackTrace();
//		}finally{
//			try {
//				rs.close();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			try {
//				st.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//		}
//	    	
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//璁剧疆鏃ユ湡鏍煎紡
       String strategy_id=(String)df.format(new Date());
		System.out.println(strategy_id);
		 System.out.println(df.format(new Date()));
	    }
}

