package com.dousnl.extend;

public class SuperClass {

	public static String name;
	
	public String flag;
	
	static {
		name="supername";
	}
	
	public SuperClass() {
		System.out.println("super constructor");
		this.flag="boolean";
	}
}
