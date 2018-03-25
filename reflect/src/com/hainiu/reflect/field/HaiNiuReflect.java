package com.hainiu.reflect.field;

import java.lang.reflect.Field;

/**
 * @author puxiongxiong
 * 反射获取和操作属性
 */
public class HaiNiuReflect {
	/**
	 * 获得属性的4种方式
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static void get() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		// 获得类对象
		Class clazz = Class.forName("com.hainiu.reflect.field.Student");
		// 使用反射获得单个公共的属性
		Field field = clazz.getField("pname");
//		System.out.println(field);
		// 使用反射获得所有公开的属性，以field类型的数组返回
		Field[] fields = clazz.getFields();
		for (Field f : fields) {
//			System.out.println(f.getName());
		}
		// 使用反射获取单个本类声明的属性（必须是本类声明的，不能获得父类的）
		field = clazz.getDeclaredField("sage");
//		System.out.println(field);
		// 使用反射获得所有本类声明的属性（必须是本类声明的）
		fields = clazz.getDeclaredFields();
		for (Field f : fields) {
//			System.out.println(f.getName());
		}
		
		System.out.println("父类的声明属性----------");
		// 获得父类对应的对象
		clazz = clazz.getSuperclass();
		fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName());
		}
		
		System.out.println("==========程序结束了==========");
	}
	
	/**
	 * 操作属性
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void use() throws ClassNotFoundException, 
		NoSuchFieldException, SecurityException, IllegalArgumentException, 
		IllegalAccessException, InstantiationException {
		// 获得类对象
		Class clazz = Class.forName("com.hainiu.reflect.field.Student");
		// 操作属性（此时有权限限制，主要操作为获取值和操作值）
		// 属性有静态和非静态之分
		// （一）静态属性的操作(静态属性是依附于类的，非静态属性是依附于对象的)
		Field field = clazz.getDeclaredField("pswd");
		// 1.获得静态属性的值（静态属性不依附对象，此时我们传一个null）
		Object obj = field.get(null);
		System.out.println(obj);
		// 2.修改静态属性的值
		field.set(null, "Hero");
		obj = field.get(null);
		System.out.println("修改结果如下：");
		System.out.println(obj);
		System.out.println("==========以下是非静态属性==========");
		// （二）非静态属性的操作（获取值和操作值）
		// 1.获得非静态属性的值（非静态属性是依附于对象的）
		field = clazz.getDeclaredField("sname");
//		field = clazz.getDeclaredField("sscore");// 私有化属性
//		field.setAccessible(true);// 暴力反射，打开缺口，无视修饰符
		
		
		//非静态属性是依附于对象的,此时必须给一个对象
//		obj = field.get(null);// 会报错
		Object newInstance = clazz.newInstance();// 此方法是创建本类对象的，调用的是无参构造器
		obj = field.get(newInstance);
		System.out.println(obj);
		// 2.修改非静态属性的值（非静态属性是依附于对象的）
//		field.set(newInstance, 28);
		field.set(newInstance, "PooThinker");
		obj = field.get(newInstance);
		System.out.println(obj);
		
		System.out.println("----------over----------");
	}
	
}

class Student extends Person{
	public static String pswd = "007";
	public String sname;
	protected boolean ssex;
	int sage;
	private int sscore;
	public Student() {
		sname = "Thinker";
	}
}
class Person {
	public String pname;
	protected boolean psex;
	int page;
	private int pscore;
	public Person() {
		// TODO Auto-generated constructor stub
	}
}