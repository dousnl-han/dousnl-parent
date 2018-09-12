package org.dousnl.test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Test_thread {

	private volatile static Map<String,Object> iQCodes = new HashMap<String,Object>();
	
	public static String fillStr(String value,int maxLength){
		if(value!=null && value.length()<maxLength){
			StringBuilder _value = new StringBuilder();
			for (int i = 0; i < maxLength - value.length(); i++) {
				_value.append("0");
			}
			_value.append(value);
			return _value.toString();
		}
		return value;
	}
	
	/**
	 * 生成询单CODE（方法名和实现搞错误了，方法名是去取报价CODE，但实现是取询单CODE）
	 * @return
	 */
	public static String genQTCodeID(){
		synchronized (iQCodes) {
			Calendar calendar = Calendar.getInstance();
			StringBuilder _date = new StringBuilder()
				.append(calendar.get(Calendar.YEAR))
				.append(fillStr(String.valueOf(calendar.get(Calendar.MONTH)+1),2))
				.append(fillStr(String.valueOf(calendar.get(Calendar.DATE)),2))
				.append(fillStr(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)),2))
				.append(fillStr(String.valueOf(calendar.get(Calendar.MINUTE)),2))
				.append(fillStr(String.valueOf(calendar.get(Calendar.SECOND)),2));
			
			if(!iQCodes.containsKey(_date.toString())){
				iQCodes.put(_date.toString(), "1");
				System.out.println("date_tostring:"+_date.toString()+"\t序号："+1);
			}else{
				Object code = iQCodes.get(_date.toString());
				Integer codeNum = Integer.valueOf(code.toString());
				String aaa=fillStr(String.valueOf(++codeNum),1);
				iQCodes.put(_date.toString(), aaa);
				System.out.println("date_tostring2:"+_date.toString()+"\t序号2："+aaa);
			}
			
			return new StringBuilder().append(DCType.IQ.getValue()).append(_date).append(iQCodes.get(_date.toString())).toString();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("thread");
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					System.out.println("thred1-----"+genQTCodeID());
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		thread.start();
	}
}
