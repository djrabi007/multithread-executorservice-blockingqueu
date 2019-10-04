package com.rabi.multithread;

public class InterThread {

	public static void main(String[] args) {
		Q q=new Q();
		Thread tprod =new Thread(
						new Producer(q),"Producer...");
		Thread tconsu=new Thread(
						new Consumer(q),"Consumer...");
		tprod.start();
		tconsu.start();
	}

}
