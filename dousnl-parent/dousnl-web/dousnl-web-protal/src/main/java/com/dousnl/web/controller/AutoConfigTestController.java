package com.dousnl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dousnl.autoconfig.HelloServer;
import com.dousnl.shiro.domain.TXqb;
import com.dousnl.shiro.domain.User;
import com.dousnl.shiro.mapper.TXqbMapper;
import com.dousnl.shiro.service.UserService;
import com.dousnl.shiro.service.XqbService;

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
