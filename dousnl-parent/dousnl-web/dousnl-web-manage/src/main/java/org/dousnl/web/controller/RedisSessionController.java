package org.dousnl.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis/")
public class RedisSessionController {

	@RequestMapping("session")
	@ResponseBody
	public String RedisSession(HttpServletRequest request){
		Object attribute = request.getSession().getAttribute("spring-boot");
		if(null==attribute){
			attribute="spring-boot有端口"+request.getLocalPort()+"生成！";
			request.getSession().setAttribute("spring-boot", attribute);
		}
		return "端口"+request.getLocalPort()+" sessionId:"+request.getSession().getId()+" "
				+ "<br/>"+attribute;
	}
}
