package org.dousnl.netty.websocket;

import org.dousnl.netty.httpfile.HttpFileServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketServer {

	public void bind(int port) throws Exception{
		EventLoopGroup bossLoopGroup=new NioEventLoopGroup();
		EventLoopGroup workerLoopGroup=new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap=new ServerBootstrap();
			serverBootstrap.group(bossLoopGroup, workerLoopGroup);
			serverBootstrap.channel(NioServerSocketChannel.class)
			               .childHandler(new ChannelInitializer<SocketChannel>() {

							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								ch.pipeline().addLast("http-codec",new HttpServerCodec());
								ch.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
								ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
								ch.pipeline().addLast("handler", new WebSocketServerHandler());
							}
						});
		Channel channel = serverBootstrap.bind(port).sync().channel();
		System.out.println("Web socket start in port : "+port);
		System.out.println("Open your browser and navigate to http://localhost:"+port+"/");
		channel.closeFuture().sync();
		} finally {
			bossLoopGroup.shutdownGracefully();
			workerLoopGroup.shutdownGracefully();
		}
	}
	public static void main(String[] args) throws Exception {
		int port=8080;
		if(args !=null && args.length>0){
			try {
				port=Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				//采用默认值
			}
		}
		new WebSocketServer().bind(port);
	}
}
