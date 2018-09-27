package com.dousnl.thread;

import com.dousnl.thread.pool.SyncDomain;

public class MyThread1 extends Thread{
	
	private ThreadTest3 u;
	
	private SyncDomain s;
	
	int count;
	
	int age;
	
	public MyThread1(SyncDomain s) {
		this.s = s;
	}
	public MyThread1(ThreadTest3 u){
		this.u=u;
	}
	@Override
	public void run() {
		//u.option(10);
		s.Sync();
	}
	
	public int getI(){
		return 0;
	}
}