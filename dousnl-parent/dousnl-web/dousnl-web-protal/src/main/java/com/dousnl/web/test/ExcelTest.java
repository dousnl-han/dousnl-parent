package com.dousnl.web.test;

import java.util.ResourceBundle;

public class ExcelTest {
	
	public static ResourceBundle file_rb=ResourceBundle.getBundle("file");
	
	/*public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Fruit> list = new ArrayList<Fruit>();  
        list.add(new Fruit("ƻ��",2.01f));  
        list.add(new Fruit("����",2.05f));
        String templateFileName = file_rb.getString("template.path")+"template.xls";
        System.out.println("template.path:"+file_rb.getString("template.path"));
        System.out.println("download.path:"+file_rb.getString("download.path"));
        String resultFileName = file_rb.getString("download.path")+"fruit.xls";  
        templateFileName="com/org/dl/template/template.xls";
        resultFileName="com/org/dl/result/fruit.xls";
        new ExcelUtil().createExcel(templateFileName,list,resultFileName);
		//Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++)
        {
            //Random r = new Random(System.currentTimeMillis());
        	 Random r = new Random();
            System.out.println(r.nextInt());
        }
        Method[] methods=Fruit.class.getMethods();
        //Method m=Fruit.class.getDeclaredMethod("setName","3e23");
		//m.invoke(Fruit.class, "123123");
		//System.out.println(Fruit.class.getName());
        //System.out.println("aaa:");
        Method setMethod = null; // ԴBean�е����Ե�set����  
        Method getMethod = null; // ԴBean�е����Ե�get���� 
        System.out.println(new Fruit().getName());
        System.out.println(Fruit.class.getName());
        for(Method s:methods){
        	if("getName".equals(s.getName())){
        		//getMethod=Fruit.class.getMethod("getName", s.getParameterTypes());
        		//new Fruit().getClass().getMethod("setName", "wqdqwd");
        		Object item=s.invoke(new Fruit(), null);
        		System.out.println("method1:"+item);
            	//s.invoke(Fruit.class, null);
            	//System.out.println("method:"+new Fruit().getName());
        	}
        }
	}*/

}
