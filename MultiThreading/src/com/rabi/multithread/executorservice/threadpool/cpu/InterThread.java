package com.rabi.multithread.executorservice.threadpool.cpu;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class InterThread {

	public static void main(String[] args) {

		BlockingQueue<Integer> q = new LinkedBlockingQueue<>(5);
		int numofCore = Runtime.getRuntime().availableProcessors();
		//invokeByNormalThread(q);
		 invokeByExecutor(q,numofCore);
        String presentThread=Thread.currentThread().getName();
		System.out.println("Thread Name : " + presentThread 
				+ "--Processor=" + numofCore);

	}

	private static void invokeByExecutor(BlockingQueue<Integer> q,int numofCore) {
		//ExecutorService exeProd = Executors.newFixedThreadPool(10);
		ExecutorService exeProd = Executors.newFixedThreadPool(numofCore);
		for(int i=0;i<100;i++) {
		exeProd.submit(new CPUIntensiveTask(q));
		}
	}

	private static void invokeByNormalThread(BlockingQueue<Integer> q) {
		// ##Producer##... as Threadname ..else Thread-0
		for(int i=0;i<5;i++) {
			//Thread tprod = new Thread(new Producer(q), "##Producer##");
			Thread tprod = new Thread(new CPUIntensiveTask(q));
			tprod.start();
		}
		// Thread-0 as Threadname
		// Thread tprod =new Thread(new Producer(q));

	}
}
