package com.dousnl.activemq.topic.nodurable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;

public class NodurableTopicSender {

	public static void main(String[] args) throws Exception {
		//创建连接工场
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		//创建连接
		Connection connection = connectionFactory.createConnection();
		//开启连接
		connection.start();
		//创建会话
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//创建队列
		Topic topic = session.createTopic("myTopic");
		MessageProducer producer = session.createProducer(topic);
		for(int i=0;i<3;i++){
			TextMessage textMessage =session.createTextMessage("no durbale message"+i);
			producer.send(textMessage);
		}
		session.commit();
		session.close();
		connection.close();
	}
}
