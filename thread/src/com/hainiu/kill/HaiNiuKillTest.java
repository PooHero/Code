package com.hainiu.kill;
/**
 * @author puxiongxiong 
 * 杀死线程
 * 
 */
public class HaiNiuKillTest {
	public static void main(String[] args) throws InterruptedException {
		HaiNiuRunnable runn = new HaiNiuRunnable();
		Thread th = new Thread(runn);
		th.start();
		Thread.sleep(1000);
		System.out.println("修改 b");
//		runn.b = false;
		th.interrupt();
		System.out.println("main -----gg");
	}
}

class HaiNiuRunnable implements Runnable {
	boolean b = true;
	public void run() {
		int i = 0;
		while (b) {
			System.out.println(i++);
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("外界想要结束我，那么我就结束自己！");
					return;
				}
			}
		}
		System.out.println("线程结束了");
	}
}
