package org.dousnl.activemq.staticnetwork;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueReciever {

	public static void main(String[] args) throws Exception {
		//创建连接工场
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(
				//"tcp://192.168.37.128:61616");
	            "failover:(tcp://192.168.37.128:61616,tcp://192.168.37.128:61617)");
		//创建连接
		Connection connection = connectionFactory.createConnection();
		//开启连接
		connection.start();
		
		//创建会话
		/**
		 * 在事务性会话中，当一个事务被提交的时候，消息确认自动发生。在非事务性会话中，消息何时被确认取决于
		 * 创建会话时的应答模式（acknowledge mode）。该参数有三个值可选(Session.AUTO_ACKNOWLEDGE,
		 * Session.CLIENT_ACKNOWLEDGE,Session.DUPS_OK_ACKNOWLEDGE)
		 */
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//创建队列
		Queue queue = session.createQueue("my-queue3");
		MessageConsumer consumer = session.createConsumer(queue);
		for(int i=0;i<30;i++){
			//消息接收
			TextMessage message = (TextMessage) consumer.receive();
			//消息处理
			System.out.println("Reciever1接收到消息："+message.getText());
			//消息确认
			session.commit();
			Thread.sleep(1000);
		}
		session.close();
		connection.close();
	}

}

