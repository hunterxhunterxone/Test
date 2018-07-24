package com.zzz.config;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		System.out.println("ShiroConfiguration.shiroFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		//配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/static/css/**","anon");
		filterChainDefinitionMap.put("/static/js/**","anon");
		filterChainDefinitionMap.put("/jsp/**/**","anon");
		filterChainDefinitionMap.put("/static/img/**","anon");
		
		//配置退出过滤器,其中具体的退出代码shiro已经实现
		filterChainDefinitionMap.put("/logout","logout");
		
		//过滤链定义,从上向下执行
		 //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**","authc");
		//如果不设置默认会自动寻找web工程根目录下的"/login.html"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		//登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		
		//未授权界面
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilterFactoryBean;
	}
	@Bean
	public MyShiroRealm myShiroRealm() {
		
	}
}
