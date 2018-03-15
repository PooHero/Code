package com.hainiu.si;

/**
 * @author puxiongxiong
 * 
 * Java死锁代码演示
 *
 */
public class HaiNiuTest {
	public static void main(String[] args) throws InterruptedException {
		HaiNiuRunnable runn = new HaiNiuRunnable();
		new Thread(runn,"张三").start();
		Thread.sleep(1000);
		HaiNiuRunnable.b = false;
		new Thread(runn,"李四").start();
		System.out.println("main -----gg");
	}
}
