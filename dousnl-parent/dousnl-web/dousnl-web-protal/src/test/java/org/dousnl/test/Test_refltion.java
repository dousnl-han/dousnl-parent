package org.dousnl.test;

import org.dousnl.shiro.domain.User;
import org.dousnl.util.Reflections;

import com.alibaba.fastjson.JSON;

public class Test_refltion {
	
	public static void main(String[] args) {
		User u=new User();
		u.setId(1);
		u.setUsername("zhang");
		Object invokeGetter = Reflections.invokeGetter(u,"username");
		Reflections.invokeSetter(u, "password", "1234");
		Object fieldValue = Reflections.getFieldValue(u,"username");
		System.out.println("invokeGetter:"+invokeGetter.toString());
		System.out.println("fieldValue:"+fieldValue.toString());
		System.out.println("invokeSetter:"+JSON.toJSONString(u));
	}

}
