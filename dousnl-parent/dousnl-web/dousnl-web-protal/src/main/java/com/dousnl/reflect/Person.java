package com.dousnl.reflect;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author hanliang
 * 反射
 */
public class Person {

	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) throws Exception{
		Person person=new Person("zhangsan",20);
		Class<? extends Person> class1 = person.getClass();
		Field[] fields = class1.getDeclaredFields();
		Method[] methods = class1.getMethods();
		for (Field f : fields) {
			String key = f.getName();
			PropertyDescriptor descriptor=new PropertyDescriptor(key, class1);
			Method readMethod = descriptor.getReadMethod();
			System.out.println("得到属性名："+key+" 属性值："+readMethod.invoke(person));
			Class<?> type = f.getType();
			System.out.println("type.getName():"+type.getName());
			System.out.println("type.getSimpleName():"+type.getSimpleName());
			if("int".equals(type.getSimpleName())){
				Method writeMethod = descriptor.getWriteMethod();
				writeMethod.invoke(person, 60);
				System.out.println("写入年龄："+person.getAge());
			}
		}
		for (Method m : methods) {
			String key = m.getName();
			if("setage".equals(m.getName().toLowerCase())){
				System.out.println("得到方法名："+key);
				Object invoke = m.invoke(person, 50);
				System.out.println("invoke.set:"+invoke);
			}
			if("getage".equals(m.getName().toLowerCase())){
				System.out.println("得到方法名："+key);
				System.out.println("invoke.get:"+m.invoke(person));
			}
		}
		System.out.println("反射set age结果："+person.getAge());
	}
}
