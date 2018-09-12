package org.dousnl.netty.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestUserInfo {

	public static void main(String[] args) throws IOException {
		UserInfo user=new UserInfo();
		user.buildUserId(100).buildUserName("Weclome to Netty");
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream os=new ObjectOutputStream(bos);
	    os.writeObject(user);
	    os.flush();
	    os.close();
	    byte [] b=bos.toByteArray();
	    System.out.println("ths jdk serializable length is :" +b.length);
	    bos.close();
	    System.out.println("----------------------------------------");
	    System.out.println("ths byte serializable length is :" +user.codeC().length);
	}
}
