package org.dousnl.test;

import java.util.HashMap;
import java.util.Map;

public class Test_2 {

	public static void main(String[] args) {
		System.out.println(2-(-1*2));
        Test_init init=new Test_init();
        
	    //Test_init init=new Test_init();
		//List<String> documentsTypes2 = Test_init.documentsTypes;
	    init.say();
	    Map<String,String> map=new HashMap<String,String>();
	    map.put("aaa", "1");
	    String bbb=(String)map.get("bbb");
	    /*if(init.getName().equals("")){
	    	System.out.println("校验....");
	    }*/
	    String bbb1=(String)null;
	    System.out.println(bbb1);
	}

}
