package com.zzz.service;

import java.util.List;

import com.zzz.entity.Employee;

public interface EmployeeService {
	public List<Employee> queryAll();
	public void insertEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEMployee(Integer id);
	public Employee findEmployee(Integer id);
	public List<Employee> findEmployeeByDeptId(Integer id);
}
