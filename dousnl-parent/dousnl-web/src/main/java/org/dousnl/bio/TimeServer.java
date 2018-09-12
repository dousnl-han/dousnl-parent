package org.dousnl.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
 
	/*public static void main(String[] args) {
		int port=8088;
		if(args !=null && args.length>0){
			try {
				port=Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				//采用默认值
			}
		}
		ServerSocket server=null;
		try {
			server=new ServerSocket(port);
			System.out.println("The time server is start in port :"+port);
			Socket socket=null;
			//创建I/O任务线程池
			TimeServerHandlerExecutePool singleExecutor=new TimeServerHandlerExecutePool(50, 10000);
			while(true){
				socket=server.accept();
				//new Thread(new TimeServerHandler(socket)).start();
				singleExecutor.execute(new TimeServerHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(server != null){
				System.out.println("The time server is close");
				try {
					server.close();
					server = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}*/
}
