package com.rabi.multithread.executorservice.blockingQueue.interview;

import java.util.concurrent.BlockingQueue;

public class InterviewProcessorConsumer 
     implements Runnable{
	BlockingQueue<String> q;
	public InterviewProcessorConsumer(BlockingQueue<String> q) {
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
				}
		//}
		
	}
	private void process() throws InterruptedException {
		String take ;
		while(!(take=q.take()).equals("STOP")) {
		System.out.println(" Intervew completed for [Consumer] Take : " + take);
		Thread.sleep(1000);
		}
		System.out.println("Interview completed for all candidate");
	}
}

