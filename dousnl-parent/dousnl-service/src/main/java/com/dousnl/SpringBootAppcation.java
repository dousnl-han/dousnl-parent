package com.dousnl;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import com.dousnl.SpringBootAppcation;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@EnableAutoConfiguration
@SpringBootApplication
@ImportResource({"classpath:applicationContext.xml"})
@MapperScan("com.dousnl.**.mapper")
public class SpringBootAppcation extends WebMvcConfigurerAdapter{

	/**
	 * @description 第一种方法重写configureMessageConverter方法
	 * @author hanliang
	 * @version 1.0
	 * @parameter @return 
	 */
	/*@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig=new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConverter);
	}*/
	/**
	 * @description 第二种方法注入HttpMessageConverters
	 * @author hanliang
	 * @version 1.0
	 * @parameter @return 
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){ 
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig=new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter=fastConverter;
		return new HttpMessageConverters(converter);	
	}
	/**
	 * @description 这是springleader参数    -javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
	 * @author hanliang
	 * @version 1.0
	 * @parameter @param args 
	 */	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppcation.class, args);
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
