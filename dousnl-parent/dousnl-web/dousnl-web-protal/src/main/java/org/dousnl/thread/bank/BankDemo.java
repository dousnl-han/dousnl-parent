package org.dousnl.thread.bank;

public class BankDemo {
	
	 public static void main(String[] args) {

	        Bank bank=new Bank();
	        Man man1=new Man(bank);
	        man1.start();
	        Man man2=new Man(bank);
	        man2.start();
	        Man man3=new Man(bank);
	        man3.start();
	    }
	}

	//线程类
	class Man extends Thread{
	    private Bank bank=null;

	    public Man(Bank bank){
	        this.bank=bank;
	    }

	    @Override
	    public void run() {
	        bank.getMoney(400);
	    }
	}