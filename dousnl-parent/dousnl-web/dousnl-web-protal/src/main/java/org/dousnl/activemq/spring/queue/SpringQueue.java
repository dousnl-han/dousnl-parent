package org.dousnl.activemq.spring.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class SpringQueue {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		//发送消息
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:activemqSpring.xml");
		SpringQueue bean = (SpringQueue)applicationContext.getBean("springQueue");
		bean.jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage("spring-text-message!");
				return textMessage;
			}
		});
		//接收消息
		/*ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:activemqSpring.xml");
		SpringQueue bean = (SpringQueue)applicationContext.getBean("springQueue");
		String message = (String)bean.jmsTemplate.receiveAndConvert();
		System.out.println("msg=====："+message);*/
	}
	public void send(){
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage("spring-text-message!");
				Queue queue = session.createQueue("test-springmq");
				return textMessage;
			}
		});
	}
}
