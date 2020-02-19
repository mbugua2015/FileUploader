package com.fileuploader;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class FileUploaderApp {
	public static void main(String[] args) {
		System.out.println("Starting Mbugua File Uploader....");
		
		try{
			SchedulerFactory schedulerFactory= new StdSchedulerFactory();
			Scheduler scheduler= schedulerFactory.getScheduler();
			scheduler.start();
			
			JobDetail job = newJob(FileUploaderJob.class)
					.withIdentity("myJob", "group1")
					.build();
			
			Trigger trigger = newTrigger()
					.withIdentity("myTrigger", "group1")
					.startNow()
					.withSchedule(simpleSchedule()
							.withIntervalInSeconds(20)
							.repeatForever())
					.build();
			
			scheduler.scheduleJob(job,trigger);
		}
		catch (Exception ex){
			Utility.logStackTrace(ex);
		}
	}
}
