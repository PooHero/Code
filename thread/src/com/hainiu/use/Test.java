package com.hainiu.use;
/**
 * @author puxiongxiong
 * 
 * 等待唤醒机制：
 *   遇到wait方法，当前线程进入沉睡状态
 *   遇到notify方法，唤醒正在沉睡的线程（唤醒的是同一锁内的线程，且对象监视器指的就是锁）
 *   
 * 如果拿到锁，在同步代码块里执行，遇到wait方法，锁会释放，有区别于sleep方法
 */
public class Test {
	static boolean b = false;
	public static void main(String[] args) throws InterruptedException {
		HaiNiuRunnableTest runn = new HaiNiuRunnableTest();
		new Thread(runn,"Jack").start();
		Thread.sleep(1000);
		new Thread(runn,"Lose").start();
		Thread.sleep(1000);
		new Thread(runn,"Jobs").start();
	}
}
