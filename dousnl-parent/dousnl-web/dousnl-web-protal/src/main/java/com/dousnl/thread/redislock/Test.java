package com.dousnl.thread.redislock;

public class Test {
	private Service service;
	
	public static void main(String[] args) {
		Service service = new Service();
        for (int i = 0; i < 50; i++) {
        	Test test=new Test();
        	Test.ThreadA threadA =test.new ThreadA(service);
            threadA.start();
        }
	}
	
	 class ThreadA extends Thread {
	    

	    public ThreadA(Service service) {
	        service = service;
	    }

	    @Override
	    public void run() {
	        service.seckill();
	    }
	}
}
