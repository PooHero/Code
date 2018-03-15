package com.hainiu.use;
/**
 * @author puxiongxiong
 * 
 * 生产者消费者模式
 * 一个或一组线程进行生产
 * 一个或一组线程进行消费
 *   生产者负责生产商品，如果到达指定值就会等待，等待消费者消费
 *   消费者负责消费商品，如果没有剩余的产品就会等待，等待生产者生产
 *
 */
public class HaiNiuTest {
	static boolean b = false;
	public static void main(String[] args) {
		Call call = new Call();// 资源
		HaiNiuSC sc = new HaiNiuSC(call);
		HaiNiuXF xf = new HaiNiuXF(call);
		new Thread(sc).start();
		new Thread(xf).start();
	}
}
