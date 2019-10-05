package com.rabi.multithread.executorservice.multipleThread;

import java.util.concurrent.BlockingQueue;

public class Producer 
			implements Runnable {
	BlockingQueue<Integer> q;
	
	public Producer(BlockingQueue<Integer> q) {
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
