package com.hainiu.level;

public class HaiNiuTest {
	public static void main(String[] args) {
		// System.out.println(Thread.MAX_PRIORITY);
		// System.out.println(Thread.NORM_PRIORITY);
		// System.out.println(Thread.MIN_PRIORITY);
		
		Thread.currentThread().setPriority(10);
		int level = Thread.currentThread().getPriority();
		System.out.println("main优先级 " + level);
		Runnable runn = new HaiNiuThreadLevel();
		Thread th1 = new Thread(runn, "张三");
		Thread th2 = new Thread(runn, "李四");
		th1.setPriority(1);
		th2.setPriority(2);
		th1.start();
		th2.start();
		System.out.println("main -----gg");
	}
}
