package com.dousnl.fastjson;

import com.dousnl.api.domain.User;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonTest {

	public static void main(String[] args) {
		User u=new User();
        u.setAge(20);
        String jsonString = JSON.toJSONString(u,SerializerFeature.WriteMapNullValue);
       System.out.println("JSON:"+jsonString);
	}

}
