package com.dousnl.framework.security;

import org.apache.shiro.config.Ini.Section;
/**
 * shiro 过滤器链服务类
 * @author hanliang
 *
 */
public interface FilterChainDefinitionService {
	/** 加载框架权限资源配置 */  
    public Section loadFilterChains();
}
