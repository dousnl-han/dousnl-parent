package com.dousnl.framework.security.service;

import java.util.Set;

import com.dousnl.framework.security.domain.User;


public class UserServiceAbstractImpl extends UserServiceAbstract{

	@Override
	public User selectByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> selectRolesByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> selectPermissionsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getData(int b) {
		if(b!=0)
			return b;
		return 5;
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean testTranstion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean testTranstionXqb() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}*/

}
