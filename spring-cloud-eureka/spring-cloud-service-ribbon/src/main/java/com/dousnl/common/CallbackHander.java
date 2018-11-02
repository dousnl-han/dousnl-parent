package com.dousnl.common;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.exception.FallbackInvocationException;

public class CallbackHander extends FallbackInvocationException{

	@HystrixCommand(fallbackMethod="")
	public void testFbs(){
		
	}
}
