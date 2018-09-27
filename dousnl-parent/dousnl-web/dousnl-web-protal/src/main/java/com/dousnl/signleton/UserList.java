package com.dousnl.signleton;

import java.util.Vector;

/**
 * 单例模式  userlist
 * @author hanliang
 *
 */
public class UserList {
	
	private static final UserList USER_LIST=new UserList();
	
	private Vector<String> v;
	
	private UserList(){
		v=new Vector<String>();
	}
	public static UserList getInstance(){
		return USER_LIST;
	}
	public void addUser(String name){
		if(name!=null)
		  v.add(name);
	}

}
