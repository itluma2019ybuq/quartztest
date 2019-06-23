package com.itqf.quartz.demo;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Demo2 {
	public static void main(String[] args) throws SchedulerException {
		//1.创建一个job
		//2.创建jobdetail
		JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob").build();
		//3.设置trigger
		
		//SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger").startNow().withSchedule(repeatForever).build();
		//cron表达式：秒	分	时	天	月	周  
		//0 40 15 * * *
		//0 * 14 * * ?  14:00: 00 ~ 14:59:00
		//"0 0/5 14 * * ? 14:00:00  14:05:00 14:10:00  14:15:00 14:20:00  25 30 35 40 45 50 55
		CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("* 42 15 * * ?");//
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("cronTrigger").withSchedule(cronSchedule).build();
		
		//4.创建调度容器
		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.scheduleJob(jobDetail,trigger );
		scheduler.start();//启动调度任务
		
	}
}
