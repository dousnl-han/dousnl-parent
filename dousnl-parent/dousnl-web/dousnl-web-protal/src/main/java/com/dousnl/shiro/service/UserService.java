package com.dousnl.shiro.service;

import java.util.List;
import java.util.Set;

import com.dousnl.api.domain.TUser;
import com.dousnl.shiro.domain.User;

public interface UserService{
	
	User selectByUser(User user);
	
	Set<String> selectRolesByUser(User user);
	
	Set<String> selectPermissionsByUser(User user);
	
	int saveUser(User user);
	
	int updateUser(User user);
	
	boolean testTranstion();
	
	boolean testTranstionXqb();
	
	void testFbs(User user,TUser u);
	
	List<TUser> listAllUser();
}
