package org.dousnl.nio.timeserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeClient implements Runnable{

	private String host;
	
	private int port;
	
	private Selector selector;
	
	private SocketChannel socketChannel;
	
	private volatile boolean stop;
	
	public MultiplexerTimeClient(String host,int port) {
	    
		this.host = host ==null ? "127.0.0.1" :host;
		this.port = port;
		try {
			selector=Selector.open();
			socketChannel=SocketChannel.open();
			socketChannel.configureBlocking(false);
			//socketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	private void stop() {
		this.stop=true;
	}
	private void doConnect() throws IOException {
		if (socketChannel.connect(new InetSocketAddress(host, port))) {
			socketChannel.register(selector, SelectionKey.OP_READ);
			doWriter(socketChannel);
		}else
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
	}
	@Override
	public void run() {
		try {
			doConnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		while (!stop) {
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
				System.exit(1);
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
			SocketChannel socketChannel=(SocketChannel) key.channel();
			if (key.isConnectable()) {
				if (socketChannel.finishConnect()) {
					socketChannel.register(selector, SelectionKey.OP_READ);
					doWriter(socketChannel);
				}else{
					System.exit(1);//进程失败，链接退出
				}
			}
			if (key.isReadable()) {
				ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
				int readBytes=socketChannel.read(byteBuffer);
				if (readBytes>0) {
					byteBuffer.flip();
					byte [] bytes=new byte[byteBuffer.remaining()];
					byteBuffer.get(bytes);
					String body=new String(bytes, "UTF-8");
					System.out.println("Now is : "+body);
					this.stop=true;
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
	private void doWriter(SocketChannel socketChannel) throws IOException {
		byte [] resp="QUERY TIME ORDER".getBytes();
		ByteBuffer writerbuffer=ByteBuffer.allocate(resp.length);
		writerbuffer.put(resp);
		writerbuffer.flip();
		socketChannel.write(writerbuffer);
		if (! writerbuffer.hasRemaining()) {
			System.out.println("Send order 2 server succend .");
		}
	}
}
