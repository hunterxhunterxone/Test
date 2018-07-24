package com.zzz.entity;

public class Role {
	private Integer id;
	private String available;
	private String name;
	private String description;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Integer id, String available, String name, String description) {
		super();
		this.id = id;
		this.available = available;
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", available=" + available + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
