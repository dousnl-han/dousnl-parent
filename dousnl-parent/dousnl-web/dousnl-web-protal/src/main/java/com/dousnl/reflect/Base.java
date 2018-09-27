package com.dousnl.reflect;

import java.lang.reflect.Field;

public class Base {

	static int num=1;
	
	static{
		System.out.println("Base "+num);
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person person=new Person("zhangsan",20);
		Object invokeGetter = Reflections.invokeGetter(person, "name");
		System.out.println("getter:"+invokeGetter);
		Reflections.invokeSetter(person, "age", 30);
		Object invokeGetterAge = Reflections.invokeGetter(person, "age");
		System.out.println("getterAge:"+invokeGetterAge);
		Object fieldValue = Reflections.getFieldValue(person, "age");
		System.out.println(fieldValue);
		//System.out.println(accessibleField);
	}
}
