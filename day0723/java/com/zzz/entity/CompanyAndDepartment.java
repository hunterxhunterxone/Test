package com.zzz.entity;

public class CompanyAndDepartment {
	private Integer cid;
	private Integer did;
	public CompanyAndDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyAndDepartment(Integer cid, Integer did) {
		super();
		this.cid = cid;
		this.did = did;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	@Override
	public String toString() {
		return "CompanyAndDepartment [cid=" + cid + ", did=" + did + "]";
	}
	
}
