package com.zzz.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzz.entity.User;
import com.zzz.service.UserService;
import com.zzz.service.impl.UserServiceImpl;
@Controller
@EnableAutoConfiguration
@RequestMapping
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String index(ModelMap map) {
		System.out.println("login进来了");
		return "../login";
	}
	/**
	 * 登录判断
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/ajaxLogin",method=RequestMethod.POST)
	@ResponseBody
	public String login(String username,String password,Boolean rememberMe,HttpServletRequest request,Map<String,Object> map) {
		logger.info("LoginController.login()");
		System.out.println("loginController进来了");
//		  UsernamePasswordToken token = new UsernamePasswordToken();
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
//		String msg = "";
		String status = "";
		Session session = SecurityUtils.getSubject().getSession();
		try {
			currentUser.login(token);
//			map.put("status",200);
//			map.put("msg","登录成功");
			status = "200";
		}catch(UnknownAccountException e) {
			System.out.println("账号不存在");
//			 msg = "UnknownAccountException -- > 账号不存在：";
//			 map.put("status",500);
//			 map.put("msg",msg);
			status = "500";
		}catch(IncorrectCredentialsException e) {
			System.out.println("密码错误");
//			msg="IncorrectCredentialsException -- > 密码不正确：";
//			return "/login";
//			map.put("status",500);
//			map.put("msg",msg);
			status = "500";
		}catch(LockedAccountException e) {
			System.out.println("此账号已锁定");
//			msg="LockedAccountException -- > 此账号已锁定";
//			return "/login";
//			map.put("status",500);
//			map.put("msg",msg);
			status = "500";
		}
		
		return status;
	}

}
