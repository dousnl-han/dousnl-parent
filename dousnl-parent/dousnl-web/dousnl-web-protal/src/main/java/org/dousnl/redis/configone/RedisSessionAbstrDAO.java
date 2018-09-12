package org.dousnl.redis.configone;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisSessionAbstrDAO extends AbstractSessionDAO{

	private RedisClient sessionCacheClient=new RedisClient();  
	  
	private static Logger logger = LoggerFactory.getLogger(RedisSessionAbstrDAO.class);
	
    @Override  
    public void update(Session session) throws UnknownSessionException {  
        logger.info("更新seesion,id=[{}]",session.getId().toString());  
         try {    
                sessionCacheClient.replace(session.getId().toString(), session);    
            } catch (Exception e) {    
               e.printStackTrace();   
            }    
    }  
  
    @Override  
    public void delete(Session session) {  
        logger.info("删除seesion,id=[{}]",session.getId().toString());  
         try {    
                sessionCacheClient.delete(session.getId().toString());    
            } catch (Exception e) {    
               e.printStackTrace();   
            }    
          
    }  
  
    @Override  
    public Collection<Session> getActiveSessions() {  
        logger.info("获取存活的session");  
         return Collections.emptySet();   
    }  
  
    @Override  
    protected Serializable doCreate(Session session) {  
        Serializable sessionId = generateSessionId(session);    
        assignSessionId(session, sessionId);    
        logger.info("创建seesion,id=[{}]",session.getId().toString());  
        try {    
            sessionCacheClient.set(sessionId.toString(),  session);    
        } catch (Exception e) {    
            logger.error(e.getMessage());    
        }    
        return sessionId;    
    }  
  
    @Override  
    protected Session doReadSession(Serializable sessionId) {  
          
        logger.info("获取seesion,id=[{}]",sessionId.toString());  
        Session session = null;    
        try {    
            session = (Session) sessionCacheClient.get(sessionId.toString());    
        } catch (Exception e) {    
            logger.error(e.getMessage());    
        }    
        return session;    
    }  
}  
