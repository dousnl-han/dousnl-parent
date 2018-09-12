package org.dousnl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.util.StringUtils;


/**
 * @author hanliang
 * @date 2016年11月3日
 * @description DateUtils 转换类
 * @return DateUtils
 */
public class DateUtils {
 
	private static final String DEFAULT_FORMAT="yyyy-MM-dd hh:mm:ss";
	private static final String DATE_FORMAT="yyyy-MM-dd";
	
	public static Date strTodate(String time,String format){
		if(StringUtils.isEmpty(time))
			return null;
		format=StringUtils.isEmpty(format) ? format : DEFAULT_FORMAT;
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		Date date=null;
		try {
			date=sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;		
	}
	
	public static String dateToString(Date date,String format){
		format=StringUtils.isEmpty(format) ? DEFAULT_FORMAT : format;
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		String dateFormat=sdf.format(date);
		return dateFormat;
	}
}
