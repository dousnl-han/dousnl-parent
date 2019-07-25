package com.dousnl.redis;

import com.alibaba.fastjson.JSON;
import com.dousnl.activemq.User;
import redis.clients.jedis.Tuple;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArticleThumbsUpRedisTest {

	public static void main(String[] args) {

		// 连接Redis
		redis.clients.jedis.Jedis jedis = new redis.clients.jedis.Jedis("172.16.5.61");
		System.out.println("success");

		// 创建4篇文章,用hash存储
		jedis.hset("article:00001", "title", "文章1");
		jedis.hset("article:00002", "title", "文章2");
		jedis.hset("article:00003", "title", "文章3");
		jedis.hset("article:00004", "title", "文章4");
		Map<String, String> stringStringMap = jedis.hgetAll("article:00004");
		System.out.println(stringStringMap);

		// 创建一个有序集合，用来存文章的点赞排名。
		jedis.zadd("score", 0, "article:00001");
		jedis.zadd("score", 0, "article:00002");
		jedis.zadd("score", 0, "article:00003");
		jedis.zadd("score", 0, "article:00004");
		System.out.println("文章获取到的"
				+ jedis.zrange("score", 0, -1).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

		// 现在模拟用户点赞。
		// 用户点赞就在该文章的基础上+1
		jedis.zincrby("score", 1, "article:00001");
		jedis.zincrby("score", 1, "article:00002");
		jedis.zincrby("score", 1, "article:00004");
		jedis.zincrby("score", 1, "article:00003");
		jedis.zincrby("score", 1, "article:00001");
		jedis.zincrby("score", 1, "article:00001");
		jedis.zincrby("score", 1, "article:00002");
		jedis.zincrby("score", 1, "article:00002");
		jedis.zincrby("score", 1, "article:00004");
		jedis.zincrby("score", 1, "article:00004");
		jedis.zincrby("score", 1, "article:00004");
		jedis.zincrby("score", 1, "article:00004");
		jedis.zincrby("score", -1, "article:00004");

		// 打印输出的list

		Set<Tuple> score1 = jedis.zrevrangeWithScores("score", 0, -1);
		for (Tuple t : score1) {
			System.out.println(t.getElement() + ":" + t.getScore());
		}
		/*jedis.setbit("like_photo:100", 1000, 1, function(err, ret){
		});*/
		long start = System.currentTimeMillis();
		System.out.println(start);
		jedis.setbit("like_photo:100", 1000, true);
		jedis.setbit("like_photo:100", 999, true);
		jedis.setbit("like_photo:100", 998, true);
		jedis.setbit("like_photo:100", 997, true);
		jedis.setbit("like_photo:100", 996, true);
		Boolean getbit = jedis.getbit("like_photo:100", 1001);
		if(getbit){
			System.out.println("已经点过赞..");
			jedis.setbit("like_photo:100", 1000, false);
		}else{
			System.out.println("未点过赞..");
		}
		Long bitcount = jedis.bitcount("like_photo:100");
		System.out.println("bitcount:"+bitcount);
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("时间:"+(end-start)+"ms");
		
		Map<String, String> map = new HashMap<String, String>();
        map.put("build:0:"+0,  "0");
        map.put("build:1:"+1,  "1");
        map.put("build:2:"+2,  "2");
		jedis.hmset("hashkey", map);
		
		Map<String, String> hgetAll = jedis.hgetAll("hashkey");
		System.out.println("hgetAll:"+JSON.toJSONString(hgetAll));
		Long hdel = jedis.hdel("hashkey", "build:0:"+"*");
		System.out.println("hdel:"+hdel);
		Set<String> hkeys = jedis.hkeys("build:0:"+"*");
		System.out.println("hkeys:"+hkeys);
		System.out.println("hgetAllNew:"+JSON.toJSONString(jedis.hgetAll("hashkey")));
		
		User u=new User();
	}

}
