package org.dousnl.netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class ObjectServerHandler extends SimpleChannelHandler {

	/**
	 * 当接收到消息时候触发
	 * 
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		Command command=(Command) e.getMessage();
		//打印是不是我们刚刚传过来的那个
        System.out.println("ActionName:"+command.getActionName());
        System.out.println("ActionDate:"+command.getActionDate());
	}
}
