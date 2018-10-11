package com.dousnl.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.dousnl.api.domain.TUser;
import com.dousnl.api.service.UserServiceDubbo;
import com.dousnl.service.XqbService;


@Controller
@RequestMapping("/service/")
public class AutoConfigTestController {

	@Autowired
	private UserServiceDubbo userService;
	@Autowired
	private XqbService xqbService;
	
	@RequestMapping("hl")
	@ResponseBody
	public String hl(TUser user){
		return "保存成功....";
	}
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(TUser user){
		try {
			TUser u=new TUser();
			u.setId(8);
			u.setUsername("tran1");
			u.setPassword("trans1");
			//int transtion = userService.saveUser(u);
			TUser u1=new TUser();
			u1.setId(7);
			u1.setUsername("tran1");
			u1.setPassword("trans1");
			int transtion1 = userService.saveUser(u);
			if(transtion1>0){
				return "保存成功....";
			}
			return "保存失败....";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("保存失败....");
		}
		
	}
	@RequestMapping("selectUser")
	@ResponseBody
	public String selectUser(){
		List<TUser> listAllUser = userService.listAllUser();
		return JSON.toJSONString(listAllUser);
	}
	@RequestMapping("addXqb")
	@ResponseBody
	public String addXqb(){
		boolean transtion = xqbService.testTranstionXqb();
		if(transtion)
			return "保存成功....";
		return "保存失败....";
	}
	
}
