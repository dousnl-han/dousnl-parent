package com.dousnl.shiro.config;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dousnl.redis.configone.RedisCacheManager;
import com.dousnl.redis.configone.RedisSessionAbstrDAO;
import com.dousnl.redis.configtwo.RedisSessionDAO;
import com.dousnl.shiro.realm.ShiroRealm;

/**
 * Shiro 配置类
 * @author hanliang
 *  
 */

@Configuration
public class ShiroConfiguration {
	
	@Resource
    private RedisSessionDAO sessionDAO;
  
	
	@Bean
    public RedisCacheManager redisCacheManager() {
        return new RedisCacheManager();
    }
	//配置核心session管理器
	@Bean(name="sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //redis-session管理，此处占时不用先注释掉
        //sessionManager.setSessionDAO(new RedisSessionAbstrDAO());
        //sessionManager.setGlobalSessionTimeout(1000 * 60 * 30);
        //sessionManager.setCacheManager(redisCacheManager());
        return sessionManager;
    }
	//配置核心安全事务管理器
	@Bean(name="securityManager")
	public SecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm,
			@Qualifier("sessionManager")SessionManager sessionManager){
		System.out.println("--------------securityManager已经加载--------------");
		DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
		manager.setRealm(shiroRealm);
		//设置缓存管理器，此处占时不用先注释掉
		//manager.setCacheManager(redisCacheManager());
		//manager.setSessionManager(sessionManager);
		return manager;
	}
	 /** 
     * 配置缓存 
     * @return 
     */  
    /*@Bean  
    public EhCacheManager getEhCacheManager() {  
        EhCacheManager em = new EhCacheManager();  
        em.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");  
        return em;  
    }  */
	//配置自定义的权限登录器
	@Bean(name="shiroRealm")
	public ShiroRealm shiroRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher){
		System.out.println("--------------shiroRealm已加载---------------");
		ShiroRealm shiroRealm=new ShiroRealm();
		shiroRealm.setCredentialsMatcher(matcher);
		return shiroRealm;
	}
	@Bean(name="shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager){
		System.out.println("--------------shirFilter已加载---------------");
		ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager
		bean.setSecurityManager(manager);
		//配置登陆url和成功url(如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面)
		bean.setLoginUrl("/login");
		//登录成功后要跳转的链接
		bean.setSuccessUrl("/home");
		//未授权界面;
        bean.setUnauthorizedUrl("/403");
		//配置拦截器
		LinkedHashMap<String, String> filterDefaultMap=new LinkedHashMap<>();
		filterDefaultMap.put("/login", "anon");//登录请求无需验证
		//静态资源
		filterDefaultMap.put("/resources/static/**", "anon");//静态资源无需验证
		filterDefaultMap.put("/resources/**", "anon");//静态资源无需验证
		/*filterDefaultMap.put("/html/**", "anon");
		filterDefaultMap.put("/images/**", "anon");
		filterDefaultMap.put("/js/**", "anon");*/
		
		filterDefaultMap.put("/jsp/login.jsp", "anon");//登录页面无需验证
		filterDefaultMap.put("/loginUser", "anon");//登录请求无需验证
		filterDefaultMap.put("/logout*", "anon");//注销请求无需验证
		filterDefaultMap.put("/jsp/error.jsp*", "anon");//错误无需验证
		filterDefaultMap.put("/swagger-ui.html/**", "anon");//swagger无需验证
		filterDefaultMap.put("/swagger/**", "anon");//swagger无需验证
		
		filterDefaultMap.put("/itext*", "anon");//导出pdf无需验证
		
		filterDefaultMap.put("/selTxqb", "anon");//测试请求无需验证
		filterDefaultMap.put("/fruitSwagger", "anon");//测试请求无需验证
		
		
		filterDefaultMap.put("/jsp/index.jsp*", "authc");//index页面需验证
		filterDefaultMap.put("/login/**", "authc");
		filterDefaultMap.put("/dobbo/**", "authc");//配置个别请求需要验证
		/*filterDefaultMap.put("/*.*", "authc");*/
		
		bean.setFilterChainDefinitionMap(filterDefaultMap);
		return bean;
	}
	//自定义密码比较器
	@Bean("credentialsMatcher")
	public CredentialsMatcher credentialsMatcher(){
		return new CredentialsMatcher();
	}
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager){
		AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(manager);
		return advisor;
	}
}
