package com.dousnl.service;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dousnl.domain.TUser;

@FeignClient(value="eureka-client")
public interface UserServiceDubboClient{
	
	@RequestMapping(value ="/cloud/ek",method = RequestMethod.GET)
	void saveUser();
	
	@RequestMapping(value ="/cloud/update",method = RequestMethod.GET)
	int updateUser(TUser user);
	
	@RequestMapping(value ="/cloud/list",method = RequestMethod.GET)
	List<TUser> listAllUser();
	
}
