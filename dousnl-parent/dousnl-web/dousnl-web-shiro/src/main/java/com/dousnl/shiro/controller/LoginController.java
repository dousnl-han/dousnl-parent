package com.dousnl.shiro.controller;

import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping(value="/loginIn",method=RequestMethod.POST)
	public String loginUser(String username,String password,HttpSession session,Model model){
		System.out.println("token");
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		System.out.println("token:"+token);
		System.out.println("tokenUserName:"+token.getUsername());
		System.out.println("tokenPassWord:"+token.getPassword().toString());
		System.out.println("tokenPrincipal:"+token.getPrincipal());
		Subject subject=SecurityUtils.getSubject();
		try {
			return "redirect:home";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("异常");
			return "login";
		}
	}
}
