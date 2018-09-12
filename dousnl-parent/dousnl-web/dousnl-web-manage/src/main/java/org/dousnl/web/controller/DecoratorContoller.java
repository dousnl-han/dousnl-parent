package org.dousnl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/decorator/")
public class DecoratorContoller {

	@RequestMapping("test")
	public String decoratorTest(){
		
		System.out.println("asda");
		return "demo";
		
	}
}
