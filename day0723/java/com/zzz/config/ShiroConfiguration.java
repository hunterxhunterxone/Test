
package com.zzz.config;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
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
		System.out.println("------------shiro已经加载了------------");
		//设置realm
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(authRealm);
//		securityManager.setCacheManager(shiroCacheManager);
//		securityManager.setSessionManager(sessionManager);
		
		securityManager.setRememberMeManager(rememberMeManager());
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

		filterChainDefinitionManager.put("/dologin", "anon");
//		filterChainDefinitionManager.put("/login","anon");
		filterChainDefinitionManager.put("/register.html","anon");
		filterChainDefinitionManager.put("/ajaxLogin","anon");
//		filterChainDefinitionManager.put("/user/admin/*", "roles[admin]");// 用户为ROLE_USER
//		filterChainDefinitionManager.put("/user/*", "");
		filterChainDefinitionManager.put("/tourister/*", "anon");
		filterChainDefinitionManager.put("/page/*", "anon");
		
		filterChainDefinitionManager.put("/static/*","anon");
		filterChainDefinitionManager.put("/*", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
		filterChainDefinitionManager.put("/ajaxLogin", "anon");
			shiroFilterFactoryBean.setSuccessUrl("/index");
			shiroFilterFactoryBean.setUnauthorizedUrl("/403");
			logger.debug("Shiro拦截器工厂类注入成功");
			return shiroFilterFactoryBean;
	}
	/**
	 * 设置记住我cookie过期时间
	 * @return
	 */
	@Bean
	public SimpleCookie remeberMeCookie(){
		logger.debug("记住我，设置cookie过期时间！");
		//cookie名称;对应前端的checkbox的name = rememberMe
		SimpleCookie scookie=new SimpleCookie("rememberMe");
		//记住我cookie生效时间30天 ,单位秒  [10天]
		scookie.setMaxAge(864000);
		return scookie;
	}

	/**
	 * 配置cookie记住我管理器
	 * @return
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager(){
		logger.debug("配置cookie记住我管理器！");
		CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(remeberMeCookie());
		return cookieRememberMeManager;
	}
	/**

     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了

     * 所以我们需要修改下doGetAuthenticationInfo中的代码; @return

     */

    @Bean(name="hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("MD5");// 散列算法:这里使用MD5算法;

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
	public EhCacheManager ehCacheManager() {
		logger.debug(
				"=====shiro整合ehcache缓存：ShiroConfiguration.getEhCacheManager()");
		EhCacheManager ehcache = new EhCacheManager();
		CacheManager cacheManager = CacheManager.getCacheManager("shiro");
		  if(cacheManager == null){
		  try {
				  cacheManager = CacheManager.create(ResourceUtils.getInputStreamForPath("classpath:ehcache.xml"));
			  } catch (CacheException e) {
					e.printStackTrace();
			  } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  ehcache.setCacheManager(cacheManager);
		return ehcache;
	}
//    @Bean
//    public EnterpriseCacheSessionDAO enterCacheSessionDAO() {
//    	EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
//    	//添加缓存管理器
//    	//添加ehcache活跃缓存名称(必须和ehcache缓存名称一致)
//    	enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
//    	return enterCacheSessionDAO();
//    }

    /**
     * sessionManager添加session缓存操作DAO
     * @return
     */
//    @Bean 
//    public DefaultWebSessionManager sessionManager() {
//    	DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//    	sessionManager.setSessionDAO(enterCacheSessionDAO());
//    	sessionManager.setSessionIdCookie(sessionIdCookie());
//    	return sessionManager;
//    }
    /**
     * 配置shiro session的一个管理器
     * @param sessionDAO
     * @param simpleCookie
     * @return
     */
//    @Bean(name="sessionManager")
//    public DefaultWebSessionManager getDefaultWebSessionManager(@Qualifier("sessionDao") MemorySessionDAO sessionDAO,
//    															@Qualifier("sessionIdCookie")SimpleCookie simpleCookie) {
//    	DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//    	sessionManager.setSessionDAO(sessionDAO);
//    	sessionManager.setSessionIdCookie(simpleCookie);
//    	return sessionManager;
//    }
    /**
     * 自定义cookie中session名称等配置
     * @return
     */
    @Bean(name="sessionIdCookie")
    public SimpleCookie sessionIdCookie() {
    	SimpleCookie simpleCookie = new SimpleCookie();
    	//如果在cookie中设置了httponly属性，通过程序将无法读取到cookie信息
    	simpleCookie.setHttpOnly(true);
    	simpleCookie.setName("SHRIOSESSIONID");
    	//单位秒
    	simpleCookie.setMaxAge(86400);
    	return simpleCookie;
    }
    /**
     * 限制同一账号登录同时登录人数控制
     * @return
     */
//    public KickoutSessionControlFilter kickoutSessionControlFilter(){
//    	KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
//    	//使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
//    	//这里我们还是用之前shiro使用的redisManager()实现的cacheManager()缓存管理
//    	//也可以重新另写一个，重新配置缓存时间之类的自定义缓存属性
//    	kickoutSessionControlFilter.setCacheManager(cacheManager());
//    	//用于根据会话ID，获取会话进行踢出操作的；
//    	kickoutSessionControlFilter.setSessionManager(sessionManager());
//    	//是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；踢出顺序。
//    	kickoutSessionControlFilter.setKickoutAfter(false);
//    	//同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
//    	kickoutSessionControlFilter.setMaxSession(1);
//    	//被踢出后重定向到的地址；
//    	kickoutSessionControlFilter.setKickoutUrl("/kickout");
//        return kickoutSessionControlFilter;
//     }

}
