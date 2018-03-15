package com.hainiu.yield;

public class HaiNiuRunnable implements Runnable {
	int i = 0;

	public void run() {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 卖出去 " + i);
			Thread.yield();
		}
	}

}
