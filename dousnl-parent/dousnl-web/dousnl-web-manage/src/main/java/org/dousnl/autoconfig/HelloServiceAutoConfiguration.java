package org.dousnl.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloServerProperties.class)
@ConditionalOnClass(HelloServer.class)
@ConditionalOnProperty(prefix="hello",value="enabled",matchIfMissing=true)
public class HelloServiceAutoConfiguration {

	@Autowired
	private HelloServerProperties helloServerProperties;
	
	@Bean
	@ConditionalOnMissingBean(HelloServer.class)
	public HelloServer helloServer(){
		HelloServer helloServer=new HelloServer();
		helloServer.setMsg(helloServerProperties.getMsg());
		return helloServer;
	}
}
