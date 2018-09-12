package org.dousnl.activemq.spring.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Fairyland
 * test.queue-activemq-listener
 */
public class QueueReceiver2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage=(TextMessage)message;
		try {
			String text = textMessage.getText();
			System.out.println("QueueReceiver2接收到消息为："+text);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
