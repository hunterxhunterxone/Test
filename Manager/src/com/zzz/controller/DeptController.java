package com.zzz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zzz.entity.Dept;
import com.zzz.service.DeptService;
@RequestMapping("/dept")
@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;
	@RequestMapping("/queryAll")
	public void queryAll(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		List<Dept> list = deptService.queryAll();
		resp.setContentType("text/json;charset=utf-8");
		String jsonString = JSON.toJSONString(list);
		resp.getWriter().print(jsonString);
	} 
}
