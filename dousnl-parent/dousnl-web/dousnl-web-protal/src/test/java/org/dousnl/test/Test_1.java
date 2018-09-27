package org.dousnl.test;

import com.dousnl.SpringBootAppcation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dousnl.shiro.domain.User;
import com.dousnl.shiro.mapper.UserMapper;
import com.dousnl.shiro.service.UserService;

/**
 * 此配置为spring-boot项目测试注解
 * @author hanliang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootAppcation.class)
/**
 * 此配置为普通web项目测试注解
 * @author hanliang
 */
//@ContextConfiguration(locations={"classpath:"})
//@RunWith(SpringJUnit4ClassRunner.class)
public class Test_1 {

	
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void find(){
		System.out.println("------------------UserServiceImpl---------------");
		User user=new User();
		user.setUsername("catest");
		user.setPassword("catest");
		User u=userMapper.selectByUser(user);
		System.out.println("u:"+u.getId());
		System.out.println("u:"+u.getRoleId());
		System.out.println("u:"+u.getUsername());
		System.out.println("u:"+u.getPassword());
	}
	
}
