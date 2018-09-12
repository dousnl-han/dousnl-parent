package org.dousnl.web.controller;

import org.dousnl.api.domain.Fruit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class SprinigBootController {

	@RequestMapping("/hello")
	public String getHello(){
		System.out.println("1223");
		System.out.println("1223");
		System.out.println("1223");
		System.out.println("1223");
		System.out.println("1223");
		return "demo";
	}
	@RequestMapping("/fruit")
	@ResponseBody
	public Fruit getFruit(){
		Fruit fruit=new Fruit();
		fruit.setName("pingguo");
		fruit.setPrace(3.88);
		return fruit;
	}
}
