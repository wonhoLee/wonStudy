package com.exam.ch02.item02;

public class User {
	String name;

	public User() {
		
	}
	
	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	
}
