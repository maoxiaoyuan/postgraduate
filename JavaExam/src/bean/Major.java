package bean;

import dao.DBConnectionUtil;

public class Major {
	private String college_name;
	private String major_name;
	private String major_rank;
	private String institution;
	private String persons;
	private String form;
	
	private static DBConnectionUtil db;
	
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getMajor_rank() {
		return major_rank;
	}
	public void setMajor_rank(String major_rank) {
		this.major_rank = major_rank;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getPersons() {
		return persons;
	}
	public void setPersons(String persons) {
		this.persons = persons;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	@Override
	public String toString() {
		return "major [college_name=" + college_name + ", major_name="
				+ major_name + ", major_rank=" + major_rank + ", institution="
				+ institution + ", persons=" + persons + ", form=" + form + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((college_name == null) ? 0 : college_name.hashCode());
		result = prime * result
				+ ((major_name == null) ? 0 : major_name.hashCode());
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
		Major other = (Major) obj;
		if (college_name == null) {
			if (other.college_name != null)
				return false;
		} else if (!college_name.equals(other.college_name))
			return false;
		if (major_name == null) {
			if (other.major_name != null)
				return false;
		} else if (!major_name.equals(other.major_name))
			return false;
		return true;
	}
	public Major(){
		db=new DBConnectionUtil();
	}
	public Major(String college_name,String major_name){

		this.college_name=college_name;
		this.major_name=major_name;
	}
	public Major(String major_name,String major_rank,
			String institution,String persons,String form){
		this.major_name=major_name;
		this.major_rank=major_rank;
		this.institution=institution;
		this. persons= persons;
		this.form=form;
	}
	public Major(String college_name,String major_name,String major_rank,
			String institution,String persons,String form){
		this.college_name=college_name;
		this.major_name=major_name;
		this.major_rank=major_rank;
		this.institution=institution;
		this. persons= persons;
		this.form=form;
	}
	

}
