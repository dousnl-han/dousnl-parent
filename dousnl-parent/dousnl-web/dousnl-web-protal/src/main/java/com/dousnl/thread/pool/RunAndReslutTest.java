package com.dousnl.thread.pool;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunAndReslutTest {

	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		ArrayList<Future<String>> list=new ArrayList<Future<String>>();
		for(int i=0;i<3;i++){
			list.add(exec.submit(new RunAndResult(i)));
		}
        for(Future<String> fs:list){
        	try {
				System.out.println(fs.get());
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				exec.shutdown();
			}
        }
	}

}
