package com.dousnl.web.consumer;

import com.dousnl.api.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
        HelloService helloService = (HelloService) context.getBean("helloService");  
        String result = helloService.speakHello("yyf");  
        System.out.println(result);
	}

}
