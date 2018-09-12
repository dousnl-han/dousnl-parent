package org.dousnl.activemq.topic.durable;

import java.util.Enumeration;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;
import org.apache.activemq.ActiveMQConnectionFactory;

public class DurableTopicReciever {

	public static void main(String[] args) throws Exception {
		//创建连接工场
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		//创建连接
		Connection connection = connectionFactory.createConnection();
		
		Enumeration propertyNames = connection.getMetaData().getJMSXPropertyNames();
		while (propertyNames.hasMoreElements()) {
			String name = (String) propertyNames.nextElement();
			System.out.println("jmsx name==="+name);
		}
		//持久化要先注册，客户端id
		connection.setClientID("cc1");
		//创建会话
		/**
		 * 在事务性会话中，当一个事务被提交的时候，消息确认自动发生。在非事务性会话中，消息何时被确认取决于
		 * 创建会话时的应答模式（acknowledge mode）。该参数有三个值可选(Session.AUTO_ACKNOWLEDGE,
		 * Session.CLIENT_ACKNOWLEDGE,Session.DUPS_OK_ACKNOWLEDGE)
		 */
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//创建队列
		Topic topic = session.createTopic("myTopic2");
		TopicSubscriber ts = session.createDurableSubscriber(topic, "T1");
		//开启连接
		connection.start();
		Message message = ts.receive();
		while (message!=null) {
			//消息接收
			TextMessage textMessage = (TextMessage) message;
			//消息确认
			session.commit();
			//消息处理
			System.out.println("接收到消息："+textMessage.getText());
			//接收下一条消息,此处不写会无限提交消息，死循环
			//接收消息，参数：接收消息的超时时间，为0的话则不超时，receive返回下一个消息，但是超时了或者消费者被关闭，返回null
			message=ts.receive(1000L);
		}
		session.close();
		connection.close();
	}

}
