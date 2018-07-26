package com.zzz.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Map<String,Object> map) {
		logger.info("LoginController.login()");
//		  Subject currentUser = SecurityUtils.getSubject();
//		  UsernamePasswordToken token = new UsernamePasswordToken();
		  String exception = (String) request.getAttribute("shiroLoginFailure");
		logger.info("Exception:"+exception);
		String msg = "";
//		  try {
//			  currentUser.login(token);
//			  if(currentUser.isAuthenticated()==true) {
//				  return "/index";
//			  }
//		  }catch(UnknownAccountException e) {
//			  System.out.println("账号不存在");
//				 msg = "UnknownAccountException -- > 账号不存在：";
//				 return "../login";
//		  }catch(LockedAccountException e) {
//			  System.out.println("此账号已锁定");
//			  msg="LockedAccountException-->此账号已锁定";
//			  return "../login";
//		  }catch(IncorrectCredentialsException e) {
//			  System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//				msg="IncorrectCredentialsException -- > 密码不正确：";
//				 return "../login";
//		  }
		
		// 创建Subject实例
       
		if(exception!=null) {
			if(UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("账号不存在");
				 msg = "UnknownAccountException -- > 账号不存在：";
			}else if(IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg="IncorrectCredentialsException -- > 密码不正确：";
			}else if("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg="kaptchaValidateFailed-->验证码错误";
			}else {
				msg="else>>"+exception;
				System.out.println("else -->"+exception);
			}
	}
		map.put("msg",msg);
		return "/tourist/index";
	}
	
}
