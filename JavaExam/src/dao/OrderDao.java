package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Book;
import bean.Order;
import bean.OrderItem;

public class OrderDao {
	
	public static void main(String[] args) {
//    	List<Order> os=new ArrayList<>();
//    	OrderDao od=new OrderDao();
    	String user="毛园";
    	System.out.println(getByname(user).get(0).getId());
    	System.out.println(getByname(user).get(1).getId());
    }
	public void Order(){}
	/*
	 * 获取最大编号
	 */
	public static int getDataBaseId() {
        int maxId = 0;// 存放最大的编号值，默认值设为0.
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn= DBConnectionUtil.getConn();
        String sql = "select max(order_id) from ordershop ";
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
	 * 插入订单
	 */
public void insert(Order order) { 
	
    try {        
    	Date date=new Date();     
    	Timestamp timeStamp =new Timestamp(date.getTime()) ;
    	System.out.println("timestamp======="+timeStamp);
    	Connection conn= DBConnectionUtil.getConn();
        String sql = "insert into ordershop(order_id,user_name,ordertime) values(?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, getDataBaseId());
        pstmt.setString(2, order.getUser().getUserName());
       System.out.println(getDataBaseId()+order.getUser().getUserName());
       pstmt.setTimestamp(3, timeStamp);
       pstmt.execute();   
    	DBConnectionUtil.close(pstmt, conn);
    } catch (SQLException e) {
        e.printStackTrace();
    }

}
/*
 * 查询订单明细
 */

public static String getTime(int order_id ) {
    PreparedStatement pstmt = null;
    Connection conn = DBConnectionUtil.getConn();
    String sql = "select * from ordershop where order_id=?";
    ResultSet rs = null;
    String time = null;
    try {
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, order_id);
        rs = pstmt.executeQuery();
        while (rs.next()) {
        	time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("ordertime"));
//        	time=rs.getTimestamp("ordertime");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBConnectionUtil.close(pstmt, rs, conn);
    }
    return time;
}
public static List<Order> getByname(String user_name ) {
    PreparedStatement pstmt = null;
    Connection conn = DBConnectionUtil.getConn();
    String sql = "select * from ordershop where user_name=?";
    ResultSet rs = null;
    List<Order> orderList = new ArrayList<>();
    try {
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user_name);
        rs = pstmt.executeQuery();
        while (rs.next()) {
        	 Order order=new Order();
        	 order.setId(rs.getInt("order_id"));
            orderList.add(order);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBConnectionUtil.close(pstmt, rs, conn);
    }
    return orderList;
}



}
