package com.dousnl.redis.fbslock;

import com.dousnl.SpringBootAppcation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/** 
 * 银行存钱的多线程实例 
 * <p> 
 * 【需求：】 
 * 银行有一个金库。 
 * 有两个储户分别存或者取n * 100。 
 * 目的：该程序是否有安全问题，如果有，如何解决？ 
 * <p> 
 * 【如何找问题：】 
 * 1，明确哪些代码是多线程运行代码。 
 * 2，明确共享数据。 
 * 3，明确多线程运行代码中哪些语句是操作共享数据的。 
 * 
 * @author lxk on 2017/6/26 
 */

/**
 * 此分布式锁..亲测通过
 * @author hanliang  
 * @date 2019年7月23日上午10:07:28
 * @version 1.0	
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAppcation.class)
public class Main {
	
	@Autowired
    private Bank bank;
	
	@Test
	public void bank() throws InterruptedException{
		//一个银行and多个客户 
        int time = 5;
        int money = 10;
        CountDownLatch beginCount = new CountDownLatch(1);
        CountDownLatch endCount = new CountDownLatch(50);
        //这个客户存钱 
        //Customer c1 = new Customer(bank, Customer.TYPE_ADD, time, money,beginCount,endCount);
        //这个客户取钱 
        /*Customer c2 = new Customer(bank, Customer.TYPE_ADD, time, money,beginCount,endCount);
        Customer c3 = new Customer(bank, Customer.TYPE_ADD, time, money,beginCount,endCount);
        Customer c4 = new Customer(bank, Customer.TYPE_ADD, time, money,beginCount,endCount);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();*/
        for (int i = 0; i < 50; i++) {
        	new Thread(new Customer(bank, Customer.TYPE_ADD, time, money,beginCount,endCount)).start();
		}
        //beginCount.countDown();
        endCount.await();
        System.out.println("执行结束....");
	}
	public static void main(String[] args) {
        //一个银行and多个客户 
        Bank bank = new Bank();
        int time = 5;
        int money = 100;
        //这个客户存钱 
        CountDownLatch beginCount = new CountDownLatch(1);
        CountDownLatch endCount = new CountDownLatch(3);
        //这个客户存钱 
        Customer c1 = new Customer(bank, Customer.TYPE_ADD, time, money,beginCount,endCount);
        //这个客户取钱 
        Customer c2 = new Customer(bank, Customer.TYPE_ADD, time, money,beginCount,endCount);
        Customer c3 = new Customer(bank, Customer.TYPE_ADD, time, money,beginCount,endCount);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        t1.start();
        t2.start();
        t3.start();
    }
}
