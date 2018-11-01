package ca.mcgill.ecse321.eventregistration.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String name;
	private String phone;
	private String pwd;
	private String age;
	private String sex;
	private double score;
	private int total_no;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getTotal_no() {
		return total_no;
	}
	public void setTotal_no(int total_no) {
		this.total_no = total_no;
	}
	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", phone=" + phone + ", pwd=" + pwd + ", age=" + age + ", sex="
				+ sex + ", score=" + score + ", total_no=" + total_no + "]";
	}
	
}
