package com.hainiu.thread;

public class HaiNiuRunnable implements Runnable {
	Object obj = new Object();
	static boolean b = true;
	
	public void run() {
		//System.out.println(Thread.currentThread().getName() + " -----run");
		if (b) {
			System.out.println(" -----if");
			synchronized (obj) {
				System.out.println(Thread.currentThread().getName() + " -----obj");
				while (true) {
					
				}
			}
		}else{
			System.out.println(" -----else");
			//show();
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + " -----obj");
				while (true) {
					
				}
			}
		}
		
	}

	public synchronized void show() {
		System.out.println(Thread.currentThread().getName() + " -----show");
		while (true) {
			
		}
	}
}
