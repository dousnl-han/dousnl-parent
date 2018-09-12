package org.dousnl.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class SelectorServerSocketChannelDemo {

	public static void startSocket(){
		
		try {
			ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(8060));
			Selector selector=Selector.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
                int select=selector.select();
                
                //检查是否有可用的通道已接入
                if(select>0){
                	for(SelectionKey key:selector.selectedKeys()){
                		if(key.isAcceptable()){
                			SocketChannel socketChannle=((ServerSocketChannel) key.channel()).accept();
                			ByteBuffer buf=ByteBuffer.allocate(88);
                			int size=socketChannle.read(buf);   
                		    while(size>0){
                		    	buf.flip();
                		    	Charset charset=Charset.forName("UTF-8");
                		    	System.out.println(charset.newDecoder().decode(buf));
                		    	size=socketChannle.read(buf);
                		    }
                		    buf.clear();
                		    
                		    ByteBuffer response=ByteBuffer.wrap("服务端向SocketChannel回应数据...".getBytes());
                		    socketChannle.write(response);
                		    socketChannle.close();
                		    selector.selectedKeys().remove(key);
                		}
                	}
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void test(){
		startSocket();
	}
}
