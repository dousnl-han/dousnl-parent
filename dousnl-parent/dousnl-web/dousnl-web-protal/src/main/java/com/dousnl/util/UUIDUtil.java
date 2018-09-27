package com.dousnl.util;

import java.util.UUID;

public class UUIDUtil {

	public static void main(String[] args) {
		String uid = UUID.randomUUID().toString();
		//UUID uuid = UUID.randomUUID();
		//System.out.println("UUID:"+uuid);
		System.out.println("uid:"+uid);
		uid = uid.replaceAll("-", "");
		System.out.println("UUID:"+uid);
		System.out.println("UUID:"+UUID.randomUUID().toString().replaceAll("-", ""));
        if("button".equals(EnumUtil.Type.button)){
        	System.out.println("EnumUtil.Type.button:"+EnumUtil.Type.button);
        }else{
        	System.out.println("false:"+EnumUtil.Type.button);
        }
	}

}
