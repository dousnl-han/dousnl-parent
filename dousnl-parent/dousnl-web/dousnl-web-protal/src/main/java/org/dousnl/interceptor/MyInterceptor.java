package org.dousnl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		Long startTime=(Long)arg0.getAttribute("startTime");
	    arg0.removeAttribute("startTime");
	    Long endTime=System.currentTimeMillis();
	    //System.out.println("本次请求处理时间为："+(endTime-startTime));
	    System.out.println("本次请求处理时间为："+new Long(endTime-startTime)+"ms");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		System.out.println("contextPath:"+contextPath+"requestURI:"+requestURI);
		Long startTime=System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

}
