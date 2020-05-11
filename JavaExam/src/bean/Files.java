package bean;


public class Files {
	private int file_id;
	private String file_name;
	private String file_path;
	private College college;
	private java.sql.Timestamp time;
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	
	public java.sql.Timestamp getTime() {
		return time;
	}
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Files [file_id=" + file_id + ", file_name=" + file_name
				+ ", file_path=" + file_path + ", college=" + college
				+ ", time=" + time + "]";
	}
	
	


}
