package org.dousnl.web.controller;

import org.dousnl.autoconfig.HelloServer;
import org.dousnl.shiro.domain.TXqb;
import org.dousnl.shiro.domain.User;
import org.dousnl.shiro.mapper.TXqbMapper;
import org.dousnl.shiro.service.UserService;
import org.dousnl.shiro.service.XqbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class AutoConfigTestController {

	@Autowired
	HelloServer helloServer;
	@Autowired
	private UserService userService;
	@Autowired
	private XqbService xqbService;
	@Autowired
	private TXqbMapper tXqbMapper;
	
	@RequestMapping("autoconfig")
	@ResponseBody
	public String autoconfig(){
       return helloServer.sayHello();
	}
	
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(){
		boolean transtion = userService.testTranstion();
		if(transtion)
			return "保存成功....";
		return "保存失败....";
	}
	@RequestMapping("addXqb")
	@ResponseBody
	public String addXqb(){
		boolean transtion = xqbService.testTranstionXqb();
		if(transtion)
			return "保存成功....";
		return "保存失败....";
	}
	
	@RequestMapping("selTxqb")
	@ResponseBody
	public String addTxqb(){
		TXqb transtion = tXqbMapper.selectByPrimaryKey(1);
		return JSON.toJSONString(transtion);
	}
}
