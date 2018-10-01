package com.exam.ch04;

//Generic Method 에 대한 설명
public class Generics2 {
	<T> void print(T t) {
		System.out.println(t.toString());
	}
	
	public static void main(String[] args) {
		new Generics2().print("Hello");
		new Generics2().print(1);
	}
}
