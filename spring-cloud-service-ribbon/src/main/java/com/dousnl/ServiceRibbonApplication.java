package com.dousnl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author Fairyland
 * 通过@EnableDiscoveryClient向服务中心注册；并且向程序的ioc注入一个bean: 
 * restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
 * 
 * 在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于http restful的。
 * Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，
 * 另一种是feign。在这一篇文章首先讲解下基于ribbon+rest。
 * 
 * ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。Feign默认集成了ribbon。
 */
@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(value = {"com.dousnl.controller","com.dousnl.service"})
@EnableHystrix
@EnableHystrixDashboard
public class ServiceRibbonApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args); 
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

