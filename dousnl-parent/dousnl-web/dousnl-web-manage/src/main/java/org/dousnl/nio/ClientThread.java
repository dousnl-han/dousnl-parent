package org.dousnl.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClientThread extends Thread{

	private Selector selector;
	
	public ClientThread(Selector selector) {
		this.selector = selector;
	}

	@Override
	public void run() {
		try {
			while(selector.select()>0){
				for(SelectionKey key:selector.selectedKeys()){
					SocketChannel socketChannel=(SocketChannel) key.channel();
					ByteBuffer buf=ByteBuffer.allocate(88);
					int size=socketChannel.read(buf);
					
					while(size>0){
						buf.flip();
						Charset charset=Charset.forName("UTF-8");
						System.out.println(charset.newDecoder().decode(buf));
						size=socketChannel.read(buf);
					}
					selector.selectedKeys().remove(key);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
