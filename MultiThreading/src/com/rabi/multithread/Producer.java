package com.rabi.multithread;

public class Producer 
			implements Runnable {
	Q q;
	
	public Producer(Q q) {
		super();
		this.q = q;
	}
	@Override
	public void run() {
		int i=0;
		while(true) {
		q.setNum(i++);
		try {Thread.sleep(1000); }
			catch (Exception e) {}
		}
		
	}

}
