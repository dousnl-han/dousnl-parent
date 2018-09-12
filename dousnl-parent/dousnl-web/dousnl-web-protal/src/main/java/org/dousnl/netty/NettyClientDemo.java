package org.dousnl.netty;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.Executors;

import org.dousnl.web.util.DateUtils;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Netty 客户端代码
 * @author hanliang
 *
 */
public class NettyClientDemo {

	public static void main(String[] args) {
		
		//Client服务启动器
		ClientBootstrap bootstrap=new ClientBootstrap(
				new NioClientSocketChannelFactory(
						Executors.newCachedThreadPool(), 
						Executors.newCachedThreadPool()));
		//设置一个处理服务端消息和消息事件处理的类(Handler)
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				return Channels.pipeline(new HelloClientHandler());
			}
			/*@Override
			public ChannelPipeline getPipeline() throws Exception {
				return Channels.pipeline(new ObjectEncoder(),new ObjectClientHandler());
			}*/
		});
		//连接到本地8000端口的服务端
		bootstrap.connect(new InetSocketAddress("127.0.0.1", 8000)	);
		
	}
	
	private static class HelloClientHandler extends SimpleChannelHandler{
		
		/**
		 *当绑定到服务端时候触发，打印 Hello world I'm Client 
		 * @parameter @throws Exception
		 */
		@Override
		public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.println("Hello world I'm Client "+DateUtils.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss:SSS"));
		}
	}
}
