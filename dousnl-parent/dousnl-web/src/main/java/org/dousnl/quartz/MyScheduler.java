/*package org.dousnl.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

	@Autowired
	SchedulerFactoryBean schedulerFactoryBean;
	
	public void scheduleJobs() throws SchedulerException{
		Scheduler scheduler=schedulerFactoryBean.getScheduler();
		startJob1(scheduler); 
        //startJob2(scheduler); 
	}
	
	private void startJob1(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class) .withIdentity("job1", "group1").build(); 
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?"); 
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") .withSchedule(scheduleBuilder).build(); 
        //
        boolean flag = scheduler.checkExists(jobDetail.getKey());
        System.out.println("job 是否已存在："+flag);
	    if(!flag){
	        //scheduler.start();
	        scheduler.scheduleJob(jobDetail, cronTrigger);
	    }
	    else
	    {
	    	CronTrigger trigger1 =TriggerBuilder.newTrigger().withIdentity("schedulerJobTrigger1", "group1").withSchedule(scheduleBuilder).build();
	        scheduler.start();
	        scheduler.scheduleJob(jobDetail, trigger1);
	    }
    } 
    private void startJob2(Scheduler scheduler) throws SchedulerException{ 
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class) .withIdentity("job2", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?"); 
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1") .withSchedule(scheduleBuilder).build(); 
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }
}
*/