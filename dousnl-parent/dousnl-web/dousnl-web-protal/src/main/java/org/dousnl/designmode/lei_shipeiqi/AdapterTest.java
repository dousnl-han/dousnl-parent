package org.dousnl.designmode.lei_shipeiqi;

/**
 * 设计模式--类适配器模式
 * @author hanliang
 *
 */
public class AdapterTest {

	public static void main(String[] args) {
		Targetable targetable=new Adapter();
		targetable.method1();
		targetable.method2();
	}

}
