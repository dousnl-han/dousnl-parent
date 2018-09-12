package org.dousnl.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class SocketChannelDemo {
	
	public static void socketClient(){
		try {
			SocketChannel socketChannel=SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("localhost", 8060));
			socketChannel.configureBlocking(false);
			
			Selector selector=Selector.open();
			socketChannel.register(selector, SelectionKey.OP_READ);
			
			new ClientThread(selector).start();
			String newDate="客户端向SocketChannel写入数据..."+System.currentTimeMillis();
			ByteBuffer byteBuffer=ByteBuffer.allocate(88);
			byteBuffer.clear();
			byteBuffer.put(newDate.getBytes("UTF-8"));
			byteBuffer.flip();
			while(byteBuffer.hasRemaining()){
				socketChannel.write(byteBuffer);
			}
			byteBuffer.clear();
			/*ByteBuffer bufferResponse=ByteBuffer.allocate(88);
			int size=socketChannel.read(bufferResponse);
			while(size>0){
				bufferResponse.flip();
				Charset charset=Charset.forName("UTF-8");
				System.out.println(charset.newDecoder().decode(bufferResponse).toString());
				bufferResponse.clear();
				size=socketChannel.read(bufferResponse);
			}*/
			//bufferResponse.clear();
			//socketChannel.close();
			//Thread.sleep(50000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSocket(){
		socketClient();
	}
}
