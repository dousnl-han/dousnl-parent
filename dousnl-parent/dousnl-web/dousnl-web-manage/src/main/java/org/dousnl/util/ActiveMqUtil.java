package org.dousnl.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMqUtil {
	//创建连接工场
	private static ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
	
	private static String consumerMessage="default-message";
	
	public static ConnectionFactory getInstance(){
		return connectionFactory;
	}
	
	public static void creatQueue(String queueName,String msg) throws JMSException{
		
		ConnectionFactory factory = getInstance();
		//创建连接
		Connection connection = factory.createConnection();
		//创建会话
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//开启连接
		connection.start();
		//创建队列
		Queue queue = session.createQueue(queueName);
		MessageProducer producer = session.createProducer(queue);
		TextMessage mapMessage = session.createTextMessage(msg);
		producer.send(mapMessage);
		System.out.println("消息发送成功:"+msg);
		session.commit();
		session.close();
		connection.close();
	}
	
    public static String reviceMsg(String queueName) throws JMSException{
		ConnectionFactory factory = getInstance();
		//创建连接
		Connection connection = factory.createConnection();
		//创建会话
		Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
		//开启连接
		connection.start();
		//创建队列
		Queue queue = session.createQueue(queueName);
		MessageConsumer consumer = session.createConsumer(queue);
		
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message msg) {
				TextMessage text=(TextMessage) msg;
				try {
					consumerMessage=text.getText();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		session.close();
		connection.close();
		return consumerMessage;
	}
}
