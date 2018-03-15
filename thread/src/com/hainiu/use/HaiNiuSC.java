package com.hainiu.use;
/**
 * @author puxiongxiong 
 * 生产者
 */
public class HaiNiuSC implements Runnable {
	public Call call;
	public HaiNiuSC() {
		// TODO Auto-generated constructor stub
	}
	public HaiNiuSC(Call call) {
		super();
		this.call = call;
	}
	public void run() {
		int i = 0;
		while (true) {
			if (!HaiNiuTest.b) {
				synchronized (call) {
					if (i % 2 == 0) {
						call.setName("苹果");
						call.setId("4s-----" + i);
					} else {
							call.setName("华为");
							call.setId("荣耀8-----" + i);
					}
					HaiNiuTest.b = true;
					i++;
				}
			} else {
				System.out.println("还没消费，拒绝生产" + (i+1));
			}
		}
	}
}
