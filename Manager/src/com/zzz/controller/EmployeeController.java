package com.zzz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zzz.entity.Dept;
import com.zzz.entity.Employee;
import com.zzz.service.DeptService;
import com.zzz.service.EmployeeService;
@RequestMapping("/employee")
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DeptService deptService;
	@RequestMapping("/queryAll")
	public String queryAll(HttpSession session) {
		List<Employee> employees = employeeService.queryAll();
		session.setAttribute("list", employees);
		return "show";
	}
	@RequestMapping("/insertEmployee")
	public String insertEmployee(HttpServletRequest req,HttpServletResponse resp) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String birth = req.getParameter("birth");
		String deptName = req.getParameter("dept");
		Dept dept = deptService.queryByName(deptName);
		Employee employee = new Employee(name, email, birth,dept);
		employeeService.insertEmployee(employee);
		return "forward:employee/queryAll";
	}
	@RequestMapping("/updateEmployee")
	public String updateEmployee(HttpServletRequest req,HttpServletResponse resp) 
	{
		Integer id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String birth = req.getParameter("birth");
		String deptName = req.getParameter("dept");
		Dept dept = deptService.queryByName(deptName);
		Employee employee = new Employee(id,name, email, birth,dept);
		employeeService.updateEmployee(employee);
		return "forward:employee/queryAll";
	}
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(Integer id,HttpServletRequest req,HttpServletResponse resp) {
		employeeService.deleteEMployee(id);
		return "forward:employee/queryAll";
	}
	@RequestMapping("/findEmployee")
	public String findEmployee(HttpSession session,Integer id) {
		Employee employee = employeeService.findEmployee(id);
		session.setAttribute("employee", employee);
		return "add";
	}
	@RequestMapping("/findemployeeName")
	public void findemployeeName(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String name = req.getParameter("selectVar");
		System.out.println(name);
		Dept dept = deptService.queryByName(name);
		List<Employee> list = employeeService.findEmployeeByDeptId(dept.getDId());
		System.out.println(list);
		resp.setContentType("text/json;charset=utf-8");
		String jsonString = JSON.toJSONString(list);
		resp.getWriter().print(jsonString);
	}
}