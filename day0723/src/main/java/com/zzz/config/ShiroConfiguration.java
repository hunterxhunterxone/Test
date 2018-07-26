
package com.zzz.config;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

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
		//设置realm
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(authRealm);
		securityManager.setCacheManager(enCacheManager());
		return securityManager;
	}
	/**
	 * 登录密码校验，权限
	 * @return
	 */
	@Bean(name="authRealm")
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}
	
	/**
	 * 过滤器
	 * @param securityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager")SecurityManager securityManager) {
	
		System.out.println("地址:ShiroConfiguration.shiroFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
		LogoutFilter logoutFilter = new LogoutFilter();
		logoutFilter.setRedirectUrl("/login");
		Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
		filterChainDefinitionManager.put("/logout", "logout");
//		filterChainDefinitionManager.put("/dologin", "anon");
		filterChainDefinitionManager.put("/login","anon");
		filterChainDefinitionManager.put("/register.html","anon");
//		filterChainDefinitionManager.put("/user/admin/*", "roles[admin]");// 用户为ROLE_USER
//		filterChainDefinitionManager.put("/user/*", "");
		filterChainDefinitionManager.put("/tourister/*", "anon");
		filterChainDefinitionManager.put("/page/*", "anon");
		
		filterChainDefinitionManager.put("/static/*","anon");
		filterChainDefinitionManager.put("/*", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);

			shiroFilterFactoryBean.setSuccessUrl("/index");
			shiroFilterFactoryBean.setUnauthorizedUrl("/403");
			logger.debug("Shiro拦截器工厂类注入成功");
			return shiroFilterFactoryBean;
	}
	/**

     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了

     * 所以我们需要修改下doGetAuthenticationInfo中的代码; @return

     */

    @Bean(name="hashedCredentialsMatcher")

    public HashedCredentialsMatcher hashedCredentialsMatcher() {

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;

//        hashedCredentialsMatcher.setHashIterations(2);// 散列的次数，比如散列两次，相当于md5(md5(""));

        hashedCredentialsMatcher.setHashIterations(1024);// 散列的次数，比如散列两次，相当于md5(md5(""));

        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);//表示是否存储散列后的密码为16进制，需要和生成密码时的一样，默认是base64；

        return hashedCredentialsMatcher;

    }
    /**
     * ehcache缓存管理器
     * @return
     */
    @Bean
    public EhCacheManager enCacheManager(){
    	logger.debug("-----shiro整合ehcache缓存");
    	EhCacheManager ehcache = new EhCacheManager();
    	CacheManager cacheManager = CacheManager.getCacheManager("es");
    	if(cacheManager==null) {
    		try {
    			cacheManager = CacheManager.create(ResourceUtils.getInputStreamForPath("classpath:ehcache.xml"));
    		}catch(CacheException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	ehcache.setCacheManager(cacheManager);
    	return ehcache;
    } 
}
