package com.hainiu.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 蒲怀梓
 * 反射获取和操作方法  Method
 * 方法由Method类来描述和管理
 * 获取方法
 *
 */
public class HaiNiuMethod {
	/**
	 * 获取方法
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static void get() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		// 获取Class对象
		Class clazz = Class.forName("com.hainiu.reflect.method.Student");
		// 获得公共的方法
		// 1.获取单个的公共的方法（方法有同名的，必须靠参数来区分）
		// 没有参数时给null，有参数时就给所有参数的类对象（方法的Class是可变参数）
//		Method method = clazz.getMethod("sName", null);
//		Method method = clazz.getMethod("sName", String.class,int.class);
//		Class [] cs = {String.class,int.class};
		Method method = clazz.getMethod("sName", new Class [] {String.class,int.class});
		System.out.println(method);
		
		// 2.获得所有的公共的方法（一直到Object类，所有的公共方法都能获得——public修饰的方法）
		System.out.println("----------以下是所有公共的方法----------");
		Method[] methods = clazz.getMethods();
		for (Method me : methods) {
			System.out.println(me);
		}
		System.out.println("----------以下是本类声明的方法----------");
		// 获得本类声明的方法
		// 1.获取单个的本类声明的方法（方法有同名的，必须靠参数来区分）
		// 没有参数时给null，有参数时就给所有参数的类对象（方法的Class是可变参数）
		method = clazz.getDeclaredMethod("sName", null);
//		Method method = clazz.getMethod("sName", String.class,int.class);
//		Method method = clazz.getMethod("sName", new Class [] {String.class,int.class});
		System.out.println(method);
		
		// 2.获得本类所有的声明的方法（一直到Object类，所有的公共方法都能获得——public修饰的方法）
		System.out.println("----------以下是本类所有声明的方法----------");
		methods = clazz.getDeclaredMethods();
		for (Method me : methods) {
			System.out.println(me);
		}
		
		System.out.println("----------获取修饰符----------");
		// 获取修饰符
		int modifiers = method.getModifiers();
		System.out.println(modifiers);
		
		System.out.println("==========程序结束了==========");
	}
	
	/**
	 * 操作方法
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public static void use() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 获得类对象
		Class clazz = Class.forName("com.hainiu.reflect.method.Student");
		// 操作方法（就是执行）
		// 方法有静态和非静态之分（静态方法依附于类，非静态方法依附于对象）
		// （一）操作静态方法
		// 1.操作无参的静态方法
		System.out.println("----------操作静态无参方法----------");
		Method method = clazz.getDeclaredMethod("show", null);
//		System.out.println(method);
		method.invoke(null, null);
		
		// 2.操作有参的静态方法
		System.out.println("----------操作静态有参方法----------");
		method = clazz.getDeclaredMethod("show", String.class,int.class);
//		System.out.println(method);
		method.invoke(null, "Hero", 123);// 此时要注意参数类型和顺序
		
		// （一）操作非静态方法
		// 1.操作非静态无参方法（非静态方法依附于对象，此时要给对象）
		System.out.println("----------操作非静态无参方法----------");
		Object newInstance = clazz.newInstance();
		method = clazz.getDeclaredMethod("sName", null);
		System.out.println(method);
		method.invoke(newInstance, null);
		
		// 2.操作非静态有参方法（非静态方法依附于对象，此时要给对象）
		System.out.println("----------操作非静态有参方法----------");
		method = clazz.getDeclaredMethod("sName", int.class,String.class);
		System.out.println(method);
		method.invoke(newInstance, 321, "Thinker");// 此时要注意参数类型和顺序
		
		// 私有方法（执行）
		System.out.println("----------私有方法----------");
		method = clazz.getDeclaredMethod("sScore", null);
		method.setAccessible(true);
		Object obj = method.invoke(newInstance, null);// invoke方法支持返回值，返回的是Object类型
		System.out.println("obj = "+obj);
		
		System.out.println("==========程序结束了==========");
	}
}

class Student extends Person {
	public static void show() {
		System.out.println("static Student.show()");
	}
	public static void show(String name,int age) {
		System.out.println("static Student.show()"+" ----> "+name+" ----> "+age);
	}
	public void sName() {
		System.out.println("Student.sName()");
	}
	public void sName(int age,String name) {
		System.out.println("Student.sName()"+" ----> "+age+" ----> "+name);
	}
	public void sName(String name) {
		System.out.println("Student.sName()");
	}
	// 重载
	public void sName(String name,int age) {
		System.out.println("Student.sName()");
	}
	// 重载
	public void sName(String name,int age,boolean score) {
		System.out.println("Student.sName()");
	}
	protected void sSex() {
		System.out.println("Student.sSex()");
	}
	void sAge() {
		System.out.println("Student.sAge()");
	}
	private int sScore() {
		System.out.println("Student.sScore()");
		return 100;
	}
}
class Person{
	public void pName() {
		System.out.println("Person.pName()");
	}
	protected void pSex() {
		System.out.println("Person.pSex()");
	}
	void pAge() {
		System.out.println("Person.pAge()");
	}
	private void pScore() {
		System.out.println("Person.pScore()");
	}
}