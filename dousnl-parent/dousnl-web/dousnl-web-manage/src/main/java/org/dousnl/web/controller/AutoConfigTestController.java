package org.dousnl.web.controller;

import org.dousnl.autoconfig.HelloServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AutoConfigTestController {

	@Autowired
	HelloServer helloServer;
	
	@RequestMapping("autoconfig")
	@ResponseBody
	public String autoconfig(){
       return helloServer.sayHello();
	}
}
