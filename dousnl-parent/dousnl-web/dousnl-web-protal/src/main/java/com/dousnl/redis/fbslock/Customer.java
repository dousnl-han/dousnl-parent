package com.dousnl.redis.fbslock;

import java.util.concurrent.CountDownLatch;

public class Customer implements Runnable {

	  /** 
	   * 存钱类型 
	   */
	    static final String TYPE_ADD = "add";
	    /** 
	   * 取钱类型 
	   */
	    static final String TYPE_REDUCE = "reduce";
	  /** 
	   * 银行 
	   */
	    private Bank bank;
	    /** 
	   * 对钱的操作类型，存钱or取钱 
	   */
	    private String type;
	    /** 
	   * 操作的次数，理论上是个正数 
	   */
	    private int time;
	    /** 
	   * 要存或者取多少钱 
	   */
	    private int money;
	    
	    private CountDownLatch beginCount;
	    
	    private CountDownLatch endCount;
	    
	    public Customer(Bank bank, String type, int time, int money, CountDownLatch beginCount, CountDownLatch endCount) {
	        this.bank = bank;
	        this.type = type;
	        this.time = time;
	        this.money = money;
	        this.beginCount=beginCount;
	        this.endCount=endCount;
	    }
	    @Override
	      public void run() {
	        /*for (int x = 0; x < time; x++) {
	            if (TYPE_ADD.equals(type)) {
	                try {
						bank.add(money);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            } else if (TYPE_REDUCE.equals(type)) {
	                bank.reduce(money);
	            }
	        }*/
	    	try {
	    		//beginCount.await();
				bank.add(money);
				endCount.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }

}
