package com.dousnl.shiro.controller;

import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class LoginController {

	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	@RequestMapping(value="/index/success",method=RequestMethod.GET)
	@ResponseBody
	public String success(){
		return "/index/success";
	}
	@RequestMapping(value="/index/loginSuccess",method=RequestMethod.GET)
	public String toIndex(){
		return "index";
	}
	@RequestMapping(value="/index/body",method=RequestMethod.GET)
	@ResponseBody
	public String body(){
		return "/index/body";
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
