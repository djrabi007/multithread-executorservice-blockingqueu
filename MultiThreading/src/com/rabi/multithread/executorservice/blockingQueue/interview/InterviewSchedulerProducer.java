package com.rabi.multithread.executorservice.blockingQueue.interview;

import java.util.concurrent.BlockingQueue;

public class InterviewSchedulerProducer 
			implements Runnable {
	private static final String INTERVIEW_SCHEDULED_FOR_PRODUCER_PUT = " Interview Scheduled for [Producer] Put : ";
	private static final String CANDIDATE = "CANDIDATE #";
	BlockingQueue<String> q;
	
	public InterviewSchedulerProducer(BlockingQueue<String> q) {
		super();
		this.q = q;
	}
	@Override
	public void run() {
		//while(true) {
		try {
			process();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		//} 
	  }
		
	}
	private void process() throws InterruptedException {
		
		System.out.println("10 candidate has arrived!!");
		// Put 20 ints into Queue
        for (int i = 0; i < 10; i++) {
		q.put(CANDIDATE+i);
		System.out.println(INTERVIEW_SCHEDULED_FOR_PRODUCER_PUT 
				+ CANDIDATE+i);
		Thread.sleep(1000);
        }
        stop();
        
	}
	private void stop() throws InterruptedException {
		q.put("STOP");
        System.out.println("Interview Scheduled for all candidate!!");
	}

}
