package com.rabi.multithread;

public class Consumer 
     implements Runnable{
	Q q;
	public Consumer(Q q) {
		super();
		this.q = q;
	}
	@Override
	public void run() {
		while(true) {
		q.getNum();
		try {Thread.sleep(1000);
			}catch (Exception e) {}
		}
		
	}
}

