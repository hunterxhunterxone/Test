
package com.zzz.config.shiro;




import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zzz.entity.Permissions;
import com.zzz.entity.Role;
import com.zzz.entity.User;
import com.zzz.service.PermissionService;
import com.zzz.service.RoleService;
import com.zzz.service.UserService;
import com.zzz.util.MD5;
@Component
public class MyShiroRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("权限认证方法");
		User token = (User) SecurityUtils.getSubject().getPrincipal();
		List<Role> roles = roleService.selectByUserEmail(token.getEmail());
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> permissionSet = new HashSet<String>();
		Set<String> rolename = new HashSet<String>();
		Set<Permissions> setPermission = new HashSet<Permissions>();
		for(Role role:roles){
			setPermission = permissionService.selectByRId(role.getId());
			for(Permissions per:setPermission) {
				permissionSet.add(per.getPermission());
			}
			rolename.add(role.getDescription());
		}
		authorizationInfo.addStringPermissions(permissionSet);
		authorizationInfo.addRoles(rolename);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("使用了自定义的realm,用户认证");
		System.out.println("用户名:"+((UsernamePasswordToken)token).getUsername());
		System.out.println("密码:"+new String(((UsernamePasswordToken)token).getPassword()));
		System.out.println("记住我:"+((UsernamePasswordToken)token).isRememberMe());
		//获取用户名
		UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
//		String userName = (String)token.getPrincipal();
		logger.info("用户登录验证：验证当前Subject获取到的token为"+usertoken.toString());
		String userName = usertoken.getUsername();
		System.out.println(userName);
		User user = new User();
		user.setEmail(userName);
		user = userService.selectUserByKey(user);
//		System.out.println(user);
//		System.out.println(usertoken.getPassword());
//		System.out.println(new SimpleHash("MD5",usertoken.getPassword(),user.getSalt(),1024).toHex());
//		System.out.println(new SimpleHash("MD5","123456",user.getSalt(),1024).toHex());
		System.out.println(user.getPassword());
		logger.debug("用户登录验证！用户信息:"+user);
		if(user==null) {
			throw new UnknownAccountException("账号不存在");//没找到账号
		}
		if(user.getStatc()==1) {
			throw new LockedAccountException("此账号已锁定");//账号锁定
		}
		user.setLastTime(new Date());
		userService.updateByPrimaryKeySelective(user);
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getEmail(),user.getPassword(),ByteSource.Util.bytes(user.getSalt()),getName());
		return authenticationInfo;
	}
	

}
