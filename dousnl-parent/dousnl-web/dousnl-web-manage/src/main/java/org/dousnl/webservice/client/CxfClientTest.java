package org.dousnl.webservice.client;

import java.util.List;

import javax.xml.namespace.QName;

public class CxfClientTest {
	
	private static final QName SERVICE_NAME = new QName(
			"http://server.webservice.dousnl.com/", "GreetingImplService");
	
	/*public static void main(String[] args) {
		GreetingImplService service=new GreetingImplService(GreetingImplService.WSDL_LOCATION,SERVICE_NAME);
		Greeting greetingImplPort = service.getGreetingImplPort();
		String greeting = greetingImplPort.greeting("zhang san");
		System.out.println("server say:"+greeting);
		List<User> allUser = greetingImplPort.getAllUser();
		for(User u:allUser){
			System.out.println("Id:"+u.getId());
			System.out.println("Name:"+u.getName());
			System.out.println("Age:"+u.getAge());
		}
	}*/
}
