package com.zzz.entity;

import java.util.List;

public class Permission {
	private Integer id;
	private String available;
	private String name;
	private Integer parentid;
	private String parentids;
	private String url;
	public Permission(Integer id, String available, String name, Integer parentid, String parentids, String url) {
		super();
		this.id = id;
		this.available = available;
		this.name = name;
		this.parentid = parentid;
		this.parentids = parentids;
		this.url = url;
	}
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getParentids() {
		return parentids;
	}
	public void setParentids(String parentids) {
		this.parentids = parentids;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", available=" + available + ", name=" + name + ", parentid=" + parentid
				+ ", parentids=" + parentids + ", url=" + url + "]";
	}
	
	
}
