package org.dousnl.sender;

/**
 * 设计模式工厂模式
 * @author hanliang
 *
 */
public class SenderFactory {
	
	/**
	 * 静态工厂模式
	 * @return 
	 */
	public static Sender productMail(){
		return new MailSender();
	}
	/**
	 * 静态工厂模式
	 * @return 
	 */
	public static Sender productSms(){
		return new SmsSender();
	}
	
	/**
	 * 普通工厂模式
	 * @param type
	 * @return 
	 */
	public Sender product(String type){
		if("mail".equals(type)){
			return new MailSender();
		}
		else if("sms".equals(type)){
			return new SmsSender();
		}
		else{
			System.out.println("请输入正确的类型");
			return null;
		}
	}

}
