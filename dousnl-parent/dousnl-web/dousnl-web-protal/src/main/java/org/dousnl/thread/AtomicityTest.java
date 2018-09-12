package org.dousnl.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huaox on 2017/4/19.
 */

class TestA implements Runnable{
    private  int i=0;
    synchronized int get(){return i;}  //此时不是同步方法
    synchronized void add(){i++;i++;}
    @Override
    public void run() {
        while (true){
            add();
            System.out.println(i);
        }
    }
}

public class AtomicityTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        TestA a = new TestA();
        service.execute(a);
        while (true) {
            int val = a.get();
            if(val%2 != 0){
                System.out.println("奇数:"+val);
                System.exit(0);
            }
        }
    }

}