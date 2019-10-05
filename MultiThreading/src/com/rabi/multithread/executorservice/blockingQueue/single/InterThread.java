package com.rabi.multithread.executorservice.blockingQueue.single;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class InterThread {

	public static void main(String[] args) {
		/*Q q=new Q();
		 */
		BlockingQueue<Integer> q=new LinkedBlockingQueue<>(5);
		invokeByNormalThread(q); 
		
		//invokeByExecutor(q);
		 
		 
		  
	}

	private static void invokeByNormalThread(BlockingQueue<Integer> q) {
		Thread tprod =new Thread(
				new Producer(q),"Producer...");
	 Thread tconsu=new Thread(
				new Consumer(q),"Consumer...");
	tprod.start();
	tconsu.start();
	}

	private static void invokeByExecutor(BlockingQueue<Integer> q) {
		ExecutorService exeProd = Executors.newFixedThreadPool(5);
		 ExecutorService exeCons = Executors.newFixedThreadPool(5);
		 
		 exeProd.submit(new Producer(q));
		 exeCons.submit(new Consumer(q));
	}

}
