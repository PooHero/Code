package com.hainiu.level;

/**
 * @author puxiongxiong
 * 
 *         线程的优先级
 * 
 */
public class HaiNiuThreadLevel implements Runnable {
	int i = 0;
	public void run() {
		System.out.println(Thread.currentThread().getName() + " level "
				+ Thread.currentThread().getPriority());
		for (; i <= 1000; i++) {
			if (Thread.currentThread().getPriority() == 1) {
				System.out.println(i);
			}
		}
	}

}
