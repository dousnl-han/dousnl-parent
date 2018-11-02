package com.dousnl.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest extends Thread {
    Semaphore position;
    private int id;
    public SemaphoreTest(int i, Semaphore s) {
        this.id = i;
        this.position = s;
    }
    public void run() {
        try {
            if (position.availablePermits() > 0) {
                System.out.println("顾客[" + id + "]进入厕所，有空位");
            } else {
                System.out.println("顾客[" + id + "]进入厕所，没空位，排队");
            }
            position.acquire(); 
            System.out.println("【" + id + "】acquire坑位");
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println("【" + id + "】完毕release");
            position.release(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String args[]) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Semaphore position = new Semaphore(2);    // 初始化两个空位
        for (int i = 0; i < 5; i++) {
            pool.submit(new SemaphoreTest(i, position));
        }
        System.out.println("开始释放线程池资源");
        //pool.shutdown();
        if (1==1) return;
        System.out.println("完成释放线程池资源");
        position.acquireUninterruptibly(2);  
        System.out.println("如厕完毕，清理厕所");
        position.release(2);  
    }
}
