package com.dousnl;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@ImportResource({"classpath:applicationContext.xml"})
public class SpringBootAppcation{
   
	
	/*SpringBootAppcation(){
		new SpringBootMvc();
	}*/
	/**
	 * @description 第一种方法重写configureMessageConverter方法
	 * @author hanliang
	 * @version 1.0
	 * @parameter @return 
	 *//*
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig=new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConverter);
	}
	*//**
	 * @description 第二种方法注入HttpMessageConverters
	 * @author hanliang
	 * @version 1.0
	 * @parameter @return 
	 *//*
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){ 
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig=new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter=fastConverter;
		return new HttpMessageConverters(converter);	
	}
	*//**
	 * @description 这是springleader参数    -javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
	 * @author hanliang
	 * @version 1.0
	 * @parameter @param args 
	 *//*	
	static class SpringBootMvc extends SpringBootServletInitializer {
		@Override
		protected SpringApplicationBuilder configure(
		SpringApplicationBuilder application) {
		return application.sources(SpringBootAppcation.class);
		}
	}*/
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppcation.class, args);
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
