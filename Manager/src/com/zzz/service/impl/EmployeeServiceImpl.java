package com.zzz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.dao.EmployeeDao;
import com.zzz.entity.Employee;
import com.zzz.service.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public List<Employee> queryAll() {
		// TODO Auto-generated method stub
		return employeeDao.queryAll();
	}
	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.insertEmployee(employee);
	}
	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
	}
	@Override
	public void deleteEMployee(Integer id) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(id);
	}
	@Override
	public Employee findEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}
	@Override
	public List<Employee> findEmployeeByDeptId(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.findByDeptId(id);
	}

}
