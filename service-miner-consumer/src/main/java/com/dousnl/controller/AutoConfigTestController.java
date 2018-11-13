package com.dousnl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dousnl.api.domain.TUser;
import com.dousnl.service.XqbService;


@Controller
@RequestMapping("/service/")
public class AutoConfigTestController {

	@Autowired
	private XqbService xqbService;
	
	@RequestMapping("hl")
	@ResponseBody
	public String hl(TUser user){
		return "保存成功....";
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
