package org.dousnl.netty.httpfile;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {

	private static final String DEFAULT_URL="/src/main/java/org/dousnl/netty/";
	
	public void run(final int port,final String url) throws Exception{
		EventLoopGroup bossGroup=new NioEventLoopGroup();
		EventLoopGroup workerGroup=new NioEventLoopGroup();
		try {
			ServerBootstrap b=new ServerBootstrap();
			b.group(bossGroup, workerGroup)
			 .channel(NioServerSocketChannel.class)
			 .childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel arg0) throws Exception {
					arg0.pipeline().addLast("http-decoder",new HttpRequestDecoder());
					arg0.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65536));
					arg0.pipeline().addLast("http-encoder",new HttpResponseEncoder());
					arg0.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
					arg0.pipeline().addLast("fileServerHandler",new HttpFileServerHandler(url));
				}
			});
			//绑定端口
			ChannelFuture f=b.bind("127.0.0.1",port).sync();
			System.out.println("HTTP 文件目录服务器启动   网址是："+"http://127.0.0.1:"+port+url);
			//此方法是为了阻塞线程，登待服务器链路关闭之后mian函数才退出
			f.channel().closeFuture().sync();
		} finally{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
		
	}
	
	/*public static void main(String[] args) throws Exception {
		int port=8080;
		if(args !=null && args.length>0){
			try {
				port=Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				//采用默认值
			}
		}
		String url=DEFAULT_URL;
		if (args.length>1) 
			url=args[1];
		new HttpFileServer().run(port,url);
	}*/
}
