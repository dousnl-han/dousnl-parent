package org.dousnl.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.dousnl.api.domain.User;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;

/**
 * Redis client测试
 * @author hanliang
 *
 */
public class RedisDemo_1 {

	@Test
	public void redisTest(){
		Jedis j=new Jedis("10.60.221.147", 6379);
		Map<String, String> map=new HashMap<String,String>();
		final String USER_AGE_25="USER_AGE_25";
		User u1=new User("z1", 18);
		String u1d=UUID.randomUUID().toString();
		map.put(u1d, JSON.toJSONString(u1));
		User u2=new User("z2", 20);
		String u2d=UUID.randomUUID().toString();
		map.put(u2d, JSON.toJSONString(u2));
		User u3=new User("z3", 25);
		String u3d=UUID.randomUUID().toString();
		map.put(u3d, JSON.toJSONString(u3));
		j.sadd("USER_AGE_25", u3d);
		User u4=new User("w5", 26);
		String u4d=UUID.randomUUID().toString();
		map.put(u4d, JSON.toJSONString(u4));
		User u5=new User("w6", 25);
		String u5d=UUID.randomUUID().toString();
		map.put(u5d, JSON.toJSONString(u5));
		j.hmset("SYS_USER_SEL",map);
		
		Set<String> string2 = j.smembers("USER_AGE_25");
		//Set<String> sinter = j.sinter("SYS_USER_SEL","USER_AGE_25");
		for (String string : string2) {
			System.out.println("key--value=="+string);
			System.out.println("string2:"+string2);
			String hget = j.hget("SYS_USER_SEL", string);
			System.out.println("hget:"+hget);
		}
		// System.out.println("string2"+string2);
	}
}
