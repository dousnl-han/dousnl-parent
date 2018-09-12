package org.dousnl.shiro.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.dousnl.shiro.domain.Permission;
import org.dousnl.shiro.domain.User;
import org.dousnl.shiro.mapper.PermissionMapper;
import org.dousnl.shiro.mapper.UserMapper;
import org.dousnl.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	
	
	@Override
	public Set<String> selectRolesByUser(User user) {
		return userMapper.selectRolesByUser(user);
	}
	/**
	 * 获取权限集合
	 * @param permission
	 * @return
	 */
	@Override
	public Set<String> selectPermissionsByUser(User user) {
		Set<String> set=new HashSet<String>();
		Permission permission=permissionMapper.selectByRoleId(user.getRoleId());
		String [] permiss=permission.getPermissionName().split(",");
		for(String s:permiss){
			set.add(s);
		}
		return set;
	}
	/**
	 * 根据账号user查询当前用户
	 * @param user
	 * @return
	 */
	@Override
	public User selectByUser(User user) {
		System.out.println("------------------UserServiceImpl---------------");
		return userMapper.selectByUser(user);
	}
	@Override
	public int saveUser(User user) {
		return userMapper.insert(user);
	}

}
