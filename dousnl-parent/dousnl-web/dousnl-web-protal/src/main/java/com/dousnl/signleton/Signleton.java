package com.dousnl.signleton;

public class Signleton {

	private Signleton(){
		System.out.println("hello 单例模式");
	}
	
	private static Signleton instance=new Signleton();
	
	public static Signleton getInstance(){
		return instance;
	}
	
}
