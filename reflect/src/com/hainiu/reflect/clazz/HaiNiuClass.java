package com.hainiu.reflect.clazz;
/**
 * @author puxiongxiong
 * 类加载
 *   每个类在用之前都会被加载，被加载时产生一个对象，一个类只被加载一次
 *   这个对象包含了这个类的信息，存储着该类的信息，存在堆里
 *   这个对象是Class类的对象 这个对象被称之为类对象
 * 
 * 得到Class对象的三种方式
 * 验证类只被加载一次
 * 
 * 
 * 
 */
public class HaiNiuClass {
	public static void main(String[] args) throws ClassNotFoundException {
		// 1.通过得到类的方式
		Class clazz = Person.class;
		// 2.通过对象得到类的方式
		Class clazz1 = new Person().getClass();
		// 3.通过地址得到类的方式（使用最多的是这一种）
		Class clazz2 = Class.forName("com.hainiu.reflect.clazz.Person");
		
		System.out.println(clazz == clazz1);// true
		System.out.println(clazz == clazz2);// true
		System.out.println(clazz);
	}
}