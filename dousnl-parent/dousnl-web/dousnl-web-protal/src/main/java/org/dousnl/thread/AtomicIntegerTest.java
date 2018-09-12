package org.dousnl.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Fairyland
 * 原子性测试
 */
public class AtomicIntegerTest implements Runnable{

	private AtomicInteger i=new AtomicInteger(0);
	
	public int getValue(){
		return i.get();
	}
	private void evenIncrement(){
		 i.addAndGet(2);
	}
	@Override
	public void run() {
		while(true)
			evenIncrement();
	}

	public static void main(String[] args) {
	   new Timer().schedule(new TimerTask() {
		int i=0;
		@Override
		public void run() {
			i++;
			System.out.println("Aborting:"+i);
			//System.exit(0);
		}
	}, 3000,2000);
	ExecutorService exec=Executors.newCachedThreadPool();
	AtomicIntegerTest ac=new AtomicIntegerTest();
	exec.execute(ac);
	while(true){
		if(ac.getValue()%2!=0){
			System.out.println("奇数："+ac.getValue());
			System.exit(0);
		}
	}
	   
	}
	
	
	
	
	
}
