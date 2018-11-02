package com.dousnl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dousnl.domain.TUser;
import com.dousnl.service.UserServiceDubbo;

@Controller
@RequestMapping("/cloud")
public class FbsController {

	@Autowired
	private UserServiceDubbo userService;
	
	@RequestMapping(value="/ek",method = RequestMethod.GET)
	@ResponseBody
	public void hl(){
		TUser u=new TUser();
		u.setId(8);
		u.setUsername("tran1");
		u.setPassword("trans1");
		int saveUser = userService.saveUser(u);
		//return "保存成功....";
	}
	@RequestMapping(value = "/cs",method = RequestMethod.GET)
	 @ResponseBody
    public String cs(){
       return "调用成功......";
    }
	@RequestMapping("/bc")
	@ResponseBody
	public Boolean bc(TUser user){
		TUser u=new TUser();
		u.setId(8);
		u.setUsername("tran1");
		u.setPassword("trans1");
		int saveUser = userService.saveUser(u);
		return saveUser>0;
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public String list(){
	    return JSON.toJSONString(userService.listAllUser());
	}
}
