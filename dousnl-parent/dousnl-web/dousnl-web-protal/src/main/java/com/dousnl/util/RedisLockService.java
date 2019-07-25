package com.dousnl.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisLockService {

	@Autowired
    private RedisDistributionLock redisDistributionLock;
	@Autowired
    private RedisLockTool redisLockTool;
	
	int count=0;
	
	public void kill(){
		count++;
		System.out.println("测试count:"+count);
		boolean getLock = redisDistributionLock.lock("gaq", 10 * 10000);
		if(getLock){
			count++;
			System.out.println("测试count:"+count);
		}
		redisDistributionLock.unlock("gaq");
		
	}

}
