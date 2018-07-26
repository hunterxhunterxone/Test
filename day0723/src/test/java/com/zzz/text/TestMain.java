package com.zzz.text;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzz.entity.User;
import com.zzz.service.UserService;
@Controller
public class TestMain {
	@Autowired
	private UserService userService;
	@Test
	public void testSelect() {
		System.out.println(userService);
		List<User> users = userService.findUserList();
		for(User user:users) {
			System.out.println(user);
		}
	}

}
