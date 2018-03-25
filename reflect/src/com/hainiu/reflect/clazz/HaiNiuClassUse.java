package com.hainiu.reflect.clazz;
/**
 * @author puxiongxiong
 * Class对象的操作
 */
public class HaiNiuClassUse {
	public static void main(String[] args) throws ClassNotFoundException {
		// 得到类对象
		Class clazz = Class.forName("com.hainiu.reflect.clazz.Person");
		int i = clazz.getModifiers();
		System.out.println(i);
		// 包名类名
		System.out.println(clazz.getName());
		// 获取此类的包
		System.out.println(clazz.getPackage());
		// 类名
		System.out.println(clazz.getSimpleName());
		// 返回父类对应的类对象
		Class superclass = clazz.getSuperclass();
		System.out.println(superclass);
		System.out.println("====================");
		// 判定指定的Class对象是否表示一个基本类型（9种）
		System.out.println(byte.class.isPrimitive());
		System.out.println(short.class.isPrimitive());
		System.out.println(int.class.isPrimitive());
		System.out.println(long.class.isPrimitive());
		System.out.println(float.class.isPrimitive());
		System.out.println(double.class.isPrimitive());
		System.out.println(boolean.class.isPrimitive());
		System.out.println(char.class.isPrimitive());
		System.out.println(void.class.isPrimitive());
	}
}