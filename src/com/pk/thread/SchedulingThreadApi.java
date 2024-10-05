package com.pk.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * The following TestThread program shows usage of ScheduledExecutorService interface in thread based 
 * environment to schedule a task to run after 2 seconds at interval of 2 seconds in time period 
 * of 10 seconds showcasing usage of scheduleAtFixedRate() and schedule() methods.
 */
public class SchedulingThreadApi {
	
	
	public static void main(final String[] arguments) throws InterruptedException {
		
	      final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	      final ScheduledFuture<?> beepHandler = 
	         scheduler.scheduleAtFixedRate(new BeepTask(), 2, 2, TimeUnit.SECONDS);
		      //scheduler.scheduleAtFixedDelay(new BeepTask(), 2, 2, TimeUnit.SECONDS);
		      //scheduler.schedule(new BeepTask(), 2, TimeUnit.SECONDS);

	      scheduler.schedule(new Runnable() {

	         @Override
	         public void run() {
	            beepHandler.cancel(true);
	            scheduler.shutdown();			
	         }
	      }, 10, TimeUnit.SECONDS);
	   }

	   static class BeepTask implements Runnable {
	      
	      public void run() {
	         System.out.println("beep");      
	      }
	   }
	}