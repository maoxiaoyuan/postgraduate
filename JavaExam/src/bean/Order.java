package bean;

import java.sql.Timestamp;

import dao.DBConnectionUtil;

public class Order {

	
    int order_id;
    User user;
    
    private static DBConnectionUtil db;
    public int getId() {
        return order_id;
    }
    public void setId(int order_id) {
        this.order_id = order_id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
//	public Timestamp getTime() {
//		return ordertime;
//	}
//	public void setTime(Timestamp ordertime) {
//		this.ordertime = ordertime;
//	}
//	public Order(){
//		
//	}
	public Order(int order_id){
		this.order_id=order_id;
	}
	public Order() {
		db=new DBConnectionUtil();
	}
    

}
