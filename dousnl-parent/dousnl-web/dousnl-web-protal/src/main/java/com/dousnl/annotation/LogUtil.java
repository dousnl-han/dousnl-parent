package com.dousnl.annotation;

import java.lang.reflect.Method;

public class LogUtil {

	public static void log(Class<?> clazz){
		//Class<?> targetClass = clazz.getDeclaringClass();
		if(clazz.isAnnotationPresent(LogConfig.class)){
			Method[] methods = clazz.getMethods();
			for(Method m:methods){
				if(m.isAnnotationPresent(Log.class)){
					Log log = m.getAnnotation(Log.class);
					System.out.println("Log-name:"+log.value());
					System.out.println("Log-moudleName:"+log.name());
					System.out.println("Log-level:"+log.level());
				}
			}
			LogConfig annotation = clazz.getAnnotation(LogConfig.class);
			System.out.println("LogConfig-name:"+annotation.systemType());
			System.out.println("LogConfig-value:"+annotation.moudle());
			
			System.out.println(clazz+"==包含日志=="+LogConfig.class);
		}
	}
	
	public static void main(String[] args) {
		LogUtil.log(LogTest.class);
	}
}
