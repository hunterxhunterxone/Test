package com.zzz.entity;

public class Employee {
	private Integer id;
	private String lastName;
	private String email;
	private String birth;
	private String createTime;
	private Dept dept;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer id, String lastName, String email, String birth, Dept dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.birth = birth;
		this.dept = dept;
	}

	public Employee(String lastName, String email, String birth, Dept dept) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.birth = birth;
		this.dept = dept;
	}

	public Employee(Integer id, String lastName, String email, String birth, String createTime, Dept dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.birth = birth;
		this.createTime = createTime;
		this.dept = dept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", birth=" + birth
				+ ", createTime=" + createTime + ", dept=" + dept + "]";
	}
	
}
