package org.dousnl.shiro.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AbstractTest {

	@BeforeClass
	public static void beforeClass(){
		System.out.println("=========beforeClass========");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("=========afterClass========");
	}
	@Before
	public void before(){
		System.out.println("-----before-----");
	}
	@After
	public void after(){
		System.out.println("-----after-----");
	}
	@Test
	public void test2(){
		UserServiceAbstractImpl test=new UserServiceAbstractImpl();
	    System.out.println("test2 result:"+test.Test(5));
	}
	@Test
	public void test1(){
		UserServiceAbstractImpl test=new UserServiceAbstractImpl();
	    System.out.println("test1 result:"+test.Test(6));
	}
	@Test
	public void test3(){
		UserServiceAbstractImpl test=new UserServiceAbstractImpl();
	    System.out.println("test3 result:"+test.Test(0));
	}
	/*public static void main(String[] args) {
		UserServiceAbstractImpl test=new UserServiceAbstractImpl();
	    System.out.println("test result:"+test.Test());
	}*/
}
