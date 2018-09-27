package com.dousnl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.beanutils.BeanUtils;
import com.dousnl.api.domain.Person;
import com.dousnl.api.domain.User;

public class BeanCopyUtil {

	public static void main(String[] args) throws Exception {
		Person p=new Person();
		p.setId(1);
		p.setName("zhangsan");
		p.setBrith(new Date());
		p.setMoney(60.6);
		User u=new User();
		u.setAge(18);
		u.setBrith(new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-01"));
		u.setMoney(10.2);
		try {
			BeanUtils.copyProperties(u, p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("p.getAge:"+p.getAge());
		System.out.println("userAge:"+u.getAge()+"--userName:"+u.getName()
		+"--userBrith:"+new SimpleDateFormat("yyyy-MM-dd").format(u.getBrith())+"--userMoney:"+u.getMoney());
	    //反射调用get方法
		Object invokeGetter = Reflections.invokeGetter(p, "name");
		System.out.println("invokeGetter:"+invokeGetter.toString());
		//反射调用set方法
		Reflections.invokeSetter(p, "name", "lisi");
		Object invokeGetter1 = Reflections.invokeGetter(p, "name");
		System.out.println("invokeGetter1:"+invokeGetter1.toString());
	}
}
