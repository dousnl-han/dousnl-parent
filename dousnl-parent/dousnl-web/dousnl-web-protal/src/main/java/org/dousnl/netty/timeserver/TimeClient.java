package org.dousnl.netty.timeserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Netty time client
 * @author hanliang
 *
 */
public class TimeClient {

	public void connect(String host,int port) throws InterruptedException{
		//配置客户端NIO线程组
		EventLoopGroup group=new NioEventLoopGroup();
		try {
			Bootstrap boot=new Bootstrap();
			boot.group(group).channel(NioSocketChannel.class)
			    .option(ChannelOption.TCP_NODELAY, true)
			    .handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
						ch.pipeline().addLast(new StringDecoder());
						ch.pipeline().addLast(new TimeClientHandler());
						
					}

				});
			//发起异步链接操作
			ChannelFuture f=boot.connect(host, port).sync();
			//登待客户端链路关闭
			f.channel().closeFuture().sync();
		} finally {
		    group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int port=8080;
		if(args !=null && args.length>0){
			try {
				port=Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				//采用默认值
			}
		}
		new TimeClient().connect("127.0.0.1", port);
	}
}
