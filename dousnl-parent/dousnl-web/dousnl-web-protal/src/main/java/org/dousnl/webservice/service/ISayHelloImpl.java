package org.dousnl.webservice.service;

import javax.jws.WebService;

@WebService
public class ISayHelloImpl implements ISayHello {

	@Override
	public String sayHello(String name) {
		System.out.println("Server Hello :"+name);
		return "hello" +name;
	}

}
