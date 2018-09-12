package org.dousnl.test;

import org.dousnl.api.domain.User;

public class Test_4 {
	
	public static void 打印(){
		System.out.println("da yin ");
	}
	
	public static void main(String[] args) {
		/*User u=new User();
		u.setAge(1);
		User u2=u;
		u2.setAge(5);
		System.out.println("u.age="+u.getAge());
		System.out.println("u2.age="+u2.getAge());*/
		
		System.gc();
		int a=-6;
		String aa="";
		for(int i=0;i<32;i++){
			int t=(a & 0x80000000>>>i)>>>(31-i);
			System.out.println("t:"+t);
			aa+=t;
		}
		System.out.println("aa:"+aa);
		
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024+"M");
		Long mer=2794455040L;
		Long x=1024L*1024L;
		
		System.out.println(mer/x);
		
		System.out.println("freeMemory:"+Runtime.getRuntime().freeMemory()/1024.0/1024+"M");
		System.out.println("totalMemory:"+Runtime.getRuntime().totalMemory()/1024.0/1024+"M");
		
	}

}
