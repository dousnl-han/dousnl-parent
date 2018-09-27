package com.dousnl.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Cotroller多例模式
 * @author hanliang
 *
 */
@Scope(value="prototype")
@Controller
public class SingletonTestController {

	private int singleton=1;
	
	@RequestMapping("singleton")
	@ResponseBody
	public String singleTest(HttpServletRequest request,HttpServletResponse response){
		String data=request.getParameter("data");
        if(data!=null&&data.length()>0){
            try{
             int paramInt= Integer.parseInt(data);
             singleton = singleton + paramInt;
            }
            catch(Exception ex){
            	singleton+=10;
            }
        }else{
        	singleton+=1000;
        }
        return String.valueOf(singleton);
   }
}
