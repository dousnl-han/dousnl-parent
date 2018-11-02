package com.dousnl.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import com.codingapi.tx.dubbo.interceptor.TxManagerInterceptor;

/**
 * Created by lorne on 2017/6/28.
 */
/*@Aspect
@Component*/
public class TxTransactionInterceptor  implements Ordered{

    @Autowired
    private TxManagerInterceptor txManagerInterceptor;

    @Override
    public int getOrder() {
        return 1;
    }

    @Around("execution(* com.dousnl.service.impl.*Impl.*(..))")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        return txManagerInterceptor.around(point);
    }
}