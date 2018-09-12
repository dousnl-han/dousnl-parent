package org.dousnl.service;

import javax.ws.rs.Path;

import org.dousnl.api.service.HelloService;
import com.alibaba.dubbo.config.annotation.Service;

@Service(protocol={"dubbo"})
@Path("helloService")
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
