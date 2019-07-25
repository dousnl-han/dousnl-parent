package com.dousnl.util;

import com.dousnl.SpringBootAppcation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ${FILE_NAME}
 * @Package com.freemud.mail.core
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @author: aiqi.gong
 * @date: 2019/3/1 19:51
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAppcation.class)
public class TestRedis {
    @Autowired
    private RedisDistributionLock redisDistributionLock;
    @Autowired
    private RedisLockTool redisLockTool;
    @Autowired
    private RedisLockService redisLockService;
    
    int count=0;
    
    @Test
    public void testRedisTool() throws InterruptedException {
    	
    	
    	for(int i=0;i<200;i++){
    		new Thread(new Runnable() {
				
				@Override
				public void run() {
					String uuid = UUID.randomUUID().toString();
					boolean getLock = redisLockTool.setLock("gaw",uuid,10*10000);
					if(getLock){
						count++;
					}
					redisLockTool.releaseLock("gaw", uuid);
				}
			}).start();
    	}
    	Thread.sleep(10000 * 2);
    	System.out.println("测试完成count:"+count);
    }
    
    @Test
    public void testRedis() throws InterruptedException {
    	
    	for(int i=0;i<200;i++){
    		new Thread(new Runnable() {
				
				@Override
				public void run() {
					redisLockService.kill();
				}
			}).start();
    	}
    	Thread.sleep(10000 * 6);
    	System.out.println("测试完成count:"+count);
        boolean getLock = redisDistributionLock.lock("gaq", 10 * 10000);
        System.out.println(getLock);
        boolean getLock2 = redisDistributionLock.lock("gaq", 10 * 10000);
        System.out.println(getLock2);
        redisDistributionLock.unlock("gaq");
        getLock2 = redisDistributionLock.lock("gaq", 10 * 10000);
        System.out.println(getLock2);
    }
}
