package com.dousnl.netty;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

import com.dousnl.web.util.DateUtils;

/**
 * Netty 服务端代码
 * @author hanliang
 *
 */
public class NettyServerDemo {

	public static void main(String[] args) {
		
		//Server服务启动器
		ServerBootstrap bootstrap=new ServerBootstrap(
				new NioServerSocketChannelFactory(
						Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
		//设置一个处理客户端消息和各种消息事件的类(Handler)
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				return Channels.pipeline(new HelloServerHandler());
			}
			/*@Override
			public ChannelPipeline getPipeline() throws Exception {
				return Channels.pipeline(new ObjectDecoder(),new ObjectServerHandler());
			}*/
		});
		//开放8000端口供客户端访问
		bootstrap.bind(new InetSocketAddress(8000));
		
	}
	
	private static class HelloServerHandler extends SimpleChannelHandler{

		/**
		 *当有客户端绑定到服务端的时候触发，打印 Hello world I'm Server. 
		 *
		 * @version 1.0
		 * @parameter @throws Exception
		 */
		@Override
		public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("Hello world I'm Server. "+DateUtils.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss:SSS"));
		}	
	}
}
