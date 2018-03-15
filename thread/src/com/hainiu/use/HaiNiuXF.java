package com.hainiu.use;
/**
 * @author puxiongxiong
 * 消费者
 */
public class HaiNiuXF implements Runnable {
	private Call call;
	public HaiNiuXF() {
		// TODO Auto-generated constructor stub
	}
	public HaiNiuXF(Call call) {
		super();
		this.call = call;
	}
	public void run() {
		int i = 0;
		while (true) {
			// 消费
			if (HaiNiuTest.b) {
				synchronized (call) {
					System.out.println(call);
					HaiNiuTest.b = false;
					i++;
				}
			} else {
				System.out.println("还没生产好，拒绝消费----->" + i);
			}
		}
	}
}
