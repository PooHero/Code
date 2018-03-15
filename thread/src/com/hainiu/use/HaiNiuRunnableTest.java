package com.hainiu.use;

public class HaiNiuRunnableTest implements Runnable {

	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+"	进入到了锁");
			// 唤醒别人
			notify();
			System.out.println(Thread.currentThread().getName()+"	唤醒了另一个线程");
			try {
				System.out.println(Thread.currentThread().getName()+"	开始等待");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"	结束了等待");
	}

}
