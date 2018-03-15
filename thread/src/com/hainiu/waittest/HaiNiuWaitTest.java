package com.hainiu.waittest;
/**
 * @author puxiongxiong 
 * 等待唤醒测试
 * 
 * 守护线程（后台线程）
 * 前台线程（凡是创建的都是前台线程）
 *   当所有的前台线程都结束之后，守护线程会自动结束
 *   
 * 举例后台线程：
 *   垃圾回收的线程
 */
public class HaiNiuWaitTest {
	public static void main(String[] args) throws InterruptedException {
//		Object obj = new Object();
//		HaiNiuRunnable1 runn1 = new HaiNiuRunnable1(obj);
//		HaiNiuRunnable2 runn2 = new HaiNiuRunnable2(obj);
//		new Thread(runn1,"Jack").start();
//		new Thread(runn1,"Lose").start();
//		new Thread(runn1,"Jams").start();
//		Thread.sleep(1000);
//		new Thread(runn2).start();
		
//		Thread th1 = new Thread(runn1,"Jack");
//		Thread th2 = new Thread(runn1,"Lose");
//		Thread th3 = new Thread(runn1,"Jobs");
//		boolean b = th1.isDaemon();// 判断是否为守护线程
//		System.out.println(b);
		
		HaiNiuRunnable2 runn2 = new HaiNiuRunnable2();
		Thread th4 = new Thread(runn2);
		// 将main方法设置成后台线程
		th4.setDaemon(true);
		th4.start();
		System.out.println(th4.isDaemon());
		Thread.sleep(1000);
		System.out.println("main -----gg");
	}
}

/*class HaiNiuRunnable1 implements Runnable {
	Object obj;

	public HaiNiuRunnable1() {
		// TODO Auto-generated constructor stub
	}

	public HaiNiuRunnable1(Object obj) {
		super();
		this.obj = obj;
	}

	public void run() {
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName()+"	开始等待");
			try {
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"	等待结束");
		}
	}

}*/

class HaiNiuRunnable2 implements Runnable {
	Object obj;

	public HaiNiuRunnable2() {
		// TODO Auto-generated constructor stub
	}

	public HaiNiuRunnable2(Object obj) {
		super();
		this.obj = obj;
	}

	public void run() {
		/*synchronized (obj) {
			System.out.println(Thread.currentThread().getName()+"	唤醒一个");
//			obj.notify();
			obj.notifyAll();
		}*/
		while (true) {
			System.out.println("HaiNiuRunnable2.run()");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}