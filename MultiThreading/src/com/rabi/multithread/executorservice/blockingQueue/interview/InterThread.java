package com.rabi.multithread.executorservice.blockingQueue.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class InterThread {

	public static void main(String[] args) {
	//	BlockingQueue<String> q=new LinkedBlockingQueue<>(20);
		BlockingQueue<String> q=new ArrayBlockingQueue<>(3);
		invokeByNormalThread(q); 
		
		//invokeByExecutor(q);
		 
		 
		  
	}

	private static void invokeByNormalThread(BlockingQueue<String> q) {
		Thread tprod =new Thread(
				new InterviewSchedulerProducer(q),"Producer...");
	 Thread tconsu=new Thread(
				new InterviewProcessorConsumer(q),"Consumer...");
	tprod.start();
	tconsu.start();
	}

	private static void invokeByExecutor(BlockingQueue<String> q) {
		ExecutorService exeProd = Executors.newFixedThreadPool(5);
		 ExecutorService exeCons = Executors.newFixedThreadPool(5);
		 
		 exeProd.submit(new InterviewSchedulerProducer(q));
		 exeCons.submit(new InterviewProcessorConsumer(q));
	}

}
