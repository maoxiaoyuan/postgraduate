package bean;

public class College {
	private String college_id;
	private String college_name;
	private String college_type;
	private String college_city;
	private String college_rank;
	private String college_phone;
	private String college_email;
	public String getCollege_id() {
		return college_id;
	}
	public void setCollege_id(String college_id) {
		this.college_id = college_id;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getCollege_type() {
		return college_type;
	}
	public void setCollege_type(String college_type) {
		this.college_type = college_type;
	}
	public String getCollege_city() {
		return college_city;
	}
	public void setCollege_city(String college_city) {
		this.college_city = college_city;
	}
	public String getCollege_rank() {
		return college_rank;
	}
	public void setCollege_rank(String college_rank) {
		this.college_rank = college_rank;
	}
	public String getCollege_phone() {
		return college_phone;
	}
	public void setCollege_phone(String college_phone) {
		this.college_phone = college_phone;
	}
	public String getCollege_email() {
		return college_email;
	}
	public void setCollege_email(String college_email) {
		this.college_email = college_email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((college_city == null) ? 0 : college_city.hashCode());
		result = prime * result
				+ ((college_email == null) ? 0 : college_email.hashCode());
		result = prime * result
				+ ((college_id == null) ? 0 : college_id.hashCode());
		result = prime * result
				+ ((college_name == null) ? 0 : college_name.hashCode());
		result = prime * result
				+ ((college_phone == null) ? 0 : college_phone.hashCode());
		result = prime * result
				+ ((college_rank == null) ? 0 : college_rank.hashCode());
		result = prime * result
				+ ((college_type == null) ? 0 : college_type.hashCode());
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
		College other = (College) obj;
		if (college_city == null) {
			if (other.college_city != null)
				return false;
		} else if (!college_city.equals(other.college_city))
			return false;
		if (college_email == null) {
			if (other.college_email != null)
				return false;
		} else if (!college_email.equals(other.college_email))
			return false;
		if (college_id == null) {
			if (other.college_id != null)
				return false;
		} else if (!college_id.equals(other.college_id))
			return false;
		if (college_name == null) {
			if (other.college_name != null)
				return false;
		} else if (!college_name.equals(other.college_name))
			return false;
		if (college_phone == null) {
			if (other.college_phone != null)
				return false;
		} else if (!college_phone.equals(other.college_phone))
			return false;
		if (college_rank == null) {
			if (other.college_rank != null)
				return false;
		} else if (!college_rank.equals(other.college_rank))
			return false;
		if (college_type == null) {
			if (other.college_type != null)
				return false;
		} else if (!college_type.equals(other.college_type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "College [college_id=" + college_id + ", college_name="
				+ college_name + ", college_type=" + college_type
				+ ", college_city=" + college_city + ", college_rank="
				+ college_rank + ", college_phone=" + college_phone
				+ ", college_email=" + college_email + "]";
	}
	public College(String college_id,String college_name,String college_type,String college_city,String college_rank,String college_phone,String college_email){
		this.college_id=college_id;
		this.college_name=college_name;
		this.college_type=college_type;
		this.college_city=college_city;
		this.college_rank=college_rank;
		this.college_phone=college_phone;
		this.college_email=college_email;
	}
	public College(String college_name) {
		// TODO Auto-generated constructor stub
		this.college_name=college_name;
	}


	

}
