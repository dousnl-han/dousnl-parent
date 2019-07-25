package com.dousnl.redis.fbslock;

import com.dousnl.util.RedisDistributionLock;
import com.dousnl.util.RedisLockTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Bank {

    @Autowired
    private RedisDistributionLock redisDistributionLock;
    @Autowired
    private RedisLockTool redisLockTool;

    private static int sum = 200;

    /**
     * 给银行个启动资金，不然怎么干生意呢。
     */
    //这个从来不这么用，但也算是正确的一种加锁的机制：同步代码块。
    //Object obj = new Object();

    /**
     * 存钱
     * 要是不加[synchronized--同步函数],则会出现多线程安全问题。
     *
     * @throws InterruptedException 12345
     */
    public void add(int n) throws InterruptedException {
        //redisDistributionLock.lock("qps", 10000*10);

        String uuid = UUID.randomUUID().toString();
        if (sum <= 0) {
            redisLockTool.releaseLock("qps", uuid);
            throw new RuntimeException("已无库存....");
        }
        boolean setLock = redisLockTool.setLock("qps", uuid, 10000 * 10);
        if (!setLock) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                setLock = redisLockTool.setLock("qps", uuid, 10000 * 10);
                if (setLock) {
                    break;
                } else {
                    count++;
                    if (count > 9) {
                        throw new RuntimeException("人太多了，换个姿势再试试~");
                    }
                }
            }
        }
        int originalSum = sum;
        sum = sum - n;
        if (sum < 0) {
            redisLockTool.releaseLock("qps", uuid);
            throw new RuntimeException("已无库存....");
        }
        try {
            Thread.sleep(10);
        } catch (Exception ignore) {
        }
        //当存钱次数变多的时候，就可以发现，存钱的线程确实是2个在交替执行存钱这个动作的。
        System.out.println(Thread.currentThread().getName() + "..originalSum=" + originalSum + "...sum=" + sum);
        //redisDistributionLock.unlock("qps");
        redisLockTool.releaseLock("qps", uuid);
    }

    /**
     * 取钱
     * 要是不加[synchronized--同步函数],则会出现多线程安全问题。
     */
    public void reduce(int n) {
        redisDistributionLock.lock("qps", 10000 * 10);
        String uuid = UUID.randomUUID().toString();
        //redisLockTool.setLock("qps", uuid, 10000*10);
        if (sum - n >= 0) {
            sum = sum - n;
        } else {
            System.out.println("bank's money is not enough !");
        }
        try {
            Thread.sleep(30);
        } catch (Exception ignore) {
        }
        //当存钱次数变多的时候，就可以发现，存钱的线程确实是2个在交替执行存钱这个动作的。
        System.out.println(Thread.currentThread().getName() + "...sum=" + sum);
        redisDistributionLock.unlock("qps");
        //redisLockTool.releaseLock("qps", uuid);
    }
}
