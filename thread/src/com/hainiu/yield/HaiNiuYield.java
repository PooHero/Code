package com.hainiu.yield;
/**
 * @author puxiongxiong
 * 暂停当前线程对象的执行，交给CPU，让CPU重新选择线程的执行
 * 让CPU重新选择，只有在对方线程优先级高于或等于自己的时候才有效
 */
public class HaiNiuYield {
	public static void main(String[] args) throws InterruptedException {
		Runnable runn = new HaiNiuRunnable();
		Thread th1 = new Thread(runn,"李大章--- ");
		Thread th2 = new Thread(runn,"jack+++ ");
//		th1.setPriority(4);
//		th2.setPriority(8);
		th1.start();
		th2.start();
		System.out.println("main -----gg");
	}
}
