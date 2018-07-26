package com.zzz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzz.entity.User;
import com.zzz.entity.UserRole;
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
		user.setSalt();
		user.setPassword(password);
		user.setStatc();
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

}
