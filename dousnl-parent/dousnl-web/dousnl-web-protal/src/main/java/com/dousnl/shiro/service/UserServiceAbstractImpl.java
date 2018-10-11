package com.dousnl.shiro.service;

import java.util.List;
import java.util.Set;

import com.dousnl.api.domain.TUser;
import com.dousnl.shiro.domain.User;

public class UserServiceAbstractImpl extends UserServiceAbstract{

	@Override
	public User selectByUser(User user) {
		return null;
	}

	@Override
	public Set<String> selectRolesByUser(User user) {
		return null;
	}

	@Override
	public Set<String> selectPermissionsByUser(User user) {
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
		return 0;
	}

	@Override
	public int updateUser(User user) {
		return 0;
	}

	@Override
	public boolean testTranstion() {
		return false;
	}

	@Override
	public boolean testTranstionXqb() {
		return false;
	}

	@Override
	public void testFbs(User user, TUser u) {
		
	}

	@Override
	public List<TUser> listAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}*/

}
