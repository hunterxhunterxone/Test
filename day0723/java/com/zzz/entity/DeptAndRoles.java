package com.zzz.entity;

public class DeptAndRoles {
	private Integer did;
	private Integer rid;
	public DeptAndRoles(Integer did, Integer rid) {
		super();
		this.did = did;
		this.rid = rid;
	}
	public DeptAndRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "DeptAndRoles [did=" + did + ", rid=" + rid + "]";
	}
	
}
