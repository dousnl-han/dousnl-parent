package com.dousnl.activemq.staticnetwork;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueSender {

	public static void main(String[] args) throws Exception {
		//创建连接工场
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://192.168.37.128:61616");
		//创建连接
		Connection connection = connectionFactory.createConnection();
		//开启连接
		connection.start();
		//创建会话
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//创建队列
		Queue queue = session.createQueue("my-queue3");
		MessageProducer producer = session.createProducer(queue);
		for(int i=0;i<30;i++){
			TextMessage mapMessage = session.createTextMessage("message====AAA"+i);
			producer.send(mapMessage);
		}
		session.commit();
		session.close();
		connection.close();
	}
}
