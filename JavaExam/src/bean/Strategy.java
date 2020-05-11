package bean;

import dao.DBConnectionUtil;

public class Strategy {
	private String strategy_id;
	private String strategy_type;
	private String strategy_content;
	private String college_name;
	
	private static DBConnectionUtil db;
	
	
	public String getStrategy_id() {
		return strategy_id;
	}
	public void setStrategy_id(String strategy_id) {
		this.strategy_id = strategy_id;
	}
	public String getStrategy_type() {
		return strategy_type;
	}
	public void setStrategy_type(String strategy_type) {
		this.strategy_type = strategy_type;
	}
	public String getStrategy_content() {
		return strategy_content;
	}
	public void setStrategy_content(String strategy_content) {
		this.strategy_content = strategy_content;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	
	@Override
	public String toString() {
		return "Strategy [strategy_id=" + strategy_id + ", strategy_type="
				+ strategy_type + ", strategy_content=" + strategy_content
				+ ", college_name=" + college_name + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((college_name == null) ? 0 : college_name.hashCode());
		result = prime
				* result
				+ ((strategy_content == null) ? 0 : strategy_content.hashCode());
		result = prime * result
				+ ((strategy_id == null) ? 0 : strategy_id.hashCode());
		result = prime * result
				+ ((strategy_type == null) ? 0 : strategy_type.hashCode());
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
		Strategy other = (Strategy) obj;
		if (college_name == null) {
			if (other.college_name != null)
				return false;
		} else if (!college_name.equals(other.college_name))
			return false;
		if (strategy_content == null) {
			if (other.strategy_content != null)
				return false;
		} else if (!strategy_content.equals(other.strategy_content))
			return false;
		if (strategy_id == null) {
			if (other.strategy_id != null)
				return false;
		} else if (!strategy_id.equals(other.strategy_id))
			return false;
		if (strategy_type == null) {
			if (other.strategy_type != null)
				return false;
		} else if (!strategy_type.equals(other.strategy_type))
			return false;
		return true;
	}
	public Strategy(){
		db=new DBConnectionUtil();
	}
	public Strategy(String strategy_content){
		this.strategy_content=strategy_content;
	}
	public Strategy(String strategy_id,String strategy_content){
		this.strategy_id=strategy_id;
		this.strategy_content=strategy_content;
	}
	public Strategy(String strategy_type,String strategy_content,String college_name){

		this.strategy_type=strategy_type;
		this.strategy_content=strategy_content;
		this.college_name=college_name;
	}
	public Strategy(String strategy_id,String strategy_type,String strategy_content,String college_name){

		this.strategy_id=strategy_id;
		this.strategy_type=strategy_type;
		this.strategy_content=strategy_content;
		this.college_name=college_name;
	}
	

}
