package org.dousnl.extend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class ChildClass extends SuperClass {

	public ChildClass() {
		System.out.println("child constructor");
	}
	
	public static void StaticNomal(){
		System.out.println("static nomal");
	}
	
	public void Nomal(){
		System.out.println("nomal");
	}
	
	public void NomalGen(){
		System.out.println("nomal gen");
	}
	
	public static void main(String[] args) {
		
		ChildClass child=new ChildClass();
		child.Nomal();
		System.out.println("******************");
		child.NomalGen();
		//ChildClass.StaticNomal();
		
		ChildClass child2=new ChildClass();
		String name2 = SuperClass.name;
		String flag2 = child2.flag;
		
		System.out.println("name2:"+name+"flag2"+flag2);
		int[] array={1,2,3,4};
		//List<String> l=new ArrayList<String>();
		List<Integer> list=(List) Arrays.asList(array);
		if(!CollectionUtils.isEmpty(list)){
			for(Integer i:list)
				System.out.println(i);
		}
		/*list.stream().forEach(p ->{
			System.out.println("i=>"+p);
		});*/
	}
}
