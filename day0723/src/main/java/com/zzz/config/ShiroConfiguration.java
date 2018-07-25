
package com.zzz.config;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zzz.Application;
import com.zzz.config.shiro.MyShiroRealm;

@SpringBootConfiguration
@Configuration
public class ShiroConfiguration {
	private static Logger logger = Logger.getLogger(Application.class);
	@Bean(name="securityManager")
	public SecurityManager securityManager(@Qualifier("authRealm")MyShiroRealm authRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(authRealm);
		return securityManager;
	} 
	@Bean(name="authRealm")
	public MyShiroRealm myShiroRealm() {
		return new MyShiroRealm();
	}
	@Bean
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager")SecurityManager securityManager) {
	
		System.out.println("地址:ShiroConfiguration.shiroFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		LogoutFilter logoutFilter = new LogoutFilter();
		logoutFilter.setRedirectUrl("/login");
		Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
		filterChainDefinitionManager.put("/logout", "logout");
		filterChainDefinitionManager.put("/login*", "anon");// 用户为ROLE_USER
		filterChainDefinitionManager.put("/logto*", "anon");
		filterChainDefinitionManager.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);

			shiroFilterFactoryBean.setSuccessUrl("/index");
			shiroFilterFactoryBean.setUnauthorizedUrl("/403");
			return shiroFilterFactoryBean;
	}
	
}
