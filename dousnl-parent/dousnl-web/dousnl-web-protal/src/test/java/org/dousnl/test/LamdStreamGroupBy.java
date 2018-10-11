package org.dousnl.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dousnl.shiro.domain.User;


/**
 * @description TODO
 * @author 56096
 * @date 2018��9��28��
 */
public class LamdStreamGroupBy {

	
	public static void main(String[] args) {
		
		List<User> list=new ArrayList<User>();
		User u=new User(6240,"","u");
		User u1=new User(21223,"","u1");
		list.add(u);
		list.add(u1);
		List<User> results = new ArrayList<User>();
		Map<String, Map<Integer, List<User>>> collect = list.stream()
				.collect(Collectors.groupingBy(User::getUsername,Collectors.groupingBy(User::getId)));
		collect.forEach((workNo,lists) ->{
			lists.forEach((roleId,result) -> {
				results.add(result.stream().collect(Collectors.maxBy(Comparator.comparing(User::getId))).get());
				
			});
		});
	}
}
