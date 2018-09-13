package com.dousnl.framework.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * shiro 过滤器链服务类
 * @author hanliang
 *
 */
@Component(value="filterChainDefinitionService")
public class DefaultFilterChainDefinitionService implements FilterChainDefinitionService{
	/**
	 * 默认roles字符串
	 */
	public static final String ROLE_STRING = "roles[\"{0}\"]";

	public static final String PERMISSION_STRING = "perms[\"{0}\"]";
	
	private String filterChainDefinitions;
	
	@SuppressWarnings("unused")
	private String appendFilterChainDefinitions;

	public void setAppendFilterChainDefinitions(String appendFilterChainDefinitions) {
		this.appendFilterChainDefinitions = appendFilterChainDefinitions;
	}

	/**
	 * 通过filterChainDefinitions对默认的url过滤定义
	 * 
	 * @param filterChainDefinitions
	 *            默认的url过滤定义
	 */
	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}

	/**
	 * 加载权限资源
	 * @return
	 * @throws Exception
	 */
	public Section loadFilterChains() {
		Ini ini = new Ini();
		// 加载默认的url
		ini.load(filterChainDefinitions);
		// section就是filterChainDefinitionMap
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		
		// 装载其他类型的资源
		Map<String, String> filterChainMap = loadDynamicFilterChains();  
        if (!CollectionUtils.isEmpty(filterChainMap)) {  
            section.putAll(filterChainMap);  
        } 
		return section;
	}
	
    /** 加载动态权限资源配置 */ 
	public Map<String, String> loadDynamicFilterChains() {
		return new HashMap<String, String>();
	}
	
	/**
	 * 获取一个url资源的url列表
	 * 一般会产生两个url
	 * @param resString
	 * @return
	 */
	private List<String> getResStrings(String resString){
		List<String> resList=new ArrayList<String>();
		if(resString.endsWith("/")){
			String nonTrail = resString.replaceAll("/+", "/");
			nonTrail = nonTrail.substring(0, nonTrail.length()-1);
			if(StringUtils.isEmpty(nonTrail)){
				return resList;
			}
			resList.add("/"+nonTrail);
		}else{
			resList.add("/"+resString+"/");
		}
		
		resList.add("/"+resString);
		return resList;
	}
}
