package com.dousnl.service;

import javax.ws.rs.Path;

import com.alibaba.dubbo.config.annotation.Service;
import com.dousnl.service.HelloService;

/*@Service(protocol={"dubbo"})
@Path("helloService")*/
public class HelloServiceImpl implements HelloService{
	/**
	 * dubbo provider server
	 * zookeeper registry
	 */
	@Override
	public String speakHello(String name) { 
        return "dubbo provider test hello：" + name;  
    } 

}
