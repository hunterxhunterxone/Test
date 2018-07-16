package com.zzz.service;

import java.util.List;

import com.zzz.entity.Dept;

public interface DeptService {
	public List<Dept> queryAll();
	public Dept queryByName(String deptName);
}
