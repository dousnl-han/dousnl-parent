package test;

import com.dousnl.framework.security.domain.User;

public class NullPointTest {

	public static void main(String[] args) {

		User u=new User();
		if(u.getPassword().equals("dsad")){
			System.out.println("null");
		}
		
	}

}
