package org.dousnl.web.controller;

import org.dousnl.annotation.LogConfig;
import org.dousnl.api.domain.Fruit;
import org.dousnl.redis.bootredis.RedisUtil;
import org.dousnl.shiro.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@LogConfig(systemType="dousnl-protal",moudle="登录模块",moudleName="LoginController")
@Api(tags="swagger控制器Api")
@RequestMapping("/swagger/")
public class SwaggerController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());  

	@Autowired
	private UserService userService;
	@Autowired
	private RedisUtil redisUtil;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	@ApiOperation(value="swagger测试",notes="swagger测试获取index信息")
	public String index(){
		System.out.println("==================首页=====================");
		return "index2";
	}
	@RequestMapping(value="fruit",method=RequestMethod.POST)
	@ApiOperation(value="fruit测试",notes="fruit测试获取body信息")
	@ResponseBody
	//写此注解，只是用于swagger端测试，并不是兼容其他测试工具
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="fruit主键ID",paramType="body")
	})
	public Fruit getFruit(Integer id){
		Fruit fruit=new Fruit();
		fruit.setId(id);
		fruit.setName("pingguo");
		fruit.setPrace(3.88);
		return fruit;
	}
	
}
