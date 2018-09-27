package org.dousnl.web.controller;


import java.util.UUID;

import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.dousnl.annotation.Log;
import org.dousnl.annotation.LogConfig;
import org.dousnl.api.domain.Fruit;
import org.dousnl.redis.bootredis.RedisUtil;
import org.dousnl.shiro.domain.User;
import org.dousnl.shiro.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@LogConfig(systemType="dousnl-protal",moudle="登录模块",moudleName="LoginController")
@Api(tags="登录控制器Api")
@RequestMapping("/login/")
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  

	@Autowired
	private UserService userService;
	@Autowired
	private RedisUtil redisUtil;
	
	@RequestMapping(method=RequestMethod.GET)
	@Log(name="login",value="登录")
	public String login(String username,String password,HttpSession session,Model model){
		System.out.println("==================login=====================");
		System.out.println("token");
		System.out.println("username:"+username);
		
		/*if(StringUtils.isNoneBlank(username)){
			System.out.println("tokenUserName:"+username);
			UserDetails user = userService.loadUserByUsername(username);
			if (user == null) {
	            throw new UsernameNotFoundException("用户名不存在");
	        }else{
	        	if(StringUtils.isNoneBlank(password)){
	        		if(password.equals(user.getPassword()))
	        			return "redirect:home";
	        		else
	        			throw new UsernameNotFoundException("密码错误。。");
	        	}else
	        		throw new UsernameNotFoundException("未填写密码。。");
	        }
		}else{
			return "login";
		}*/
		logger.debug("**************返回登录页面*************");
		return "login";
	}
	/*@RequestMapping("error")
	@ResponseBody
	public String error(){
		System.out.println("==================error=====================");
		return "登录失败！";
	}*/
	
	@RequestMapping(value="loginUser",method=RequestMethod.POST)
	@Log(name="loginUser",value="注销")
	public String loginUser(String username,String password,HttpSession session,Model model){
		System.out.println("token");
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		System.out.println("token:"+token);
		System.out.println("tokenUserName:"+token.getUsername());
		System.out.println("tokenPassWord:"+token.getPassword().toString());
		System.out.println("tokenPrincipal:"+token.getPrincipal());
		Subject subject=SecurityUtils.getSubject();
		try {
			if(redisUtil.get(username)!=null){
				redisUtil.set(username, "dousnl#"+UUID.randomUUID()+username);
				return "redirect:home";
			}else{
				subject.login(token);
				redisUtil.set(username, "dousnl#"+UUID.randomUUID()+username);
			}
			if(redisUtil.get(username)==null){
			}
			@SuppressWarnings("unused")
			Object principal = subject.getPrincipal();
			User user=new User();
			model.addAttribute("user", user);
			return "redirect:home";
		} catch (UnknownAccountException e) {
			logger.error(String.format("user not found: %s", username), e); // 用户不存在
			return "login";
		} catch (IncorrectCredentialsException e) {
			logger.error(String.format("incorrent credentials: %s", username), e); // 密码不正确
			return "login";
		} catch (ConcurrentAccessException e) {
			logger.error(String.format("user has been authenticated: %s", username), e); // 用户重复登录
			return "login";
		} catch (AccountException e) {
			logger.error(String.format("account except: %s", username), e); // 其他账户异常
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("异常");
			return "login";
		}
	}
	@RequestMapping(value="home",method=RequestMethod.GET)
	@Log(name="home",value="首页")
	public String home(){
		System.out.println("==================首页=====================");
		return "home";
	}
	@RequestMapping(value="index",method=RequestMethod.GET)
	@ApiOperation(value="swagger测试",notes="swagger测试获取index信息")
	public String index(){
		System.out.println("==================首页=====================");
		return "index2";
	}
	@RequestMapping(value="fruitSwagger",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="fruit测试",notes="fruit测试获取body信息",position=1)
	//写此注解，只是用于swagger端测试，并不是兼容其他测试工具
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="fruit主键ID",paramType="body",dataType="int")
	})
	public Fruit getFruit(Integer id){
		Fruit fruit=new Fruit();
		fruit.setId(id);
		fruit.setName("pingguo");
		fruit.setPrace(3.88);
		return fruit;
	}
	@RequestMapping(value="add/index2",method=RequestMethod.GET)
	public String index2(){
		System.out.println("==================首页=====================");
		return "index3";
	}
	
	@RequestMapping(value="logOutInd",method=RequestMethod.GET)
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }
	
	@RequestMapping(value="user",method=RequestMethod.POST)
	@ResponseBody
	public User findUser(User user){
		System.out.println("==================user=====================");
		User platUser=userService.selectByUser(user);
		System.out.println("username:"+platUser.getUsername());
		System.out.println("password:"+platUser.getPassword());
		return platUser;
	}
	
	@RequestMapping(value="addUser",method=RequestMethod.GET)
	@ResponseBody
	public boolean addUser(User user){
		System.out.println("==================user=====================");
		boolean transtion = userService.testTranstion();
		return transtion;
	}
	
	/*@RequestMapping("/login")
	public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
	    System.out.println("HomeController.login()");
	    // 登录失败从request中获取shiro处理的异常信息。
	    // shiroLoginFailure:就是shiro异常类的全类名.
	    String exception = (String) request.getAttribute("shiroLoginFailure");
	    System.out.println("exception=" + exception);
	    String msg = "";
	    if (exception != null) {
	        if (UnknownAccountException.class.getName().equals(exception)) {
	            System.out.println("UnknownAccountException -- > 账号不存在：");
	            msg = "UnknownAccountException -- > 账号不存在：";
	        } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
	            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
	            msg = "IncorrectCredentialsException -- > 密码不正确：";
	        } else if ("kaptchaValidateFailed".equals(exception)) {
	            System.out.println("kaptchaValidateFailed -- > 验证码错误");
	            msg = "kaptchaValidateFailed -- > 验证码错误";
	        } else {
	            msg = "else >> "+exception;
	            System.out.println("else -- >" + exception);
	        }
	    }
	    map.put("msg", msg);
	    // 此方法不处理登录成功,由shiro进行处理
	    return "/login";
	}*/
}
