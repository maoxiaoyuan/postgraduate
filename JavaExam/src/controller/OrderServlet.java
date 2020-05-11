package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.OrderItemDao;

import bean.Book;
import bean.Order;
import bean.OrderItem;
import bean.User;

public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String sign=request.getParameter("sign");
		//对购物车的操作进行判断
		if("add".equals(sign)){
			addOrderItem(request,response);
			
		}
		else if("delete".equals(sign)){
			deleteOrderItem(request,response);
			
		}else if("sure".equals(sign)){
			createOrder(request,response);
			
		}
	}
	//将书籍加入购物车
	private void addOrderItem(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		//String book_name=request.getParameter("book_name");
		Book book=(Book)request.getSession().getAttribute("book");
		float sum=book.getPrice()*num;
		OrderItem oi = new OrderItem();
		oi.setNum(num);
		oi.setBook(book);
		oi.setSum(sum);
//		System.out.println(book);
//		System.out.println(oi.getBook());
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		if (null == ois) {
			System.out.println("进入if语句");
			ois = new ArrayList<OrderItem>();			
		}		
		ois.add(oi);
		request.getSession().setAttribute("ois", ois);
		response.sendRedirect("/PostGraduate/JSP/ordercar.jsp");
	}

    //删除购物车中的书籍
	private void deleteOrderItem(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String del_book=request.getParameter("del_book");
		System.out.println(del_book);
        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
        System.out.println(ois.get(0).getBook().getBook_name());
        List<OrderItem> oisDelete =new ArrayList<OrderItem>();
        if(null!=ois){
        	for (OrderItem io : ois) {
        		//System.out.println("进入for循环了哟");
        		//System.out.println(io.getBook().getBook_name());
				if(io.getBook().getBook_name().equals(del_book)){
					//System.out.println("进入判断");
					oisDelete.add(io);
				}
			}
        }	
        ois.removeAll(oisDelete);
        response.sendRedirect("/PostGraduate/JSP/ordercar.jsp");	
	}
	//创建订单，并将信息写入数据库
	private void createOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		User u = (User) request.getSession().getAttribute("u");
        if(null==u){
//            response.sendRedirect("/PostGraduate/JSP/index.jsp");
            return;
        }
        Order order=new Order();
        order.setUser(u);
        OrderDao od=new OrderDao();
        od.insert(order);
        System.out.print(od.getByname(u.getUserName()));
                
        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
        if(ois!=null){
	        for (OrderItem oi : ois) {
	            oi.setOrder(order);
	            
	            new OrderItemDao().insert(oi);
	            System.out.println("for循环中OrderSureServlet=========order.getId"+oi.getOrder().getId());
	            System.out.println("for循环中OrderSureServlet=========order.getId"+oi.getNum());
	        }
	        ois.clear();
	        response.sendRedirect(request.getContextPath() +"/JSP/succussfully.jsp");
        }else{
        	response.getWriter().print("还没有商品可以购买哟");
        }
	}
}
