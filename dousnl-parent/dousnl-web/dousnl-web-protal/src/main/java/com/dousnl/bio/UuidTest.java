package com.dousnl.bio;

import java.util.UUID;

public class UuidTest {

	public static void main(String[] args) {

		System.out.println("uuid : "+UUID.randomUUID().toString().replaceAll("-", ""));
	}

}
