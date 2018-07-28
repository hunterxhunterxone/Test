package com.zzz.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzz.entity.User;
import com.zzz.service.UserService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UseController {
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/findUser")
	public String findUser(ModelMap map) {
		List<User> list = userService.findUserList();
		map.put("list",list);
		for(User user:list) {
			System.out.println(user);
		}
		return "user/userList";
	}
}
