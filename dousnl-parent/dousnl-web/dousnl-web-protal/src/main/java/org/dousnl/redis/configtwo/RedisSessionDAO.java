package org.dousnl.redis.configtwo;
import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.dousnl.redis.configtwo.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis实现共享session
 */
@Component
public class RedisSessionDAO extends EnterpriseCacheSessionDAO {

    private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

    // session 在redis过期时间是30分钟30*60
    private static int expireTime = 1800;

    private static String prefix = "weiyou-shiro-session:";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    
    private RedisClient sessionCacheClient=new RedisClient();

    // 创建session，保存到数据库
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        logger.debug("创建session:{}", session.getId());
        //redisTemplate.opsForValue().set(prefix + sessionId.toString(), session);
        try {    
            sessionCacheClient.set(sessionId.toString(),  session);    
        } catch (Exception e) {    
        	logger.error(e.getMessage());    
        }    
        return sessionId;
    }

    // 获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.debug("获取session:{}", sessionId);
        // 先从缓存中获取session，如果没有再去数据库中获取
        Session session = super.doReadSession(sessionId);
        /*if (session == null) {
            session = (Session) redisTemplate.opsForValue().get(prefix + sessionId.toString());
        }*/
        try {    
            session = (Session) sessionCacheClient.get(sessionId.toString());    
        } catch (Exception e) {    
        	logger.error(e.getMessage());    
        }
        return session;
    }

    // 更新session的最后一次访问时间
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        logger.debug("获取session:{}", session.getId());
        String key = prefix + session.getId().toString();
        if (!redisTemplate.hasKey(key)) {
            //redisTemplate.opsForValue().set(key, session);
        }
        //redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        try {    
            sessionCacheClient.replace(session.getId().toString(), session);    
        } catch (Exception e) {    
           e.printStackTrace();   
        }  
    }

    // 删除session
    @Override
    protected void doDelete(Session session) {
        logger.debug("删除session:{}", session.getId());
        super.doDelete(session);
        //redisTemplate.delete(prefix + session.getId().toString());
        try {    
            sessionCacheClient.delete(session.getId().toString());    
        } catch (Exception e) {    
           e.printStackTrace();   
        } 
    }
}