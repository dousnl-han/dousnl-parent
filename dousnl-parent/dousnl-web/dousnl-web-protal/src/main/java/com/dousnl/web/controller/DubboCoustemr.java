package com.dousnl.web.controller;

import com.dousnl.api.domain.TPermission;
import com.dousnl.api.domain.TUser;
import com.dousnl.api.service.HelloService;
import com.dousnl.api.service.TPermissionService;
import com.dousnl.api.service.UserServiceDubbo;
import com.dousnl.shiro.domain.User;
import com.dousnl.shiro.service.UserService;
import com.dousnl.shiro.service.XqbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;

/**
 * dubbo相关测试
 * @author 56096
 *
 */
@Controller
@RequestMapping("/dubbo/")
public class DubboCoustemr {

	@Reference(group="trade")
	private HelloService helloService;
	@Reference(group="trade")
	private TPermissionService permissionService;
	@Reference(group="trade")
	private UserServiceDubbo userServiceDubbo;
	@Autowired
	private UserService userService;
	@Autowired
	private XqbService xqbService;
	
	@RequestMapping("start")
	@ResponseBody
	public String start(){
		System.out.println("dubbo coustemr test::"+helloService.speakHello("dubbo connect successfunlly!"));
		return helloService.speakHello("dubbo connect successfunlly!");
	}
	@RequestMapping("permission")
	@ResponseBody
	public TPermission dubboTest(){
		System.out.println("dubbo coustemr permission::"+permissionService.selectByPrimaryKey(1, 1));
		TPermission selectByPrimaryKey = permissionService.selectByPrimaryKey(1, 1);
		return selectByPrimaryKey;
	}
	/**
	 * 此处测试分布式事务,无效,因shiro管理userService,并无交由spring容器管理
	 * 故userService不支持事务回滚
	 * 测试失败!( 向下fbs3测试通过!)
	 * 2018年10月11日 下午2:10:02
	 */
	@RequestMapping("fbs")
	@ResponseBody
	public String fbs(){
		User user=new User();
		user.setId(8);
		user.setUsername("tran");
		user.setPassword("trans");
		TUser u=new TUser();
		u.setId(9);
		u.setUsername("tran1");
		u.setPassword("trans1");
		userService.testFbs(user, u);
		return "success!!";
	}
	@RequestMapping("fbs2")
	@ResponseBody
	public String fbs2(){
		return JSON.toJSONString(userService.listAllUser());
	}
	/**
	 * test fbs transactional 默认的shiro userService不支持事务,
	 * 此处用tXqbMapper测试(分布式事务)
	 * 测试通过!
	 * 2018年10月11日 下午2:07:24
	 */
	@RequestMapping("fbs3")
	@ResponseBody
	public String fbs3(){
		boolean transtion = xqbService.testTranstionXqb();
		if(transtion)
			return "保存成功....";
		return "保存失败....";
	}
}
