package org.dousnl.thread.bank;

public class Bank {

	private int money=500;
    public synchronized boolean getMoney(int num){
        if (num<0) {
            //取钱的数目要大于0
            System.out.println("输入错误！");
            return false;
        }else if (num>money||money<0) {
            //判断余额是否足够
            System.out.println("余额不足！");
            return false;
        }else {
            try {
                //模拟取钱时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("取款："+num+"余额为"+(money-num));
            money-=num;
            return true;
        }
    }
}
