package org.dousnl.netty.serializable.protobuf;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class ProtobufClient {
	
	
	public void connect(String host,int port) throws InterruptedException{
		//配置客户端NIO线程组
		EventLoopGroup group=new NioEventLoopGroup();
		try {
			Bootstrap boot=new Bootstrap();
			boot.group(group).channel(NioSocketChannel.class)
			    .option(ChannelOption.TCP_NODELAY, true)
			    .handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel arg0) throws Exception {
						//半包处理
						arg0.pipeline().addLast(new ProtobufVarint32FrameDecoder());
						//protobuf解码器
						arg0.pipeline().addLast(new 
								ProtobufDecoder(SubscribeRespProto.SubscribeResp.getDefaultInstance()));
						arg0.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
						arg0.pipeline().addLast(new ProtobufEncoder());
						arg0.pipeline().addLast(new SubReqClientHandler());
						
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
	
	/*public static void main(String[] args) throws InterruptedException {
		int port=8080;
		if(args !=null && args.length>0){
			try {
				port=Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				//采用默认值
			}
		}
		new ProtobufClient().connect("127.0.0.1", port);
	}*/
}
