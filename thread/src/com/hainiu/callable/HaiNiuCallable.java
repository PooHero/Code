package com.hainiu.callable;

import java.util.concurrent.Callable;

public class HaiNiuCallable implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			sum += i;
			System.out.println(i);
			Thread.sleep(1000);
		}
		return sum;
	}
}