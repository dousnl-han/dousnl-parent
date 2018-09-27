package com.dousnl.sender;

public class SenderTest {

	public static void main(String[] args) {
		SenderFactory factory=new SenderFactory();
		Sender sender = SenderFactory.productMail();
		sender.send();
		
		Provider provider=new SenderSmsFactory();
		Sender sms = provider.product();
		sms.send();
	}

}
