package com.dousnl.spring.security.common;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LogAspect {

	
	public void doLog(JoinPoint jp){

		Class<?> aClass = jp.getTarget().getClass();
		MethodSignature signature = (MethodSignature)jp.getSignature();
		Method method = signature.getMethod();
		Class<?> clazz = method.getDeclaringClass();
		if(aClass.isAnnotationPresent(slfj.class)){
			slfj slfj = clazz.getAnnotation(slfj.class);
			String value = slfj.value();
			System.out.println("日志value:"+value);
			//Logger logger = slfjLoggerFactory.getLogger(clazz.getName());
		}
	}
}
