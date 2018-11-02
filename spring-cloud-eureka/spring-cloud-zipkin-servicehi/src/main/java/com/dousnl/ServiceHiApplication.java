package com.dousnl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServiceHiApplication {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
	private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@RequestMapping("/hi")
    public String callHome(){
        LOG.log(Level.INFO, "calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }
	
	/**
	 * @return
	 * info为内置方法，直接调用info，会出现返回为 {},无数据的情况
	 * 故此处改方法名为info2
	 */
	@RequestMapping("/info2")
    public String info2(){
        LOG.log(Level.INFO, "calling trace service-hi  ");
        return "i'm service-hi";
    }
	
	@Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
