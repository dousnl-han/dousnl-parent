package org.dousnl.web.controller;

import org.dousnl.api.domain.TPermission;
import org.dousnl.api.service.HelloService;
import org.dousnl.api.service.TPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;

@Controller
@RequestMapping("/dubbo/")
public class DubboCoustemr {

	@Reference(group="trade")
	private HelloService helloService;
	@Reference(group="trade")
	private TPermissionService permissionService;
	
	@RequestMapping("start")
	@ResponseBody
	public String start(){
		System.out.println("dubbo coustemr test::"+helloService.speakHello("dubbo connect successfunlly!"));
		return "success!!";
	}
	@RequestMapping("permission")
	@ResponseBody
	public TPermission dubboTest(){
		System.out.println("dubbo coustemr permission::"+permissionService.selectByPrimaryKey(1, 1));
		TPermission selectByPrimaryKey = permissionService.selectByPrimaryKey(1, 1);
		return selectByPrimaryKey;
	}
}
