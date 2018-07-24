package com.zzz.entity;

public class UserInfo {
	private Integer id;
	private Integer cid;
	private int age;
	private int sex;
	private String phone;
	private String userNumber;
	private String address;
	private String addTime;//入职时间
	private String endTime;//离职时间
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(Integer id, Integer cid, int age, int sex, String phone, String userNumber, String address) {
		super();
		this.id = id;
		this.cid = cid;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.userNumber = userNumber;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", cid=" + cid + ", age=" + age + ", sex=" + sex + ", phone=" + phone
				+ ", userNumber=" + userNumber + ", address=" + address + ", addTime=" + addTime + ", endTime="
				+ endTime + "]";
	}
	
}
