package com.dousnl.webservice.axisclient;


import com.dousnl.webservice.axisclient.GreetingImplServiceStub.FindUserByIdResponse;
import com.dousnl.webservice.axisclient.GreetingImplServiceStub.FindUserByIdResponseE;
import com.dousnl.webservice.axisclient.GreetingImplServiceStub.GetAllUserResponse;
import com.dousnl.webservice.axisclient.GreetingImplServiceStub.GetAllUserResponseE;
import com.dousnl.webservice.axisclient.GreetingImplServiceStub.GreetingResponse;
import com.dousnl.webservice.axisclient.GreetingImplServiceStub.GreetingResponseE;
import com.dousnl.webservice.axisclient.GreetingImplServiceStub.User;

public class Axis2ClientTest {

	/*public static void main(String[] args) throws Exception {
		GreetingImplServiceStub stub=new GreetingImplServiceStub();
		
		*//**
		 * sayHello
		 *//*
		GreetingImplServiceStub.GreetingE greeting0=new GreetingImplServiceStub.GreetingE();
		GreetingImplServiceStub.Greeting greeting=new GreetingImplServiceStub.Greeting();
		greeting.setArg0("小明");
		greeting0.setGreeting(greeting);		
		GreetingResponseE greeting2 = stub.greeting(greeting0);
		GreetingResponse greetingResponse = greeting2.getGreetingResponse();
		String get_return3 = greetingResponse.get_return();
		System.out.println("server revecie message:"+get_return3);
		*//**
		 * 获取所有用户
		 *//*
		GreetingImplServiceStub.GetAllUserE allUser=new GreetingImplServiceStub.GetAllUserE();
		GreetingImplServiceStub.GetAllUser user=new GreetingImplServiceStub.GetAllUser();
		allUser.setGetAllUser(user);
		
		GetAllUserResponseE allUser2 = stub.getAllUser(allUser);
		GetAllUserResponse getAllUserResponse = allUser2.getGetAllUserResponse();
		User[] get_return = getAllUserResponse.local_return;
		for(int i=0;i<get_return.length;i++){
			System.out.println(get_return[i].getId());
			System.out.println(get_return[i].getName());
			System.out.println(get_return[i].getAge());
		}
		*//**
		 * 根据索引获取用户
		 *//*
		GreetingImplServiceStub.FindUserByIdE findUserByIdE=new GreetingImplServiceStub.FindUserByIdE();
		GreetingImplServiceStub.FindUserById param=new GreetingImplServiceStub.FindUserById();
		param.setArg0(1);
		findUserByIdE.setFindUserById(param);
		FindUserByIdResponseE findUserById = stub.findUserById(findUserByIdE);
		FindUserByIdResponse findUserByIdResponse = findUserById.getFindUserByIdResponse();
		User get_return2 = findUserByIdResponse.get_return();
		System.out.println("id:"+get_return2.getId());
		System.out.println("name:"+get_return2.getName());
		System.out.println("age:"+get_return2.getAge());
	}*/
}
