package com.zzz.entity;

public class Company {
	private Integer id;
	private String name;
	private String address;
	private String startTime;
	private String endTime;
	private int statc;
	private String createTime;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(Integer id, String name, String address, String startTime, String endTime,
			String createTime) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.startTime = startTime;
		this.endTime = endTime;
		this.statc = 0;
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getStatc() {
		return statc;
	}
	public void setStatc(int statc) {
		this.statc = statc;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "company [id=" + id + ", name=" + name + ", address=" + address + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", statc=" + statc + ", createTime=" + createTime + "]";
	}
	
}
