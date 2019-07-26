package com.dousnl.autho.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * 启动注解方法安全性
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/23 17:40
 */

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    /**
     *securedEnabled = true 此时Spring将会创建一个切点，并将带有@Secured注解的方法防入切面中。
     * jsr250Enabled = true 与 prePostEnabled=true 分别表示启用@RoleAllowed与表达式驱动的注解
     */
}
