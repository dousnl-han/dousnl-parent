package com.dousnl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dousnl.annotation.Controller;
import com.dousnl.annotation.Quatifier;
import com.dousnl.annotation.RequestMapping;
import com.dousnl.service.MyService;
import com.dousnl.service.SpringmvcServiceImpl;

@Controller("hl")
public class SpringMvcController {
	
	@Quatifier("myServiceImpl")
	MyService myService;
	@Quatifier
	SpringmvcServiceImpl smService;
 
	@RequestMapping("insert")
	public String insert(HttpServletRequest request, HttpServletResponse response, String param) {
		myService.insert(null);
		smService.insert(null);
		return "aaa";
	}
 
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, String param) {
		myService.delete(null);
		smService.delete(null);
		return null;
	}
 
	@RequestMapping("update")
	public String update(HttpServletRequest request, HttpServletResponse response, String param) {
		myService.update(null);
		smService.update(null);
		return null;
	}
 
	@RequestMapping("select")
	public String select(HttpServletRequest request, HttpServletResponse response, String param) {
		myService.select(null);
		smService.select(null);
		return null;
	}
}
