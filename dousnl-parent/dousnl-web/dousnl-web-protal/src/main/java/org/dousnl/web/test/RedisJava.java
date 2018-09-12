package org.dousnl.web.test;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @author hanliang
 * Redis 本地测试
 */
public class RedisJava {
	
	public static void main(String[] args) {
        //连接本地 Redis 服务
		Jedis  jedis=new Jedis("127.0.0.1");
		System.out.println("Redis connection is sucessfully!");
		//查看服务是否运行
		System.out.println("Server is running:"+jedis.ping());
		//设置Redis string数据
		jedis.set("runoobkey", "Redis tutorial");
		System.out.println("Stored string in redis::"+jedis.get("runoobkey"));
	    //设置Redis list数据
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
		jedis.lpush("tutorial-list", "Oracle");
		jedis.lpush("tutorial-list", "DB2");
		jedis.lpush("tutorial-list", "SqlServer");
		jedis.lpush("tutorial-list", "Nosql");
		//获取数据并输出
		List<String> list=jedis.lrange("tutorial-list", 0, 4);
		for(String s:list){
			System.out.println("Stored string in redis:: "+s);
		}
		//获取所有数据输出
		Set<String> listAll=jedis.keys("*");
		for(String string:listAll){
			System.out.println("List of stored keys:: "+string);
		}
	}

}
