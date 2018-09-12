package org.dousnl.thread;

import java.util.Random;

public class ThreadLocalHolder {

	private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
		private Random rand=new Random(47);
		protected  synchronized Integer initialValue(){
			return rand.nextInt(10000);
		}
	};
	public static void main(String[] args) {
		System.out.println(ThreadLocalHolder.value.get());
	}
}
