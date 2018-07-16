package com.zzz.dao;

import java.util.List;

import com.zzz.entity.Dept;

public interface DeptDao {
	public List<Dept> queryAll();
	public Dept queryByName(String deptName);
}
