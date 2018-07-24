package com.zzz.config;


import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.zzz.entity.User;
import com.zzz.service.UserService;

public class MyShiroRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String email =(String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("使用了自定义的realm,用户认证");
		System.out.println("用户名:"+((UsernamePasswordToken)token).getUsername());
		System.out.println("密码:"+new String(((UsernamePasswordToken)token).getPassword()));
		//获取用户名
		String userName = (String)token.getPrincipal();
		User user = new User();
		user.setEmail(userName);
		user = userService.selectUserByKey(user);
		if(user==null) {
			throw new UnknownAccountException();//没找到账号
		}
		if(user.getStatc()==1) {
			throw new LockedAccountException();//账号锁定
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
		return authenticationInfo;
	}
	

}
