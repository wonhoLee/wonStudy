package com.exam.ch04;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//raw type 에 대한 설명
public class Generics1 {
	static class Hello<T> {	// T -> type parameter
		
	}
	
	static void print(String value) {
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		/*print("Generics");
		new Hello<String>();	// type argument
		List<String> list = new ArrayList<>();
		list.add("abd");*/
		
		/* raw type 에 대한 설명
		 * List<Integer> ints = Arrays.asList(1,2,3);
		List rawInts = ints;
		@SuppressWarnings("unchecked")
		List<Integer> ints2 = rawInts;*/
		
		
	}
}
