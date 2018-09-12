package org.dousnl.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ByteBufferDemo {
	
	//主要通过读取文件内容,写到ByteBuffer里,然后再从ByteBuffer里读取数据,写到控制台
	
	public static void readfile(String filename){
	
		try {
			RandomAccessFile randomAccessFile=new RandomAccessFile(filename, "rw");
			FileChannel fileChannel=randomAccessFile.getChannel();
			
			//create buffer with capacity of 48 bytes 
			ByteBuffer byteBuffer=ByteBuffer.allocate(48);
			
			int size=fileChannel.read(byteBuffer);//read into buffer.
			while (size>0) {
				//把ByteBuffer从写模式,转换为读取模式
				byteBuffer.flip();//make buffer ready for read
				
				//第一种方式读取,一次读取
				/*Charset charset=Charset.forName("UTF-8");
				System.out.println(charset.newDecoder().decode(byteBuffer).toString());
				byteBuffer.clear();
				size=fileChannel.read(byteBuffer);*/
				
				//第二种方式读取,循环读取
				while(byteBuffer.hasRemaining()){  
					System.out.print((char) byteBuffer.get());// read 1 byte at a time
				} 
				byteBuffer.clear();//make buffer ready for writing
				size=fileChannel.read(byteBuffer);
			}
			fileChannel.close();
			randomAccessFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
