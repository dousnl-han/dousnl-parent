/**
 * @description TODO
 * @author 56096
 * @date 2018��9��18��
 */
package org.dousnl.test;

import java.math.BigDecimal;

import com.alibaba.dubbo.common.utils.StringUtils;


/**
 * @description TODO
 * @author 56096
 * @date 2018��9��18��
 */
public class BigDecimalDivTest {

	/**
	 * @param args
	 * 2018��9��18��
	 */
	public static void main(String[] args) {
		BigDecimal a=BigDecimal.ZERO;
		BigDecimal b=BigDecimal.ZERO;
		BigDecimal c=null;
		if(c==null){
			System.out.println("null");
		}
		if(c!=null && c.compareTo(BigDecimal.ZERO)==0){
			System.out.println("zero");
		}else{
			System.out.println(a.divide(b,6,BigDecimal.ROUND_HALF_UP));
			System.out.println(a.divide(b,6,BigDecimal.ROUND_HALF_UP));
		}
	}

}
