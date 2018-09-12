package org.dousnl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


public class MultiplexerTimeServer implements Runnable {

	private Selector selector;
	
	private ServerSocketChannel servChannel;
	
	private volatile boolean stop;
	
	/**
	 * 初始化多路复用器，绑定监听端口
	 * 
	 * @param port
	 */
	public MultiplexerTimeServer(int port) {
		try {
			selector=Selector.open();//开启多路复用器
			servChannel=ServerSocketChannel.open();//开启服务端管道
			servChannel.configureBlocking(false);//设置管道为非阻塞
			servChannel.register(selector, SelectionKey.OP_ACCEPT);//管道注册到多路复用器
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	public void stop(){
		this.stop=true;
	}
	
	/**
	 * java.lang.Runnable#run()
	 * @parameter  
	 */
	@Override
	public void run() {
        
		while(!stop){
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys=selector.selectedKeys();
				Iterator<SelectionKey> it=selectedKeys.iterator();
				SelectionKey key=null;
				while (it.hasNext()) {
					key=it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if(key != null){
							key.cancel();
							if(key.channel() != null){
								key.channel().close();
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(selector != null){
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			//处理新接入的请求消息
			if (key.isAcceptable()) {
				//Accept the new connection
				ServerSocketChannel serverSocketChannel=(ServerSocketChannel) key.channel();
				SocketChannel socketChannel=serverSocketChannel.accept();
				socketChannel.configureBlocking(false);
				//add the new connection to selector
				socketChannel.register(selector, SelectionKey.OP_READ);
			}
			if (key.isReadable()) {
				SocketChannel socketChannel=(SocketChannel) key.channel();
				ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
				int readBytes=socketChannel.read(byteBuffer);
				if (readBytes>0) {
					byteBuffer.flip();
					byte [] bytes=new byte[byteBuffer.remaining()];
					byteBuffer.get(bytes);
					String body=new String(bytes, "UTF-8");
					System.out.println("The time server receive order is : "+body);
					String currentTime="QUERY TIME ORDER".equalsIgnoreCase(body) ? 
							new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
					doWriter(socketChannel,currentTime);
				}else if(readBytes < 0){
					//对端链路关闭
					key.cancel();
					socketChannel.close();
				}else{
					;//读到0字节忽略
				}
			}
		}
	}
	private void doWriter(SocketChannel socketChannel, String currentTime) throws IOException {
		if (currentTime != null && currentTime.trim().length() > 0) {
			byte [] bytes=currentTime.getBytes();
			ByteBuffer writerbuffer=ByteBuffer.allocate(bytes.length);
			writerbuffer.put(bytes);
			writerbuffer.flip();
			socketChannel.write(writerbuffer);
		}
	}

}
