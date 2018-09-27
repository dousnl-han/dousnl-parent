package com.dousnl.web.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/freemarker-test")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("freemarker")
    public String test(HttpServletRequest request) {
        request.setAttribute("haha", "1111111111");
        System.out.println("调用了order-freemarker");
        return "order-freemarker";
    }
}
