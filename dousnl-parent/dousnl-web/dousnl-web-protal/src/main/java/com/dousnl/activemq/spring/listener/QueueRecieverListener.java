package com.dousnl.activemq.spring.listener;

import java.util.Date;
import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.alibaba.fastjson.JSON;
import com.dousnl.activemq.User;
import com.dousnl.util.DateUtils;

public class QueueRecieverListener {

	public static void main(String[] args) throws Exception {
		//创建连接工场
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		//创建连接
		Connection connection = connectionFactory.createConnection();
		//开启连接
		connection.start();
		
		Enumeration propertyNames = connection.getMetaData().getJMSXPropertyNames();
		while (propertyNames.hasMoreElements()) {
			String name = (String) propertyNames.nextElement();
			System.out.println("jmsx name==="+name);
		}
		//创建会话
		/**
		 * 在事务性会话中，当一个事务被提交的时候，消息确认自动发生。在非事务性会话中，消息何时被确认取决于
		 * 创建会话时的应答模式（acknowledge mode）。该参数有三个值可选(Session.AUTO_ACKNOWLEDGE,
		 * Session.CLIENT_ACKNOWLEDGE,Session.DUPS_OK_ACKNOWLEDGE)
		 */
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//创建队列
		Queue queue = session.createQueue("queue");
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage=(TextMessage)message;
				try {
					String text = textMessage.getText();
					System.out.println("接收到消息为："+text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		session.close();
		connection.close();
	}

}
