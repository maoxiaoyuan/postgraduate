package bean;


import dao.DBConnectionUtil;

public class Book {
	
	
	private String book_name;
	private  float price;
	private  String book_type;
	
	private static DBConnectionUtil db;
	public Book(){
		db=new DBConnectionUtil();
	}
	public Book(String book_name){
		super();
		this.book_name=book_name;
	}
	public Book(String book_name,float price){
		super();
		this.book_name=book_name;
		this.price=price;
	}
	public Book(String book_name, float price, String book_type) {
		super();
		this.book_name=book_name;
		this.price=price;
		this.book_type=book_type;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((book_name == null) ? 0 : book_name.hashCode());
		result = prime * result
				+ ((book_type == null) ? 0 : book_type.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (book_name == null) {
			if (other.book_name != null)
				return false;
		} else if (!book_name.equals(other.book_name))
			return false;
		if (book_type == null) {
			if (other.book_type != null)
				return false;
		} else if (!book_type.equals(other.book_type))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [book_name=" + book_name + ", price=" + price
				+ ", book_type=" + book_type + "]";
	}
	
}
