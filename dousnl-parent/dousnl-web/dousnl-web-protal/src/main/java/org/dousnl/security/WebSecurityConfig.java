/*package org.dousnl.security;

import org.dousnl.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*//**
 * @author hanliang
 * spring-security配置
 *//*
//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 //inMemoryAuthentication 从内存中获取  
        auth.inMemoryAuthentication().withUser("catest").password("catest").roles("USER"); 
		//auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		    .anyRequest().authenticated()
		    .and().formLogin().loginPage("/login")
		    .failureUrl("/login?error").permitAll().and()
		    .logout().permitAll();
	}
	*//**
	 * spring-security配置静态资源放行
	 *//*
	@Override
	public void configure(WebSecurity websecurity) throws Exception {
		websecurity.ignoring().antMatchers("/resources/static/**");
	}
}
*/