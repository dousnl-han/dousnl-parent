package org.dousnl.thread.pool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.dousnl.thread.MyThread1;
import org.dousnl.thread.ThreadTest3;

public class CachedThreadPool {

	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();//带缓存线程池
		//ExecutorService exec=Executors.newFixedThreadPool(5);//固定数量线程池
		//ExecutorService exec=Executors.newSingleThreadExecutor();//单一线程
		@SuppressWarnings("unused")
		ThreadTest3 u=new ThreadTest3();
		long start = System.currentTimeMillis();
		System.out.println("start:"+start);
		for(int i=0;i<30;i++){
				SyncDomain s=SyncDomain.getInstance(i,i);
				exec.execute(new MyThread1(s));
		}
		exec.shutdown();
		long end = System.currentTimeMillis();
		System.out.println("end:"+end);
		System.out.println("time:"+(end-start)+"ms");
	}
	
	public static void method(List<String> list){
		System.out.println("111");
	}
	public static void method1(List<Integer> list){
		System.out.println("111");
	}
}
