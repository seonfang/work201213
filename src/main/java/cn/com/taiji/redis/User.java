package cn.com.taiji.redis;

public class User {

	private String no;
	private String name;
	private String sex;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User(String no, String name, String sex) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
	}
	
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
