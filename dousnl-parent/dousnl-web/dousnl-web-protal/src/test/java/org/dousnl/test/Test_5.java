package org.dousnl.test;

import com.dousnl.api.domain.User;

public class Test_5 {
	
	static int r=0;
	
	public static void main(String[] args) {
		int a=10;
		System.out.println(a);
		change(r);
		User u=new User();
		change1(u);
		System.out.println(r);
	}

	private static void change(int a) {
		a=50;
	}
	private static void change1(User a) {
		a.setAge(50);;
	}

}
