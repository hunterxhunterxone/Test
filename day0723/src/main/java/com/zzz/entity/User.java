package com.zzz.entity;

public class User {
	private Integer Id;
	private String name;
	private int age;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, int age) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", age=" + age + "]";
	}
	
}
