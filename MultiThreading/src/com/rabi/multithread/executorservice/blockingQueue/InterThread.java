package com.rabi.multithread.executorservice.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class InterThread {

	public static void main(String[] args) {
		/*Q q=new Q();
		 Thread tprod =new Thread(
					new Producer(q),"Producer...");
		 Thread tconsu=new Thread(
					new Consumer(q),"Consumer...");
		tprod.start();
		tconsu.start();*/
		BlockingQueue<Integer> q=new LinkedBlockingQueue<>(10);
		 ExecutorService exeProd = Executors.newFixedThreadPool(5);
		 ExecutorService exeCons = Executors.newFixedThreadPool(5);
		 
		 exeProd.submit(new Producer(q));
		 exeCons.submit(new Consumer(q));
		  
	}

}
