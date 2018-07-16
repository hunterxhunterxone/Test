package com.zzz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.dao.DeptDao;
import com.zzz.entity.Dept;
import com.zzz.service.DeptService;
@Service("/deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> queryAll() {
		// TODO Auto-generated method stub
		return deptDao.queryAll();
	}
	@Override
	public Dept queryByName(String deptName) {
		// TODO Auto-generated method stub
		return deptDao.queryByName(deptName);
	}

}
