package com.dousnl.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

	@Pointcut(value = "within(com.dousnl.web.**.*)")
    public void aopDemo() {

    }
}
