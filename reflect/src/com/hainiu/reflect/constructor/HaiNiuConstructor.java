package com.hainiu.reflect.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author puxiongxiong
 * 反射获取和操作构造器
 * Constructor 用来描述和管理类的构造器
 * 获取构造器
 * 
 */
public class HaiNiuConstructor {
	/**
	 * 获取构造器
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static void get() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		// 获得类对象
		Class clazz = Class.forName("com.hainiu.reflect.constructor.Student");
		// 获得构造器（构造器的名字都一样，只需要参数就可以确定是某个构造器）
		// （一）获取公开的构造器
		// 1.获得单个公开的构造器（public修饰词的方法）
		Constructor constructor = clazz.getConstructor(null);// 此处要传入参数，方法可变参数
		System.out.println(constructor);
		
		// 2.获得所有公开的构造器（public修饰词的方法，且不包含父类的方法；如要想获取父类的构造方法，就得获取父类的类对象，然后依次获取）
		System.out.println("----------以下是所有的公开的构造方法------------");
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor cs : constructors) {
			System.out.println(cs);
		}
		
		// （二）获取声明的构造器
		// 1.获得单个声明的构造方法
		System.out.println("----------以下是单个声明的构造方法------------");
		constructor = clazz.getDeclaredConstructor(String.class);
		System.out.println(constructor);
		
		// 2.获得所有声明的构造方法
		System.out.println("----------以下是所有声明的构造方法------------");
		constructors = clazz.getDeclaredConstructors();
		for (Constructor cs : constructors) {
			System.out.println(cs);
		}
		
		// 修饰符
		System.out.println("-----------------修饰符-----------------");
		int modifiers = constructor.getModifiers();
		System.out.println(modifiers);
		
		System.out.println("==========程序结束了==========");
	}
	
	/**
	 * 操作构造器
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void main(String[] args) throws ClassNotFoundException, 
		NoSuchMethodException, SecurityException, 
		InstantiationException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException {
		// 获得类对象
		Class clazz = Class.forName("com.hainiu.reflect.constructor.Student");
		// 操作构造器
		// 1.操作无参构造器
		System.out.println("-----------------无参构造器-----------------");
		Constructor constructor = clazz.getDeclaredConstructor(null);
		Object obj = constructor.newInstance(null);
		System.out.println(obj);
		
		// 2.操作有参构造器
		System.out.println("-----------------有参构造器-----------------");
		constructor = clazz.getDeclaredConstructor(String.class,String.class,int.class);
		constructor.setAccessible(true);// 暴力反射
		obj = constructor.newInstance("Hero","Man",28);
		System.out.println(obj);
		
		System.out.println("==========程序结束了==========");
	}
}

class Student extends Person{
	String sName;
	String sSex;
	int sAge;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	private Student(String sName) {
		super();
		this.sName = sName;
	}
	Student(String sName, String sSex) {
		super();
		this.sName = sName;
		this.sSex = sSex;
	}
	private Student(String sName, String sSex, int sAge) {
		super();
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
	}
	@Override
	public String toString() {
		return "Student [sName=" + sName + ", sSex=" + sSex + ", sAge=" + sAge
				+ "]";
	}
}

class Person {
	String pName;
	String pSex;
	int pAge;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String pName, String pSex, int pAge) {
		super();
		this.pName = pName;
		this.pSex = pSex;
		this.pAge = pAge;
	}
}