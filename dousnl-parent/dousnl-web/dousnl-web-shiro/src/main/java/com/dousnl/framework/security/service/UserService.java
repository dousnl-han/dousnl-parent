package com.dousnl.framework.security.service;

import java.util.Set;

import com.dousnl.framework.security.domain.User;


public interface UserService{
	
	User selectByUser(User user);
	
	Set<String> selectRolesByUser(User user);
	
	Set<String> selectPermissionsByUser(User user);
	
	int saveUser(User user);
	
	int updateUser(User user);
	
	boolean testTranstion();
	
	boolean testTranstionXqb();

	User findByUsername(String username);
}
