package com.dousnl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fairyland
 *
 */

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ConfigClientApplication {

	@Value("${foo}")
	String foo;
	@Value("${qaz}")
	String qaz;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@RequestMapping("hi")
	public String hi(){
	   return foo;	
	}
	@RequestMapping("qaz")
	public String qaz(){
	   return qaz;	
	}
	
	
	
	
}
