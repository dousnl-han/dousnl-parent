package com.dousnl.interceptor.config;

import com.SpringBootAppcation;
import com.dousnl.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


//@Configuration
@ComponentScan(basePackageClasses=SpringBootAppcation.class,useDefaultFilters=true)
public class InterceptorConfig extends WebMvcConfigurationSupport{
	
	private static final String FAVICON_URL = "/favicon.ico";
	private static final String PROPERTY_APP_ENV = "application.environment";
	private static final String PROPERTY_DEFAULT_ENV = "dev";

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/").addResourceLocations("/**");
        registry.addResourceHandler("/static/**").addResourceLocations("/resources/static/");
    }

    /**
     * 配置servlet处理
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor())
		        .addPathPatterns("/**")
		        .excludePathPatterns(FAVICON_URL);
	}
}
