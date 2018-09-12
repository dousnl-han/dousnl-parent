package org.dousnl.shiro.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.dousnl.shiro.realm.AuthShiroRealm;
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
		ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
		bean.setSecurityManager(manager);
		//配置登陆url和成功url
		bean.setLoginUrl("/login");
		bean.setSuccessUrl("/home");
		//配置方位权限
		LinkedHashMap<String, String> filterDefaultMap=new LinkedHashMap<>();
		filterDefaultMap.put("/jsp/login.jsp", "anon");
		filterDefaultMap.put("/loginUser", "anon");
		filterDefaultMap.put("/logout*", "anon");
		filterDefaultMap.put("/jsp/error.jsp*", "anon");
		filterDefaultMap.put("/jsp/index.jsp*", "authc");
		filterDefaultMap.put("/*", "authc");
		filterDefaultMap.put("/**", "authc");
		filterDefaultMap.put("/*.*", "authc");
		bean.setFilterChainDefinitionMap(filterDefaultMap);
		return bean;
	}
	
	//配置核心安全事务管理器
	@Bean(name="securityManager")
	public SecurityManager securityManager(@Qualifier("authShiroRealm") AuthShiroRealm shiroRealm){
		System.out.println("--------------shiro已经加载--------------");
		DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
		manager.setRealm(shiroRealm);
		return manager;
	}
	//配置自定义的权限登录器
	@Bean(name="authShiroRealm")
	public AuthShiroRealm shiroRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher){
		AuthShiroRealm shiroRealm=new AuthShiroRealm();
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
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("srcuirtyManager") SecurityManager manager){
		AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(manager);
		return advisor;
	}
}
