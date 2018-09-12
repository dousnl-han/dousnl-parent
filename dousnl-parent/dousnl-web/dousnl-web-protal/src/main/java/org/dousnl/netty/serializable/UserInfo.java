package org.dousnl.netty.serializable;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private int userId;
	
	public UserInfo buildUserName(String username){
		this.username=username;
		return this;
	}
	public UserInfo buildUserId(int userId){
		this.userId=userId;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public byte[] codeC(){
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		byte [] value=this.username.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(this.userId);
		buffer.flip();
		value=null;
		byte [] result=new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}
}
