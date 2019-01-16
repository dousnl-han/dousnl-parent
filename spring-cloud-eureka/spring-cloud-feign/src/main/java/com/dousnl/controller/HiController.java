package com.dousnl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.dousnl.service.SchedualServiceHi;
import com.dousnl.service.UserServiceDubboClient;
import com.dousnl.service.XqbService;

@RestController
public class HiController {

	 @Autowired
	 private SchedualServiceHi schedualServiceHi;
	 @Autowired
	 private UserServiceDubboClient userServiceDubbo;
	 @Autowired
	 private XqbService xqbService;
	 
	 @RequestMapping(value = "/hi",method = RequestMethod.GET)
     public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
     }
	 
	 @RequestMapping(value = "/cs",method = RequestMethod.GET)
	 @ResponseBody
     public String cs(){
        return "调用成功......";
     }
	 
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
	 @ResponseBody
     public String list(){
        return JSON.toJSONString(userServiceDubbo.listAllUser());
     }
	 @RequestMapping(value = "/fbs",method = RequestMethod.GET)
	 @ResponseBody
     public Boolean fbs(){
		 boolean flag=false;
		 try {
			 flag=xqbService.testFbs();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return flag;
     }
	
	 @RequestMapping(value = "/bc",method = RequestMethod.GET)
	 @ResponseBody
     public Boolean bc(){
        return xqbService.testBC();
     }
}
