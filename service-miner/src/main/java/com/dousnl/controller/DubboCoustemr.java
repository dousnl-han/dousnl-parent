/*package com.dousnl.controller;

import com.dousnl.api.service.UserServiceDubbo;
import com.dousnl.api.domain.TUser;
import com.dousnl.service.XqbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/dubbo/")
public class DubboCoustemr {

	@Autowired
	private UserServiceDubbo userService;
	@Autowired
	private XqbService xqbService;
	
	@RequestMapping("hl")
	@ResponseBody
	public String hl(TUser user){
		return "保存成功....";
	}

	@RequestMapping("fbs")
	@ResponseBody
	public String addXqb(){
		boolean transtion = xqbService.testTranstionXqb();
		if(transtion)
			return "保存成功....";
		return "保存失败....";
	}
	
}
*/