package com.dousnl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.dousnl.api.domain.TUser;
import com.dousnl.service.UserServiceDubbo;
import com.dousnl.service.XqbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/dubbo/")
public class DubboCoustemr {

	@Autowired
	private UserServiceDubbo userServiceDubbo;
	@Autowired
	private XqbService xqbService;
	
	@RequestMapping("hl")
	@ResponseBody
	public String hl(TUser user){
		return "保存成功....";
	}

	@RequestMapping("zk")
	@ResponseBody
	public String zk(){
		return JSON.toJSONString(userServiceDubbo.listAllUser());
	}
	@RequestMapping("fbs")
	@ResponseBody
	public String addXqb(){
		boolean transtion = xqbService.testTranstionXqb();
		if(transtion)
			return "保存成功....";
		return "保存失败....";
	}
	
	/**
	 * test fbs transactional 默认的shiro userService不支持事务,
	 * 此处用tXqbMapper测试(分布式事务)
	 * 测试通过!
	 * 2018年10月11日 下午2:07:24
	 */
	@RequestMapping("fbs3")
	@ResponseBody
	public String fbs3(){
		boolean transtion = xqbService.testTranstionXqb();
		if(transtion)
			return "保存成功....";
		return "保存失败....";
	}
	
}
