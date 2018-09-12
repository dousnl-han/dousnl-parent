package org.dousnl.activemq.topic.durable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;

public class DurableTopicSender {

	public static void main(String[] args) throws Exception {
		//创建连接工场
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		//创建连接
		Connection connection = connectionFactory.createConnection();
		
		//创建会话
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//创建队列
		Topic topic = session.createTopic("myTopic2");
		MessageProducer producer = session.createProducer(topic);
		//发送者设置
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		//开启连接
		connection.start();
		for(int i=0;i<3;i++){
			TextMessage textMessage =session.createTextMessage("durbale message"+i);
			producer.send(textMessage);
		}
		session.commit();
		session.close();
		connection.close();
	}
}
