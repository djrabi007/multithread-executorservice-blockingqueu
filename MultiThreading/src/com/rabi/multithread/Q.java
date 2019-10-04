package com.rabi.multithread;

public class Q {
	
	int num;
	boolean isSet;

	public synchronized 
			int getNum() {
		while(!isSet) {
			try { wait(); }catch (Exception e) {}	
			}
		System.out.println("GET num= "+num);
		isSet=false;
		notify();
		return num;
	}

	public synchronized 
			void setNum(int num) {
		while(isSet) {
		try { wait(); }catch (Exception e) {}	
		}
		this.num = num;
		isSet=true;
		System.out.println("SET num= "+num);
		notify();
	}
	

}
