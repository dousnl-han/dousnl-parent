package org.dousnl.activemq.topic.nodurable;

import java.util.Enumeration;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;

public class NodurableTopicReciever {

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
		Topic topic = session.createTopic("myTopic");
		MessageConsumer consumer = session.createConsumer(topic);
		Message message = consumer.receive();
		for(int i=0;i<3;i++){
			//消息接收
			TextMessage textMessage = (TextMessage) message;
			//消息处理
			String text = textMessage.getText();
			System.out.println("接收到消息："+text);
			//消息确认
			session.commit();
			//消息接收线程延迟1s,确认事务可以提交
			message=consumer.receive(1000L); 
		}
		session.close();
		connection.close();
	}

}
