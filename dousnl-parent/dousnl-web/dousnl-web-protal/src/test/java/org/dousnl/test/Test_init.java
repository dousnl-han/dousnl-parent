package org.dousnl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test_init {
	
	public  List<String> documentsTypes;
	
	public int a=1;
	
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*static {
		documentsTypes.add("1");
		documentsTypes.add("2");
		documentsTypes.add("3");
		documentsTypes.add("4");
		System.out.println("=====init======");
	}*/
	public void init(){
		documentsTypes= getDocumentsTypes();
		System.out.println("=====init======");
	}

	public List<String> getDocumentsTypes() {
		List<String> documentsTypes = new ArrayList<String>();
		documentsTypes.add("1");
		documentsTypes.add("3");
		documentsTypes.add("2");
		documentsTypes.add("4");
		return documentsTypes;
	}

	public void say(){
		init();
		for(String s:documentsTypes){
			System.out.println("===>"+s);
		}
	}
}
