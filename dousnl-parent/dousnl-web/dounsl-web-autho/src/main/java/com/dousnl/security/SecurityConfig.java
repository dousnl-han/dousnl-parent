package com.dousnl.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SpringSecurity配置类
 * @author hanliang  
 * @date 2019年7月23日下午4:39:05
 * @version 1.0	
 */

@Configuration
@EnableWebSecurity // 启用web安全功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 访问"/","/home"路径的请求都允许
				.antMatchers("/", "/home", "/staff", "/staff/*").permitAll()
				// 而其他的请求都需要认证
				.anyRequest().authenticated().and()
				// 修改spring security默认登录页面
				.formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//基于内存来存储用户
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
				.withUser("dousnl").password(new BCryptPasswordEncoder().encode("123")).roles("USER").and()
				.withUser("admin").password(new BCryptPasswordEncoder().encode("456")).roles("USER", "ADMIN");
	}
}
