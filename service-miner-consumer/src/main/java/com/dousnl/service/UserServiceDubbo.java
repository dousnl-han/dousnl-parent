package com.dousnl.service;

import java.util.List;

import com.dousnl.api.domain.TUser;


public interface UserServiceDubbo{
	
	int saveUser(TUser user);
	
	int updateUser(TUser user);
	
	List<TUser> listAllUser();
	
}
