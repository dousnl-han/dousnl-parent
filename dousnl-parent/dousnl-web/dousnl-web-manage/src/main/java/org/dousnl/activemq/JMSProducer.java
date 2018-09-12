package org.dousnl.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * JMS 服务提供方
 * @author hanliang
 *
 */
public class JMSProducer {

	//默认连接用户名
	private static final String username=ActiveMQConnection.DEFAULT_USER;
	//默认连接密码
	private static final String password=ActiveMQConnection.DEFAULT_PASSWORD;
	//默认连接地址
	private static final String brokerURL=ActiveMQConnection.DEFAULT_BROKER_URL;
	//发送消息的数量
	private static final int sendnum=10;
	
	public static void main(String[] args) {
		//连接工厂
		ConnectionFactory connectionFactory;
		//连接
		Connection connection=null;
		//会话，接收或者发送消息的线程
		Session session;
		//消息的目的地
		Destination destination;
		//消息生产者
		MessageProducer messageProducer;
		//实例化连接工厂
		connectionFactory=new ActiveMQConnectionFactory(username, password, brokerURL);
		
		try {
			//通过连接工厂获取连接
			connection=connectionFactory.createConnection();
			//启动连接
			connection.start();
			//创建Session
            session=connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			//创建一个名为HelloWorld的消息队列
			destination=session.createQueue("Hello World !");
			//创建消息生产者
			messageProducer=session.createProducer(destination);
			//发送消息
			sendMessage(session,messageProducer);
			//会话提交
			session.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 发送消息
	 * @param session
	 * @param messageProducer 消息生产者
	 * @throws JMSException 
	 * @throws Exception 
	 */
	public static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException {
		for(int i=0;i<JMSProducer.sendnum;i++){
			//创建一条文本消息
			TextMessage message=session.createTextMessage("ActiveMq 发送消息"+i);
			System.out.println("发送消息 ，ActiveMq 消息 "+i);
			//通过生产者发送消息
			messageProducer.send(message);
		}
		
	}
	
}
