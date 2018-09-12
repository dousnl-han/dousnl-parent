package org.dousnl.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.dousnl.activemq.spring.listener.QueueReceiver1;
import org.dousnl.shiro.domain.User;
import org.dousnl.shiro.service.UserService;
import org.dousnl.util.ActiveMqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class ActivemqTimer {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JmsTemplate jmsTemplate;
	
  //  每分钟启动
  @Scheduled(cron = "0 0/10 * * * ?")
  public void timerToNow(){
      System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
      /*try {
    	System.out.println("开始接收......");
    	Message message = jmsTemplate.receive(destination);
    	TextMessage text=(TextMessage) message;
    	String reviceMsg = text.getText();
		System.out.println("定时任务....接收到消息为："+reviceMsg);
		if(!"default-message".equals(reviceMsg)){
			User u=JSON.parseObject(reviceMsg, User.class);
			int count = userService.saveUser(u);
			if(count>0){
				System.out.println("数据库同步成功,准备确认消息.....");
				//message.acknowledge();
				System.out.println("此处消息未确认..........");
			}
		}
	} catch (JMSException e) {
		e.printStackTrace();
	}*/
  }
//每两分钟启动
  /*@Scheduled(cron = "0 0/2 * * * ?")
public void timerTo(){
    System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    try {
  	Message message = jmsTemplate.receive();
  	TextMessage text=(TextMessage) message;
  	String reviceMsg = text.getText();
		System.out.println("定时任务2....接收到消息为："+reviceMsg);
		if(!"default-message".equals(reviceMsg)){
			User u=JSON.parseObject(reviceMsg, User.class);
			int count = userService.saveUser(u);
			if(count>0){
				System.out.println("数据库同步成功,准备确认消息.....");
				message.acknowledge();
				System.out.println("确认消息成功..........");
			}
		}
	} catch (JMSException e) {
		e.printStackTrace();
	}
}*/
}
