package com.dousnl.framework.security.service;

public abstract class UserServiceAbstract implements UserService{

	public int a=5;
	
	public abstract int getData(int b);
	
	public int Test(int b) {
		return a*getData(b);
	}
}
