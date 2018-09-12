package org.dousnl.aop;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.dousnl.annotation.Log;
import org.dousnl.annotation.LogConfig;
import org.dousnl.aop.mapper.TLogRecordMapper;
import org.dousnl.shiro.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect   //定义一个切面
//@Configuration
public class LogAopConfig {

	@Autowired
	private TLogRecordMapper logRecordMapper;
	
	// 定义切点Pointcut
    @Pointcut("execution(* org.dousnl.web.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void excudeService() {
    }

    @Around("excudeService()")
	public void before(JoinPoint joinPoint){
		//获取Http请求
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//获取目标类
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		Class<?> targetClass = method.getDeclaringClass();
		//日志记录
		if(targetClass.isAnnotationPresent(Controller.class) && targetClass.isAnnotationPresent(LogConfig.class) && method.isAnnotationPresent(Log.class)){
			TLogRecord logRecord=new TLogRecord();
			LogConfig logConfig = targetClass.getAnnotation(LogConfig.class);
			//系统类型
			logRecord.setSystemType(logConfig.systemType());
			//所属模块
			logRecord.setModule(logConfig.moudle());
			//所属模块名称
			logRecord.setModuleName(logConfig.moudleName());
			
			Log log = method.getAnnotation(Log.class);
			//方法值
			logRecord.setMethod(log.value());
			//方法名
			logRecord.setMethodName(log.name());
			
			logRecord.setId(UUID.randomUUID().toString().replace("-", ""));
			logRecord.setIp(getIpAddr(request));
			logRecord.setUrl(request.getRequestURI());
			logRecord.setDate(new Date());
			logRecord.setUserid("catest_aop");
			logRecord.setUsername("catest_aop");
			logRecordMapper.insertSelective(logRecord);
		}
	}
	/**
	 * 获取当前登录用户ID
	 */
	public String getUserId() {
		String userId = "anonymousUser";
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		//Object a = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof String){
		}else{
			User userInfo = (User) principal;
			userId = String.valueOf(userInfo.getId());
		}
		return userId;
	}
	/**
	 * 获取当前登录用户名
	 */
	public String getUsername() {
		String username="";
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		if(principal instanceof String){
		}else{
			User userInfo = (User) principal;
			username = userInfo.getUsername();
		}
		return username;
	}
	/** 
     * 获取当前网络ip 
     * @param request 
     * @return 
     */  
    public String getIpAddr(HttpServletRequest request){  
        String ipAddress = request.getHeader("x-forwarded-for");  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getRemoteAddr();  
                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                    //根据网卡取本机配置的IP  
                    InetAddress inet=null;  
                    try {  
                        inet = InetAddress.getLocalHost();  
                    } catch (UnknownHostException e) {  
                        e.printStackTrace();  
                    }  
                    ipAddress= inet.getHostAddress();  
                }  
            }  
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
                if(ipAddress.indexOf(",")>0){  
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
                }  
            }  
            return ipAddress;   
    }
}
