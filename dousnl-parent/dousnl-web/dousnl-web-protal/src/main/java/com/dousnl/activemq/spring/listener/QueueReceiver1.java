package com.dousnl.activemq.spring.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.alibaba.fastjson.JSON;
import com.dousnl.quartz.ActivemqTimer;
import com.dousnl.shiro.domain.User;
import com.dousnl.shiro.service.UserService;

/**
 * @author Fairyland
 * save.user-activemq-listener
 */
public class QueueReceiver1 implements MessageListener{
	
	private Logger logger=LoggerFactory.getLogger(QueueReceiver1.class);
	
	@Autowired
	private UserService userService;
	//@Autowired
	//private ActivemqTimer activemqTimer;
	@Autowired
	private JmsTemplate jmsTemplate;
	
	private String text="";//接收的消息
	@Override
	public void onMessage(Message message){
		TextMessage textMessage=(TextMessage)message;
		try {
			text = textMessage.getText();
			System.out.println("QueueReceiver1----listener接收到消息,此处不做处理:"+text);
			User u=JSON.parseObject(text, User.class);
			int count = userService.saveUser(u);
			if(count>0){
				System.out.println("数据库同步成功,准备确认消息.....");
				message.acknowledge();
				System.out.println("确认消息成功..........");
			}
		} catch (Exception e) {
			try {
				message.acknowledge();
			} catch (JMSException e1) {
				System.out.println("*******此处确认消息异常******");
				e1.printStackTrace();
			}//确认上条消息
			try {
				System.out.println("休眠20秒，消息准备重投："+text);
				System.out.println("当前线程名："+Thread.currentThread().getName());
				Thread.sleep(20*1000);
			} catch (InterruptedException e1) {
				System.out.println("*******此处线程异常******");
				e1.printStackTrace();
			}//休眠1分钟，重投消息
			jmsTemplate.send(new MessageCreator() {//消息重投
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage textMessage = session.createTextMessage(text);
					Queue queue = session.createQueue("save.user");
					return textMessage;
				}
			});
			logger.info("***********准备打印保存异常********* {}",text);
			e.printStackTrace();//打印上条异常
		}
	}

}
