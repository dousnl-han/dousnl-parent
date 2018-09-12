package org.dousnl.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioController {

	public static void main(String[] args) {
		RandomAccessFile aFile=null;
		try {
			aFile = new RandomAccessFile("e:/nio.txt", "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
		FileChannel inChannel = aFile.getChannel();  
		  
		ByteBuffer buf = ByteBuffer.allocate(48);  
		  
		int bytesRead;
		try {
			bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {  
				  
				System.out.println("Read " + bytesRead);  
				buf.flip();  
				  
				while(buf.hasRemaining()){  
				System.out.print((char) buf.get());  
				}  
				  
				buf.clear();  
				bytesRead = inChannel.read(buf);  
				}  
				aFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		  
	}
}
