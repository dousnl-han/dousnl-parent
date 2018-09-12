package org.dousnl.genericity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hanliang
 * 简单泛型
 * （1）泛型的类型参数只能是类类型（包括自定义类），不能是简单类型。（2）泛型的类型参数可以有多个。
 * （3）不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
 * （4）不能创建一个确切的泛型类型的数组。下面使用Sun的一篇文档的一个例子来说明这个问题：
 * 
 * java 中的instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例。
 * instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。
 */
public class Holder<T> {

	private T t;
	
	public Holder(T t){
		this.t=t;
	}
	/**
	 * 通配符
	 * @param a
	 */
	public void add(List<?> a){
		
	}
	/**
	 * 通配符上限，写法
	 * @param a
	 */
    public void addUp(List<? extends Holder> a){
		
	}
    /**
	 * 通配符下限，写法
	 * @param a
	 */
    public void addDown(List<? super Holder> a){
		
	}
	public void setT(T t){
		this.t=t;
	}
	public T getT(){
		return t;
	}
	
	public static void main(String[] args) {
		Holder<Car> h=new Holder<Car>(new Car());
		Car car = h.getT();
		car.run();
		List<?>[] lsa = new List<?>[10]; 
		
		if(h instanceof Holder<?>){
			System.out.println("true");
		}
		
		Object o = lsa;    
		Object[] oa = (Object[]) o;    
		List<Integer> li = new ArrayList<Integer>();    
		li.add(new Integer(3));    
		oa[1] = li; // Unsound, but passes run time store check    
		Integer s = (Integer) lsa[1].get(0);
		System.out.println(s);
		

	}
}
