package org.dousnl.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ISayHello {

	@WebMethod
	public String sayHello(String name);
}
