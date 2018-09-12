package org.dousnl.util;

import java.util.Date;

public class DateUtiTest {

	public static void main(String[] args) {
		String maticDate=null;
		//if(null!=maticDate && !"".equals(maticDate)){
            // 设置日期转化成功标识
            boolean dateflag=false;
            boolean dateflagNew=false;
            boolean dateflagTwo=false;
            try {
    			Date parseDate=DateUtil.parse(maticDate,"yyyy-MM");
    			System.out.println(DateUtil.format(parseDate, "yyyy-MM"));
    		} catch (Exception e) {
    			dateflag=true;
    			System.out.println("理财对账信息参数：{'FLAGE':'F','MSG':'"+maticDate+"日期格式yyyy-MM有误'}");
    		}
            try {
            	Date parseDate2=DateUtil.parse(maticDate,"yyyy/MM");
            	System.out.println(parseDate2);
			} catch (Exception e) {
				dateflagNew=true;
				System.out.println("理财对账信息参数：{'FLAGE':'F','MSG':'"+maticDate+"日期格式yyyy/MM有误'}");
			}
            try {
            	Date parseDate3=DateUtil.parse(maticDate,"yyyy.MM");
            	System.out.println(parseDate3);
			} catch (Exception e) {
				dateflagTwo=true;
				System.out.println("理财对账信息参数：{'FLAGE':'F','MSG':'"+maticDate+"日期格式yyyy.MM有误'}");
			}
            if(dateflag || dateflagNew || dateflagTwo){
            	System.out.println("效验通过");
            }
        //}

	}

}
