package com.zzz.entity;

public class Dept {
	private Integer DId;
	private String deptName;
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(Integer dId, String deptName) {
		super();
		DId = dId;
		this.deptName = deptName;
	}
	public Integer getDId() {
		return DId;
	}
	public void setDId(Integer dId) {
		DId = dId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Dept [DId=" + DId + ", deptName=" + deptName + "]";
	}
	
}
