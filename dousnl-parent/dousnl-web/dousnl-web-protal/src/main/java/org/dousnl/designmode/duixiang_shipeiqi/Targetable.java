package org.dousnl.designmode.duixiang_shipeiqi;

/**
 * 设计模式--对象适配器模式
 * 
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，
 * 而是持有Source类的实例，以达到解决兼容性的问题。
 * 
 * @author hanliang
 *
 */
public interface Targetable {
	
	public void method1();
	
	public void method2();

}
