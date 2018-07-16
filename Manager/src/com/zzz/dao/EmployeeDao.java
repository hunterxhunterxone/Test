package com.zzz.dao;

import java.util.List;

import com.zzz.entity.Employee;

public interface EmployeeDao {
	public List<Employee> queryAll();
	public void insertEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer id);
	public Employee findById(Integer id);
	public List<Employee> findByDeptId(Integer id);
}
