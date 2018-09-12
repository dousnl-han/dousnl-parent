/*package org.dousnl.quartz;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig implements ApplicationListener<ApplicationEvent>{
	@Autowired
    public MyScheduler myScheduler;
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		try { 
            myScheduler.scheduleJobs(); 
        } catch (SchedulerException e) { 
            e.printStackTrace(); 
        }
	}
	@Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean(); 
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        return schedulerFactoryBean; 
    }

}
*/