package com.itqf.quartz.demo;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Demo {
	public static void main(String[] args) throws SchedulerException {
		//1.创建一个job
		//2.创建jobdetail
		JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob").build();
		//3.设置trigger
		SimpleScheduleBuilder repeatForever = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
		SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger").startNow().withSchedule(repeatForever).build();
		//4.创建调度容器
		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.scheduleJob(jobDetail,trigger );
		scheduler.start();//启动调度任务
		System.out.println("11111111111111");
		System.out.println("222222222222222");
	}
}
