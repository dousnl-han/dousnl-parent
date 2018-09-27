package com.dousnl.security.domain;

import java.util.List;

public class Role {

	private int id;  //角色ID 主键 
	private String rolename;  //角色名称  用MD5 加密 
	private String roledesc;  //角色描述
	private String permisson;  //角色权限  
	private String baoliu;  //保留，默认：1  
	
	private List<User> users;  //用户 
	
	private List<RolePermission> permissons; //权限
}
