package com.dousnl.security.domain;

import java.util.List;

public class User {
	
	private int id;  //用户ID 主键 
	private String username;  //用户名 
	private String password;  //用户密码  用MD5 加密 
	private String realname;  //用户真实姓名 
	private String email;  //用户Email 
	private int state;  //用户状态，默认：0
	private String baoliu;  //保留，默认：1  
	
	private List<Role> roles;  //角色

}
