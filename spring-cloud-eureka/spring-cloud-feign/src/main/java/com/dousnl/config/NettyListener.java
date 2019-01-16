package com.dousnl.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * tomcat启动时,放开
 * @author 56096
 *
 */
/**
 * @author 56096
 * 
 * ContextRefreshedEvent
 * 事件引发,当一个{@代码应用程序上下文}被初始化或刷新时。
 * 
 * EmbeddedServletContainerInitializedEvent
 * 在刷新上下文后将要发布的事件，以及
 * {@链接EmbeddedServletContainer }已准备就绪。用于获取正在运行的服务器的本地端口。通常它已经启动，但是听众可以自由检查。
 * 服务器，如果他们想停止和启动它。
 *
 */
@Service 
public class NettyListener implements ApplicationListener<ContextRefreshedEvent>{ 
	private Logger logger= LoggerFactory.getLogger(NettyListener.class); 
	
	@Autowired com.codingapi.tx.netty.service.NettyService nettyService;
	
	private static int count=0;
	
	@Override 
	public void onApplicationEvent(ContextRefreshedEvent event) {
		String displayName = event.getApplicationContext().getDisplayName();
		System.err.println("displayName ->>>>>>>>>>>: "+displayName);
		ApplicationContext parent = event.getApplicationContext().getParent();
		System.err.println("parent ->>>>>>>>>>>: "+parent);
		System.err.println("parent name ->>>>>>>>>>>: "+parent.getDisplayName());
		if(count == 0){
			System.err.println("NettyService is start :"+nettyService);
			logger.info("spring Start Success");
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					nettyService.start();
				}
			}).start();
			count++;
		}
	} 
}