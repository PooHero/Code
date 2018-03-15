package com.hainiu.join;

public class HaiNiuRunnable implements Runnable {

	public void run() {
//		for (int i = 0; i < 500; i++) {
//			System.out.println("HaiNiuRunnable.run() " + i);
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		System.out.println(Thread.currentThread().toString());
	}

}
