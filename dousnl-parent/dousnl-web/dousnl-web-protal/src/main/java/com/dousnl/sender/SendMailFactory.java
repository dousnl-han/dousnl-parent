package com.dousnl.sender;

/**
 * 设计模式---邮件抽象工厂类
 * @author hanliang
 *
 */
public class SendMailFactory implements Provider {

	@Override
	public Sender product() {
		return new MailSender();
	}

}
