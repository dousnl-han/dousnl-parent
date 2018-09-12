package org.dousnl.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Fairyland
 * 一个类文件当中，只能有一个类是public 修饰的，
 * 然后如果再写一个类的话，默认是protected的修饰权限，
 * 一般这样安排的话是比较亲密的关系
 *
 */
public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch=new CountDownLatch(5);
		for(int i=0;i<5;i++){
			Thread th=new MyThread(i,latch);
			th.start();
		}
		latch.await(3,TimeUnit.SECONDS);
        System.out.println("此线程为主线程.....");
	}
}
class MyThread extends Thread{
	
	private int i;
	private CountDownLatch latch;
	public MyThread(int i,CountDownLatch latch) {
		this.i=i;
		this.latch=latch;
	}
	@Override
	public void run() {
		System.out.println("this is a thread test"+i);
		latch.countDown();
	}
}