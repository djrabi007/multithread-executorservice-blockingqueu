package com.rabi.multithread.executorservice.threadpool.non.cpu;

import java.util.concurrent.BlockingQueue;

public class IOIntensiveTask 
			implements Runnable {
	BlockingQueue<Integer> q;
	
	public IOIntensiveTask(BlockingQueue<Integer> q) {
		super();
		this.q = q;
	}
	@Override
	public void run() {
		System.out.println("Thread Name : "
					+Thread.currentThread().getName());	 
			 
		//while(true) {
		try {
			process();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		//} 
	  }
		
	}
	private void process() throws InterruptedException {
		
		// Put 20 ints into Queue
        for (int i = 0; i < 10; i++) {
		q.put(i);
		System.out.println("[Producer] Put : " + i);
		Thread.sleep(1000);
        }
	}

}
