package com.zzz.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzz.entity.Resumes;
import com.zzz.entity.User;
import com.zzz.entity.UserRole;
import com.zzz.service.ResumesService;
import com.zzz.service.UserRoleService;
import com.zzz.service.UserService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/tourister")
public class TouristController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private ResumesService resumesService;
	
	@RequestMapping("/doRegister")
	public String doRegister(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("register进来了");
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String username = request.getParameter("name");
//		String type = request.getParameter("role");
		System.out.println(email);
		System.out.println(password);
		System.out.println(password2);
		System.out.println(username);
		User user = new User();
		user.setEmail(email);
		user.setName(username);
		user.setSalt(UUID.randomUUID().toString());
		user.setPassword(new SimpleHash("MD5",password,user.getSalt(),1024).toHex());
		user.setStatc(0);
		User user1 = new User();
		user1.setEmail(email);
		if(password.equals(password2)) {
			int result = userService.insertTourist(user);
			System.out.println(result);
			if(result!=0) {
			user1 = userService.selectUserByKey(user1);
//			if(type==null) {
//				type="1";
//			}
			UserRole userRole = new UserRole(user1.getId(),Integer.valueOf(1));
			userRoleService.insert(userRole);
			}else {
				System.out.println("注册失败");
				return "../register";
			}
		}
		return "/tourist/index";
	}
	@RequestMapping("/doResumes")
	public String resumesAdd(HttpServletRequest request,HttpServletResponse response) {
//		User token = (User) SecurityUtils.getSubject().getPrincipal();
//		System.out.println(token.getEmail());
		System.out.println("简历进来了");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex1 = request.getParameter("sex");
		String usernumber = request.getParameter("usernumber");
		String selfInfo = request.getParameter("userinfo");
		String phone = request.getParameter("phone");
		String studentInfo = request.getParameter("studentInfo");
		String major = request.getParameter("major");
		String school = request.getParameter("school");
		String languageUse = request.getParameter("languageUse");
		String experience = request.getParameter("experience");
		String speciality = request.getParameter("speciality");
		System.out.println(name);
		System.out.println(age);
		System.out.println(usernumber);
		System.out.println(selfInfo);
		System.out.println(studentInfo);
		Integer sex=0;
		if(sex1.equals("女")) {
			sex=1;
		}
		Resumes resumes = new Resumes(name, Integer.valueOf(age), sex, usernumber, selfInfo, phone, studentInfo, major, school, languageUse, experience, speciality);
		
		return "/index";
	}
}
