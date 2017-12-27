package com.yuan.quartz;

import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Test {

	public static void main(String[] args) {
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//			scheduler.start();
			JobDetail job = JobBuilder.newJob(JobTest.class)
					.withIdentity("job1","group1")
					.build();
			
			Trigger trigger = newTrigger()
					.withIdentity("trigger1", "group1")
					.startNow()
//					.withSchedule(simpleSchedule()
//							.withIntervalInSeconds(3)
//							.repeatForever())
					.withSchedule(cronSchedule("0 1 15 * * ?"))  //每天几点运行
					.build();
			
			scheduler.scheduleJob(job,trigger);
			scheduler.start();
			
//			Thread.sleep(10000);
//			System.out.println("休息完成");
//			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		
	}
}
