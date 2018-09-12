package org.dousnl.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaGenerics {

	/**
	 * 传递参数--实例
	 * @param t
	 * 返回实例对象
	 * @return
	 */
	public<T> T getDefualt(T t){
		return t;
	}
	
	/**
	 * 传递参数--类
	 * @param e
	 * 返回class对象
	 * @return
	 */
	public<T> Class<T> getDefualtClass(Class<T> e){
		return e;
	}
	public static void main(String[] args) {
		JavaGenerics gen=new JavaGenerics();
		Class<JavaGenerics> defualtClass = gen.getDefualtClass(JavaGenerics.class);
		System.out.println(defualtClass.getSimpleName());
		/**
		 * 固定数量线程池
		 */
		ExecutorService service=Executors.newFixedThreadPool(5);
		GenericsRun run=new GenericsRun(gen);
		for(int i=0;i<4;i++){
			service.execute(run);
		}
	}
	
	/**
	 * 静态内部类
	 */
	static class Generics{
		
		/**
		 * 单例对象
		 */
		private static Generics genbean=new Generics();
		
		public void testGener(){
			System.out.println("test generics...."+genbean.hashCode());
		}
		
		/**
		 * 返回单例--实例
		 * @return
		 */
		public static Generics getSingle(){
			return genbean;
		}
	}
	
	/**
	 * 静态内部线程类
	 */
	static class GenericsRun implements Runnable{
		
		private JavaGenerics g;
		
		public GenericsRun(JavaGenerics g) {
			this.g=g;
		}

		@Override
		public void run() {
			Generics defualt = g.getDefualt(Generics.getSingle());
			defualt.testGener();
			int hashCode = defualt.hashCode();
			//System.out.println(hashCode);
			System.out.println(defualt.getClass().getSimpleName());
		}
		
	}
}
