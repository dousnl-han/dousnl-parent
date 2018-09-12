package org.dousnl.shiro.service;

import java.util.Set;

import org.dousnl.shiro.domain.User;

public interface UserService {
	
	User selectByUser(User user);
	
	Set<String> selectRolesByUser(User user);
	
	Set<String> selectPermissionsByUser(User user);
	
    int saveUser(User user);
}
