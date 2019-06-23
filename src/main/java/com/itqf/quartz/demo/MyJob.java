package com.itqf.quartz.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		System.out.println("定时执行时间：" + time);
	}
}
