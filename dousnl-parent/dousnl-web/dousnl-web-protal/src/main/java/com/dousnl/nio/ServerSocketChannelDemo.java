package com.dousnl.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class ServerSocketChannelDemo {

	
	public static void startServer(){
		try {
			ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(8060));
			serverSocketChannel.configureBlocking(false);
			while(true){
				SocketChannel socketChannel=serverSocketChannel.accept();
				if(socketChannel!=null){
					ByteBuffer byteBuffer=ByteBuffer.allocate(48);
					int size=socketChannel.read(byteBuffer);
					while(size>0){
						byteBuffer.flip();
						Charset charset=Charset.forName("UTF-8");
						System.out.println(charset.newDecoder().decode(byteBuffer));
						size=socketChannel.read(byteBuffer);
						byteBuffer.clear();
					}
					ByteBuffer response=ByteBuffer.wrap("server is recver successfully".getBytes("UTF-8"));
					socketChannel.write(response);
					response.clear();
					//socketChannel.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testServerSocket(){
		startServer();
	}
}
