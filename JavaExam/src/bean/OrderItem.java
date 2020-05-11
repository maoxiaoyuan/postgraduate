package bean;

public class OrderItem {
	private int orderitem_id;
	private Book book;
	private int num;
    private Order order;
    private float sum;
    
    public int getOrderitem_id() {
		return orderitem_id;
	}
	public void setOrderitem_id(int orderitem_id) {
		this.orderitem_id = orderitem_id;
	}
    public Order getOrder() {
        return order;
    }
   
	public void setOrder(Order order) {
        this.order = order;
    }

	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public OrderItem(){
		
	}
//	public OrderItem(int orderitem_id,String book_name,int order_id,int num,float sum){
//		this.orderitem_id=orderitem_id;
//		this.book.setBook_name(book_name);
//		this.order.setId(order_id);
//		this.num=num;
//		this.sum=sum;
//		
//	}
	

}
