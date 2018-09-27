package com.dousnl.activemq;

import java.util.List;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
			destination=session.createQueue("JSON !");
			//创建消息生产者
			messageConsumer=session.createConsumer(destination);
			
			while (true) {
				 Message receive = messageConsumer.receive(10000);
				if (receive!=null) {
					/*User u=(User)((ObjectMessage)receive).getObject();
					System.out.println("收到消息："+u.toString());
					System.out.println("收到用户ID："+u.getId());
					System.out.println("收到用户姓名："+u.getName());
					System.out.println("收到用户生日："+DateUtils.dateToString(u.getPridaty(), null));*/
					String text = ((TextMessage)receive).getText();
					System.out.println("text:"+text);
					User u=JSON.parseObject(text,User.class);
					//System.out.println("jsonObject:"+jsonObject.toString());
					//Object object = jsonObject.get("address");
					//User u = JsonUtil.fromJson(text, User.class);
					//User u = jsonObject.toJavaObject(jsonObject, User.class);
					System.out.println("收到消息："+u.toString());
					System.out.println("收到用户姓名："+u.getName());
					System.out.println("收到用户ID："+u.getId());
					List<String> address = u.getAddress();
					for(String s:address){
						System.out.println("收到用户地址："+s);
					}
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
