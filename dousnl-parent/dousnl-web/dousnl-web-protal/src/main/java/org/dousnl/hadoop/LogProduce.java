package org.dousnl.hadoop;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class LogProduce {

	public static void main(String[] args) throws IOException {
		String [] remote_add={"124.109.222.29","124.19.222.29",
				"124.119.22.59","125.119.222.39"};
		String [] rt_time={"21","29","12","35","23","213","562"};
		String [] request_method={"GET","POST"};
		String [] request_url={"www.xxx.com/index.htm","www.xxx.com/list.htm",
				"www.xxx.com/detail.htm","www.xxx.com/userinfo.htm","www.xxx.com/publish.htm"};
		String [] refer={"www.google.com","www.baidu.com","www.taotao.com","www.qq.com","www.sina.com"};
		String [] status={"200","301","302","404","500"};
		String [] send_bytes={"3344","2789","490","439274","80834"};
		File file=new File("D:/ccc.f");
        for(int i=0;i<10000;i++){
        	String line=getOne(remote_add)+getOne(rt_time)+getOne(request_method)
        	+getOne(request_url)+getOne(refer)+getOne(status)+getOne(send_bytes);
        	ArrayList<String> lines=new ArrayList<String>();
        	lines.add(line);
        	FileUtils.writeLines(file, lines, true);
        }
	}

	private static String getOne(String[] array) {
	    int length=array.length;
	    Random r=new Random();
	    int rand=r.nextInt(length);
	    return array[rand]+" ";
	}

}
