package org.dousnl.autoconfig;

public class HelloServer {

	private String msg;
	
	public String sayHello(){
		return "hello"+msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
