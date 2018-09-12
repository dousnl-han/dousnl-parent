package org.dousnl.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * common date util .
 *
 */
public final class DateUtil {
	
	private static Calendar cal = Calendar.getInstance();
	
	/**
	 * get yesterday based on specific date . 
	 * @param format
	 * @return
	 */
	public static String getYesterday(String format,Date today){
		cal.setTime(today);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);
		return format(cal.getTime(), format);
	}
	/**
	 * get yesterday of current date 
	 * @param format
	 * @return
	 */
	public static String getYesterday(String format){
		cal.setTime(getCurrentTime());
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);
		return format(cal.getTime(), format);
	}

	/**
	 * get theDayBeforeYesterday of current date
	 * @param format
	 * @return
	 */
	public static String getTheDayBeforeYesterday(String format){
		cal.setTime(getCurrentTime());
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 2);
		return format(cal.getTime(), format);
	}
	
	/**
	 * fetching current time
	 *
	 * @return
	 */
	public static Date getCurrentTime() {

		return new Date();
	}

	/**
	 * fetch the Year of an dateStr
	 *
	 * @param dateStr
	 * @return
	 */
	public static String getYear(String dateStr) {

		return dateStr.substring(0, 4);
	}

	/**
	 * format date as special format .
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * parse a String date to Date type date .
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String dateStr, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(dateStr);
	}

	public static String getCurrentDate(String format) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(new Date());
	}


	/**
	 * 验证String字符串是否是合法日期型
	 * Authored by:	Cuniel
	 *
	 * @param argValue 日期字符串
	 * @return
	 */
	public static boolean isDate(String argValue) {
		boolean result = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date d = null;
		if (argValue != null && !argValue.equals("")) {
			if (argValue.split("/").length > 1) {
				dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			}
			if (argValue.split("-").length > 1) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
		} else {
			return false;
		}
		try {
			d = dateFormat.parse(argValue);
		} catch (Exception e) {
			result = false;
		}
		String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-9]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(argValue);
		boolean b = m.matches();
		if (b) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/***
	 * 验证字符串是否符合yyyyMMdd格式
	 * @param str
	 * @return
     */
	public static boolean isFormartDate(String str){
		java.text.SimpleDateFormat format=new java.text.SimpleDateFormat("yyyy-MM-dd");
		try{
			format.parse(str);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	 * 校验字符串是否符合指定格式(pattern)
	 * @param str
	 * @param pattern
	 * @return 
	 */
	public static boolean isValidDate(String str,String pattern) {
	      boolean convertSuccess=true;
	       SimpleDateFormat format = new SimpleDateFormat(pattern);
	       try {
	    	  // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
	          format.setLenient(false);
	          format.parse(str);
	       } catch (ParseException e) {
	          // e.printStackTrace();
	    	  // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	           convertSuccess=false;
	       } 
	       return convertSuccess;
	}

	/**
	 * 返回输入日期前一年的最后一天
	 * @param dateStr(yyyyMMdd格式)
	 * @return
	 */
	public static String returnPrevYearLastDay(String dateStr) throws Exception{
		try{
			SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
			Date d =sdf.parse(dateStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			int currentYear = calendar.get(Calendar.YEAR);
			int PrevYear = currentYear-1;
			calendar.clear();
			calendar.set(Calendar.YEAR, PrevYear);
			calendar.roll(Calendar.DAY_OF_YEAR, -1);
			Date currYearLast = calendar.getTime();
			return sdf.format(currYearLast);
		}catch (Exception e){
			throw e;
		}
	}
}