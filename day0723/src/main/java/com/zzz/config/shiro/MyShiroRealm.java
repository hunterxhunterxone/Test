
package com.zzz.config.shiro;



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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zzz.entity.User;
import com.zzz.entity.UserRole;
import com.zzz.service.RoleService;
import com.zzz.service.UserRoleService;
import com.zzz.service.UserService;
@Component
public class MyShiroRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleService RoleService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String email =(String) principals.getPrimaryPrincipal();
		System.out.println("email"+email);
		User user = new User();
		user.setEmail(email);
		user = userService.selectUserByKey(user);
		if(user==null) {
			throw new UnknownAccountException("该用户不存在");
		}
		UserRole userrole = new UserRole();
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
		System.out.println(userName);
		User user = new User();
		user.setEmail(userName);
		user = userService.selectUserByKey(user);
		System.out.println(user);
		if(user==null) {
			throw new UnknownAccountException("账号不存在");//没找到账号
		}
		if(user.getStatc()==1) {
			throw new LockedAccountException("此账号已锁定");//账号锁定
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(user.getCredentialsSalt()),getName());
		return authenticationInfo;
	}
	

}
