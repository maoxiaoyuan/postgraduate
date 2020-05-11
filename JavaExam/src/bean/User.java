package bean;

import dao.DBConnectionUtil;


public class User {
	private String  user_name;
	private String password;
	private String  phone_number;
	private String  credit_type;
	private String  credit_number;
	private String  email;
	private String role;
	private String college_name;
	
	private static DBConnectionUtil db;
	
	
	
	public String getUserName() {
		return user_name;
	}
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phone_number;
	}
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getCreditType() {
		return credit_type;
	}
	public void setCreditType(String credit_type) {
		this.credit_type = credit_type;
	}
	public String getCreditNumber() {
		return credit_number;
	}
	public void setCreditNumber(String credit_number) {
		this.credit_number = credit_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCollegeName() {
		return college_name;
	}
	public void setCollegeName(String college_name) {
		this.college_name = college_name;
	}
	
	
	
	@Override
	public String toString() {
		return "User [user_name=" + user_name
				+ ", password=" + password + ", phone_number=" + phone_number
				+ ", credit_type=" + credit_type + ", credit_number="
				+ credit_number + ", email=" + email + ", role=" + role
				+ ", college_name=" + college_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}
	public User(){
		db=new DBConnectionUtil();
	}
	public User(String user_name,String password){

		this.user_name=user_name;
		this.password=password;
	}
	public User(String user_name,String password,String phone_number,
			String credit_type,String credit_number,String email,String role,String college_name){
		this.user_name=user_name;
		this.password=password;
		this.phone_number=phone_number;
		this.credit_type=credit_type;
		this.credit_number=credit_number;
		this.email=email;
		this.role=role;
		this.college_name=college_name;
	}
}
