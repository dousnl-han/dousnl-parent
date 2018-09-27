package com.dousnl.sender;

/**
 * 设计模式---短信抽象工厂类
 * @author hanliang
 *
 */
public class SenderSmsFactory implements Provider {

	@Override
	public Sender product() {
		return new SmsSender();
	}

}
