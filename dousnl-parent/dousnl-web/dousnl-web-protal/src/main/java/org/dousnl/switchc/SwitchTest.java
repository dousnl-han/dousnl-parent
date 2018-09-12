package org.dousnl.switchc;

/**
 * @author Fairyland
 *
 *  :case穿透现象指的是： switch语句会根据表达式的值从相匹配的case标签处开始执行，
 *  一直执行到break语句处或者是switch语句的末尾。如果没有break语句，
 *  那么就会从表达式的值相匹配的case标签处开始执行，一直执行到switch语句的末尾，
 *  这种从其中的一个case处开始，忽略后面的值的匹配，直接运行case的内容的现象就是穿透的现象。
 */
public class SwitchTest {

	public static void main(String[] args) {
		int a=1;
		int b=0;
		int c=2;
		switch (a) {
		case 0:
			System.out.println("a:"+0);
			break;
        case 1:
        	System.out.println("a:"+1);
			break;
        case 2:
        	System.out.println("a:"+2);
			break;
		default:
			switch (b) {
			case 0:
				System.out.println("b:"+0);	
				break;
			case 1:
				System.out.println("b:"+1);
				break;
	        case 2:
	        	System.out.println("b:"+2);
				break;
	        case 3:
	        	System.out.println("b:"+3);
			}
		}
		
		switch (c) {
		case 1:
		case 2:
		case 3:{
			System.out.println("c:"+c);
		}break;
		default:
			break;
		}

	}

}
