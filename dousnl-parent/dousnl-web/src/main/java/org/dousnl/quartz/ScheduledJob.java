/*package org.dousnl.quartz;

import java.util.Date;

import org.dousnl.api.service.HelloService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.dubbo.config.annotation.Reference;

public class ScheduledJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

	@Reference(version="1.0.0")
	private HelloService helloService;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("AAAA: The time is now " + new Date()); 
		System.out.println(helloService.speakHello("say goodbay!!"));
	}

}
*/