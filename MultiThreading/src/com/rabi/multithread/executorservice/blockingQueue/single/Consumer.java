package com.rabi.multithread.executorservice.blockingQueue.single;

import java.util.concurrent.BlockingQueue;

public class Consumer 
     implements Runnable{
	BlockingQueue<Integer> q;
	public Consumer(BlockingQueue<Integer> q) {
		super();
		this.q = q;
	}
	@Override
	public void run() {
		while(true) {
				try {
					process();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
		}
		
	}
	private void process() throws InterruptedException {
		Integer take =q.take();
		System.out.println("[Consumer] Take : " + take);
		Thread.sleep(1000);
	}
}

