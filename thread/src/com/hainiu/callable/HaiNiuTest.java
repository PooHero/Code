package com.hainiu.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author 蒲怀梓
 *
 * Callable接口创建线程，并开启：
 *   1.一个类实现Callable接口，重写覆盖call方法（call就是线程体，类似于run方法）
 *   2.使用FutureTask进行包装，得到Runnable对象
 *   3.使用Runnable对象构建Thread类对象
 *   4.调用start方法进行开启
 *   
 * 特性：
 *   1.call方法可以抛异常
 *   2.call方法有返回值
 * 
 */
public class HaiNiuTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable call = new HaiNiuCallable();
		FutureTask ft = new FutureTask(call);
		new Thread(ft).start();
//		Object obj = ft.get();
		Object obj = null;
		try {
			obj = ft.get(5000, TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("出现异常了");
		}
		System.out.println(obj);
		System.out.println("main -----gg");
	}
}
