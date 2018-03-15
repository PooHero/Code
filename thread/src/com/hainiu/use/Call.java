package com.hainiu.use;

public class Call {
	private String name;
	private String id;
	public Call() {
		// TODO Auto-generated constructor stub
	}
	public Call(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return name + " 型号是 ： " + id;
	}
}
