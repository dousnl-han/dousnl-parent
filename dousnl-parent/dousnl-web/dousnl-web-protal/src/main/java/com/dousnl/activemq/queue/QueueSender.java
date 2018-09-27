package com.dousnl.activemq.queue;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.alibaba.fastjson.JSON;
import com.dousnl.activemq.User;

public class QueueSender {

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
		Queue queue = session.createQueue("queue");
		MessageProducer producer = session.createProducer(queue);
		for(int i=0;i<3;i++){
			MapMessage mapMessage = session.createMapMessage();
			mapMessage.setStringProperty("property"+i, "OkOk!!"+i);
			mapMessage.setString("user", JSON.toJSONString(new User(i, "name"+i, new Date())));
			mapMessage.setJMSMessageID("order-123:"+i);
			producer.send(mapMessage);
		}
		session.commit();
		session.close();
		connection.close();
	}
}
