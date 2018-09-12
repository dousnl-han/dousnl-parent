package org.dousnl.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * JMS 消息消费者
 * @author hanliang
 *
 */
public class JMSConsumer {

    //默认连接用户名
	private static final String username=ActiveMQConnection.DEFAULT_USER;
	//默认连接密码
	private static final String password=ActiveMQConnection.DEFAULT_PASSWORD;
	//默认连接地址
	private static final String brokerURL=ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		//连接工厂
		ConnectionFactory connectionFactory;
		//连接
		Connection connection=null;
		//会话，接收或者发送消息的线程
		Session session;
		//消息的目的地
		Destination destination;
		//消息消费者
		MessageConsumer messageConsumer;
		//实例化连接工厂
		connectionFactory=new ActiveMQConnectionFactory(username, password, brokerURL);
	
		try {
			//通过连接工厂获取连接
			connection=connectionFactory.createConnection();
			//启动连接
			connection.start();
			//创建Session
            session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//创建一个名为HelloWorld的消息队列
			destination=session.createQueue("Hello World !");
			//创建消息生产者
			messageConsumer=session.createConsumer(destination);
			
			while (true) {
				TextMessage message=(TextMessage) messageConsumer.receive(10000);
				if (message!=null) {
					System.out.println("收到消息："+message.getText());
				}else{
					break;
				}
			}
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
}
