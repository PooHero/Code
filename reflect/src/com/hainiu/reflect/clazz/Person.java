package com.hainiu.reflect.clazz;

public class Person {
	String name;
	String sex;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + "]";
	}
}
