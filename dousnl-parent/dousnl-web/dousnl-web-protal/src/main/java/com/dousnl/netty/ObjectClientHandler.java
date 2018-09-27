package com.dousnl.netty;

import java.util.Date;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.dousnl.web.util.DateUtils;

public class ObjectClientHandler extends SimpleChannelHandler {

	/**
	 * 当绑定到服务端时候触发，给服务端发消息
	 * 
	 */
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		sendObject(e.getChannel());
	}
	/**
	 *发送 Object 
	 */
	private void sendObject(Channel channel){
			Command command=new Command();
			command.setActionName("Hello action");
			command.setActionDate(DateUtils.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss:SSS"));
			channel.write(command);
	}
	
}
