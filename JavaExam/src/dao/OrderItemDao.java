package dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Book;
import bean.Order;
import bean.OrderItem;
import bean.Strategy;


public class OrderItemDao {
    public static void main(String[] args) {
//    	List<OrderItem> ol=new ArrayList<>();
//    	OrderDao od=new OrderDao();
//    	String user="毛园";
//    	ol=new OrderItemDao().getByname(user);
//    	System.out.println(ol.get(0).getId());
//    	System.out.println(ol.get(0).getBook().getBook_name());
//    	System.out.println(ol.get(0).getNum());
//    	System.out.println(ol.get(0).getSum());
//    	System.out.println(od.getTime(ol.get(0).getId()));
 
    }
    /**
     * 获取编号值,在最大编号值的基础上加1。
     */
    public static int getDataBaseId() {
        int maxId = 0;// 存放最大的编号值，默认值设为0.
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select max(orderitem_id) from orderitem";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnectionUtil.close(pstmt, rs,conn);
        }
        return maxId + 1;
    }
    /*
     * 增加订单明细
     */
    public void insert(OrderItem orderitem) {
//    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
//	    String order_id=(String)df.format(new Date());
    	OrderDao od=new OrderDao();
        try {
   
        	        
            Connection conn= DBConnectionUtil.getConn(); 
            String sql = "insert into orderitem(orderitem_id,book_name,order_id,number,sum) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,getDataBaseId());
            pstmt.setString(2,orderitem.getBook().getBook_name());                   
            pstmt.setInt(3,new OrderDao().getDataBaseId()-1);
            //System.out.println("orderitem.getOrder().getId()"+orderitem.getOrder().getId());
            //System.out.println("orderitem.getOrder().getId()"+orderitem.getNum());
            pstmt.setInt(4,orderitem.getNum());
            pstmt.setFloat(5, orderitem.getSum());
            pstmt.execute();
            DBConnectionUtil.close(pstmt, conn);
         } catch (SQLException e) {
            e.printStackTrace();
        }
         
    }
    /*
     * 查询订单明细
     */

    public static List<OrderItem> getByname(String user_name ) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from orderitem,ordershop where orderitem.order_id=ordershop.order_id and user_name=?";
        ResultSet rs = null;
        List<OrderItem> orderitemList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	 OrderItem orderitem=new OrderItem();
            	 orderitem.setOrderitem_id(rs.getInt("orderitem_id"));
            	 orderitem.setBook(new Book(rs.getString("book_name")));
            	 
            	 orderitem.setOrder(new Order(rs.getInt("order_id")));
            	 orderitem.setNum(rs.getInt("number"));
            	 orderitem.setSum(rs.getFloat("sum"));
                orderitemList.add(orderitem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }
        return orderitemList;
    }
    
 
}