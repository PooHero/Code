package com.hainiu.join;
/**
 * @author puxiongxiong
 *
 * join方法的含义：
 *     例如在A线程，B线程对象有了join方法，那么A线程要等B线程结束了才能执行
 *     如果B线程不结束，那么A线程会一直等待
 *     可以理解为A等B线程结束
 *     也可以理解为B抢占A的资源
 *     
 *     如果给了参数，那么就代表最多等这个线程多久，到达这个时间之后还不死，那就不管了
 */
public class HaiNiuJoin {
	public static void main(String[] args) {
		Runnable runn = new HaiNiuRunnable();
		Thread th = new Thread(runn);
		th.start();
//		try {
//			th.join(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for (int i = 0; i < 100; i++) {
//			System.out.println("     HaiNiuJoin.main() " + i);
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
