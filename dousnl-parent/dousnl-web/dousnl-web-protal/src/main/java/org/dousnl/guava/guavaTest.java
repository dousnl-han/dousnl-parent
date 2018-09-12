package org.dousnl.guava;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class guavaTest {

	public static void main(String[] args) {
		List<Integer> list=Lists.newArrayList(1,2,3);
		ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");
		System.out.println(JSON.toJSON(list));
		System.out.println(JSON.toJSON(of));
		String testString = "foo , what,,,more,";
		Iterable<String> split = Splitter.on(",").omitEmptyStrings().trimResults().split(testString);
		System.out.println(JSON.toJSON(split));
		Integer a=3;
		if(1==a){
			System.out.println(1);
		}if(2==a){
			System.out.println(2);
		}if(3==a){
			System.out.println(3);
		}
	}

}
