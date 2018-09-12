package org.dousnl.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dousnl.shiro.domain.User;

public class Test_3 {

	public static void main(String[] args) {
		User u=new User();
		u.setId(1);
		String a = null;
		System.out.println("aaa".length());
		System.out.println(StringUtils.isNotEmpty(u.getPassword()));
		
		/**
		 * list判断空
		 * 
		 * ArrayList<Person> list = null;  
         * System.out.println(null == list);//return true  
         * System.out.println(list.isEmpty());// null point error  
         * 
         * ArrayList<Person> list = new ArrayList<Person>();
         * System.out.println(list.isEmpty());//true
         * System.out.println(list==null);//false 
         * 
         * 结论：判空的顺序：
         * if(null != list && !list.isEmpty()){  
         *       //code 
         * }
         * 
		 */
		System.out.println("====================");
        List<String> list=null;
        //System.out.println(list.isEmpty());
        
        ArrayList<String> list2 = new ArrayList<String>();
        System.out.println(list2==null);
        
	}

}
