package org.dousnl.reflect;

public class Main{
	
	public static void main(String[] args) throws ClassNotFoundException {
	    //不会初始化静态块
		Class clazz=Base.class;
		System.out.println("---------");
		//会初始化静态块
		Class<?> clazz2 = Class.forName("Base");
		
	}
}