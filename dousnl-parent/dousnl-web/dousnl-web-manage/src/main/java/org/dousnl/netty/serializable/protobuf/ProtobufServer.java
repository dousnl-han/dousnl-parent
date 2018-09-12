package org.dousnl.netty.serializable.protobuf;

import org.dousnl.netty.echoserver.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;



/**
 * Protobuf 编解码demo
 * 
 * @author hanliang
 *
 */
public class ProtobufServer {

		public void bind(int port) throws Exception{
			
			EventLoopGroup bossGroup=new NioEventLoopGroup();
			EventLoopGroup workerGroup=new NioEventLoopGroup();
			try {
				ServerBootstrap b=new ServerBootstrap();
				b.group(bossGroup, workerGroup)
				 .channel(NioServerSocketChannel.class)
				 .option(ChannelOption.SO_BACKLOG, 1000)
				 .handler(new LoggingHandler(LogLevel.INFO))
				 .childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel arg0) throws Exception {
						//半包处理
						arg0.pipeline().addLast(new ProtobufVarint32FrameDecoder());
						//protobuf解码器
						arg0.pipeline().addLast(new 
								ProtobufDecoder(SubscribeReqProto.SubscribeReq.getDefaultInstance()));
						arg0.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
						arg0.pipeline().addLast(new ProtobufEncoder());
						arg0.pipeline().addLast(new SubReqServerHandler());
					}
				});
				//绑定端口
				ChannelFuture f=b.bind(port).sync();
				//此方法是为了阻塞线程，登待服务器链路关闭之后main函数才退出
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
			new ProtobufServer().bind(port);
		}*/
}
