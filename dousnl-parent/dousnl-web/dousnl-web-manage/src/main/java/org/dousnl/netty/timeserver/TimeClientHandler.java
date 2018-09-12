package org.dousnl.netty.timeserver;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {


	private static final Logger logger=Logger.getLogger(TimeClientHandler.class.getName());
	
	private ByteBuf firstMessage=null;
	
	private int counter;
	
	private byte [] req;
	
	
	public TimeClientHandler() {
		req=("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for (int i = 0; i < 100; i++) {
			firstMessage=Unpooled.buffer(req.length);
			firstMessage.writeBytes(req);
			ctx.writeAndFlush(firstMessage);
		}
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		/**
	     * 未处理粘包
	     */
		/*ByteBuf buf=(ByteBuf) msg;
		byte[] resp=new byte[buf.readableBytes()];
		buf.readBytes(resp);
		String body=new String(resp,"UTF-8");*/
		/**
    	 * 已用netty解码器，处理粘包
    	 */
    	String body=(String) msg;
		System.out.println("Now is : "+body+" ; the counter is : "+ ++counter);
		
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelReadComplete(ctx);
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		//释放资源
		logger.error("Unexpected exception from downstream : "+cause.getMessage());
		ctx.close();
	}
}
