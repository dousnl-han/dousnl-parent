package org.dousnl.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ProviderService bean = (ProviderService)applicationContext.getBean("providerService");
		bean.subService("张三");
		//System.out.println("bean:"+bean.subService("张三"));
	}
}
