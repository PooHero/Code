package com.hainiu.si;

/**
 * @author puxiongxiong
 * 
 * Java死锁代码演示
 *
 */
public class HaiNiuRunnable implements Runnable {
	static boolean b = true;
	Object obj1 = new Object();
	Object obj2 = new Object();

	public void run() {
		if (b) {
			synchronized (obj1) {
				System.out.println(Thread.currentThread().getName()+" 拿到了obj1");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 结束睡眠");
				synchronized (obj2) {
					System.out.println("最终拿到了");
				}
			}
		} else {
			synchronized (obj2) {
				System.out.println(Thread.currentThread().getName()+" 拿到了obj2");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 结束睡眠");
				synchronized (obj1) {
					System.out.println("最终拿到了");
				}
			}
		}
	}

}
