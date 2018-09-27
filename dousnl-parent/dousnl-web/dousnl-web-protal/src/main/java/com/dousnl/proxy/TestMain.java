package com.dousnl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

public class TestMain {

	public static void main(String[] args) {
		/*//创建一个真正的对象
		final MyBusiness obj = new MyBusinessImpl();
//		//调用
//		obj.method1();
//		obj.method2();
		
		
		 * public static Object Proxy.newProxyInstance(ClassLoader loader,  类加载器(原对象的类加载器)
                                      Class<?>[] interfaces,                原对象实现的接口               
                                      InvocationHandler(接口) h)             如何处理客户端的一次调用
                               throws IllegalArgumentException
		 
		
		//生成一个代理对象
		MyBusiness proxy = (MyBusiness) Proxy.newProxyInstance(TestMain.class.getClassLoader(),   
				               obj.getClass().getInterfaces(), 
				               new InvocationHandler() {
								
								@Override
								public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
									//需求：在不改变源代码的情况下，重写method1
									if(method.getName().equals("method1")){
										//重写
										System.out.println("********** 在代理对象中，重写了method1 *************");
										return null;
									}else{
										//其他方法，直接调用真正的对象
										return method.invoke(obj, args);
									}
								}
							});
		
		
		//通过代理对象调用真正的对象
		proxy.method1();
		proxy.method2();*/
		float a1=0.06f;
		float b1=0.01f;
		System.out.println(a1+b1);
		 System.out.println(0.06+0.01);
	     System.out.println(1.0-0.42);
	     System.out.println(4.015*100);
	     System.out.println(303.1/1000);
	     
	     double f=1000.01;
	     BigDecimal a = new BigDecimal("1000.01");
	     double b=a.doubleValue();
	     System.out.println("a:"+a);
	     System.out.println(a.add(new BigDecimal("200.02")));
	     System.out.println(b);
	     
	     
	     
	     double g= 12.35;  
	     BigDecimal bigG1=new BigDecimal(g);
	     BigDecimal bigG2=new BigDecimal("12.35");
	     BigDecimal bigG=new BigDecimal("12.35").setScale(1, BigDecimal.ROUND_HALF_UP); //期望得到12.4

	     System.out.println("test G:"+bigG.doubleValue()); 
	     System.out.println("test G1:"+bigG1); 
	     System.out.println("test G2:"+bigG2); 
		
	}

}
















