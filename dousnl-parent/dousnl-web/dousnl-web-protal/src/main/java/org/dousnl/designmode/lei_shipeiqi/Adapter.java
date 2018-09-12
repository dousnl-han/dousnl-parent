package org.dousnl.designmode.lei_shipeiqi;

/**
 * 设计模式--类适配器模式
 * 
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。首先，我们来看看类的适配器模式，先看类图：
 * 
 * 核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口时Targetable，
 * 通过Adapter类，将Source的功能扩展到Targetable里，看代码：
 * 
 * @author hanliang
 *
 */
public class Adapter extends Source implements Targetable{

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

}
