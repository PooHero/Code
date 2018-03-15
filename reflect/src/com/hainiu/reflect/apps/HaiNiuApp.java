package com.hainiu.reflect.apps;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 蒲怀梓
 * 
 * 反射是一门动态创建对象的技术，反射是指在程序的运行期间可以访问对象，可以动态地修改对象的值
 * Java是静态的，所有的对象都是预先创建好的，都是写死的，不够动态
 * 反射的作用就是动态地创建对象，使Java成为半动态语言
 * 反射的缺陷：
 *   操作麻烦
 *   效率低
 *   
 * 应用场景举例：
 *   一款APP已经实现了支付宝支付功能，完成项目之后要增加微信支付功能，在不停服务的情况下，实现支付宝和微信的切换，且不需要改源码
 * 实现方法：
 *   增加类不算是修改源码，增加的类可以用jar包的形式传到服务器，且保证服务不停止
 *   1.使用多态；
 *   2.使用IO流进行创建对象的判断
 * 
 */
public class HaiNiuApp {
	// 切换支付方式时，只需改这一段代码
	static String name = "com.hainiu.reflect.apps.ZFZFB";// 从本地读到的字符串，每隔20分钟读一次
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ZF zf = null;
//		if (name.equals("微信")) {
//			zf = new ZFWX();
//		} else if (name.equals("支付宝")) {
//			zf = new ZFZFB();
//		}
		Class clazz = Class.forName(name);
		Object obj = clazz.newInstance();
		zf = (ZF) obj;
		zf.zf();
	}
}

class ZFZFB implements ZF{
	@Override
	public void zf() {
		TestZFB zfb = new TestZFB();
		zfb.zfb();
	}
}
class ZFWX implements ZF{
	@Override
	public void zf() {
		TestWX wx = new TestWX();
		wx.wx();
	}
}

class TestZFB implements ZFB{
	@Override
	public void zfb() {
		System.out.println("使用支付宝支付");
	}
}
class TestWX implements WX{
	@Override
	public void wx() {
		System.out.println("使用微信支付");
	}
}
