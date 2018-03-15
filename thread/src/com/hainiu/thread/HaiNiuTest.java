package com.hainiu.thread;


public class HaiNiuTest {
	public static void main(String[] args) {
		HaiNiuRunnable runn = new HaiNiuRunnable();
		new Thread(runn,"张三").start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HaiNiuRunnable.b = false;
		new Thread(runn,"李四").start();
		//new Thread(runn,"王五").start();
		System.out.println("main -----gg");
	}
}
