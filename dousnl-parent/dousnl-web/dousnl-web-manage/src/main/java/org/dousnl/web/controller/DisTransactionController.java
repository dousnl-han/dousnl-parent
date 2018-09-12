package org.dousnl.web.controller;

import javax.jms.JMSException;

import org.dousnl.shiro.domain.User;
import org.dousnl.shiro.service.UserService;
import org.dousnl.util.ActiveMqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * @author Fairyland
 * 分布式事务
 */

@Controller
@RequestMapping("/distran/")
public class DisTransactionController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("saveUser")
	@ResponseBody
	public String distran(){
		User u=new User(4,"xiaoming","xiaoming",4);
		int count = userService.saveUser(u);
		if(count>0){
			try {
				String msg=JSON.toJSONString(u);
				ActiveMqUtil.creatQueue("save.user", msg);
				return "保存成功:"+msg;
			} catch (JMSException e) {
				e.printStackTrace();
				return e.getMessage();
			}
		}
		return "保存失败！";
	}
}
