package com.dousnl.service;

import org.springframework.stereotype.Component;

/**
 * @author Fairyland
 * 断路器
 * SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中，代码如下：
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry："+name;
	}

}
