package com.dousnl.web.controller;

//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dousnl.websocket.WiselyMessage;
import com.dousnl.websocket.WiselyResponse;

@Controller
public class WebSocketController {
	
	@RequestMapping("/websocket")
	public String login(){
		return "bootWebSocketTest";
	}
	
	 /** 
     * 表示服务端可以接收客户端通过主题“/welcome”发送过来的消息，
     * 客户端需要在主题"/topic/getResponse"上监听并接收服务端发回的消息 
     * @param topic 
     * @param headers 
     */  
	/*@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WiselyResponse say(WiselyMessage message) throws Exception{
		Thread.sleep(3000);
		System.out.println("name:"+message.getName());
		return new WiselyResponse("Welcome , "+message.getName()+" !");
	}*/
}
