package com.dousnl.dubbo;

import javax.ws.rs.Path;

import com.dousnl.api.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;


@Service(protocol={"dubbo"})
@Path("providerService")
public class ProviderServiceImpl implements ProviderService{

	/*@Autowired
	HelloService helloService;*/
	
	@Override
	public void subService(String name) {
		System.out.println(name+"发布服务成功！！");
		//String speakHello = helloService.speakHello(name);
		//System.out.println("speakHello:"+speakHello);
	}

}
