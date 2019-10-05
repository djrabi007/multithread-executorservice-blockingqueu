package com.rabi.multithread.executorservice.singleThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class InterThread {

	public static void main(String[] args) {

		BlockingQueue<Integer> q = new LinkedBlockingQueue<>(5);
		invokeByNormalThread(q);
		// invokeByExecutor(q);
		int numofCore = Runtime.getRuntime().availableProcessors();
        String presentThread=Thread.currentThread().getName();
		System.out.println("Thread Name : " + presentThread 
				+ "--Processor=" + numofCore);

	}

	private static void invokeByNormalThread(BlockingQueue<Integer> q) {
		// ##Producer##... as Threadname ..else Thread-0
		Thread tprod = new Thread(new Producer(q), "##Producer##");
		tprod.start();
		// Thread-0 as Threadname
		// Thread tprod =new Thread(new Producer(q));

	}

	private static void invokeByExecutor(BlockingQueue<Integer> q) {
		ExecutorService exeProd = Executors.newFixedThreadPool(5);
		exeProd.submit(new Producer(q));
	}

}
