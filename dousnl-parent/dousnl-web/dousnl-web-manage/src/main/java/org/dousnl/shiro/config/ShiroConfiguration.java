package org.dousnl.shiro.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.dousnl.shiro.realm.ShiroRealm;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro 配置类
 * @author hanliang
 *  
 */

@Configuration
public class ShiroConfiguration {
  
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
		filterDefaultMap.put("/login", "anon");
		//静态资源
		filterDefaultMap.put("/resources/static/**", "anon");
		/*filterDefaultMap.put("c/static/html/**", "anon");
		filterDefaultMap.put("/resources/static/images/**", "anon");
		filterDefaultMap.put("/resources/static/js/**", "anon");
		filterDefaultMap.put("/resources/static/css/**", "anon");
		filterDefaultMap.put("/resources/static/indexfiles/**", "anon");*/
		
		filterDefaultMap.put("/jsp/login.jsp", "anon");
		filterDefaultMap.put("/loginUser", "anon");
		filterDefaultMap.put("/logout*", "anon");
		filterDefaultMap.put("/jsp/error.jsp*", "anon");
		filterDefaultMap.put("/jsp/index.jsp*", "authc");
		filterDefaultMap.put("/*", "authc");
		filterDefaultMap.put("/**", "authc");
		/*filterDefaultMap.put("/*.*", "authc");*/
		
		bean.setFilterChainDefinitionMap(filterDefaultMap);
		return bean;
	}
	
	//配置核心安全事务管理器
	@Bean(name="securityManager")
	public SecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm){
		System.out.println("--------------securityManager已经加载--------------");
		DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
		manager.setRealm(shiroRealm);
		return manager;
	}
	//配置自定义的权限登录器
	@Bean(name="shiroRealm")
	public ShiroRealm shiroRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher){
		System.out.println("--------------shiroRealm已加载---------------");
		ShiroRealm shiroRealm=new ShiroRealm();
		shiroRealm.setCredentialsMatcher(matcher);
		return shiroRealm;
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
