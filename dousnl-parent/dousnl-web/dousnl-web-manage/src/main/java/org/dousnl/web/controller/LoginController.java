package org.dousnl.web.controller;
/*package org.dousnl.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.dousnl.shiro.domain.User;
import org.dousnl.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("==================login=====================");
		return "login";
	}
	
	@RequestMapping("/loginUser")
	public String loginUser(String username,String password,HttpSession session,Model model){
		System.out.println("token");
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		System.out.println("token:"+token);
		System.out.println("tokenUserName:"+token.getUsername());
		System.out.println("tokenPassWord:"+token.getPassword());
		System.out.println("tokenPrincipal:"+token.getPrincipal());
		Subject subject=SecurityUtils.getSubject();
		try {
			System.out.println("1111111");
			subject.login(token);
			System.out.println("22222222");
			//User user=(User) subject.getPrincipals();
			//session.setAttribute("user", user);
			User user=new User();
			user.setUsername(username);
			model.addAttribute("user", user);
			return "redirect:home";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("33333333333");
			return "login";
		}
	}
	@RequestMapping("/home")
	public String home(){
		System.out.println("==================首页=====================");
		return "home";
	}
	@RequestMapping("/index")
	public String index(){
		System.out.println("==================首页=====================");
		return "index2";
	}
	@RequestMapping("add/index2")
	public String index2(){
		System.out.println("==================首页=====================");
		return "index3";
	}
	
	@RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }
	
	@RequestMapping("/user")
	@ResponseBody
	public User findUser(User user){
		System.out.println("==================user=====================");
		User platUser=userService.selectByUser(user);
		System.out.println("username:"+platUser.getUsername());
		System.out.println("password:"+platUser.getPassword());
		return platUser;
	}
}
*/