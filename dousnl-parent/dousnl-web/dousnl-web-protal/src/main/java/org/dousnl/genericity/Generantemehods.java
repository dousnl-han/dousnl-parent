package org.dousnl.genericity;

/**
 * @author Fairyland
 * 泛型方法
 */
public class Generantemehods {

	public <T> void f(T x){
		System.out.println(x.getClass().getName());
	}
	
	public static void main(String[] args) {
		Generantemehods gm=new Generantemehods();
	    gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0f);
		gm.f(gm);
	}
}
