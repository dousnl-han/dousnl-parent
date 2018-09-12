package org.dousnl.config;


import java.io.IOException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import freemarker.template.TemplateException;


/**
 * @author Fairyland
 * @date 2017年8月15日
 * @parameter SpringMvcConfig
 * springMvc手动配置，自动配置在applicaiton.properties文件
 */
@Configuration
public class SpringMvcConfig {

	/**
	 * @description 配置映射
	 * @author Fairyland
	 * @version 1.0
	 * @return 
	 * springMvc手动配置，自动配置在applicaiton.properties文件
	 */
	@Bean
	@ConditionalOnMissingBean
	public  InternalResourceViewResolver defaultViewResolver(){
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		//springMvc手动配置，自动配置在applicaiton.properties文件
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}
	
	@Bean
	public FreeMarkerViewResolver getFmViewResolver(){
		FreeMarkerViewResolver resolver=new FreeMarkerViewResolver();
		resolver.setCache(true);
		resolver.setPrefix("");
		resolver.setSuffix(".ftl");
		resolver.setContentType("text/html; charset=UTF-8");
		resolver.setOrder(0);
		return resolver;
	}
	
	@Bean
	public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException{
		FreeMarkerConfigurationFactory factory=new FreeMarkerConfigurationFactory();
		factory.setTemplateLoaderPath("classpath:templates");
		factory.setDefaultEncoding("UTF-8");
		FreeMarkerConfigurer reslut=new FreeMarkerConfigurer();
		reslut.setConfiguration(factory.createConfiguration());
		return reslut;
	}
}
