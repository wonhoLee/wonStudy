package com.exam.ch04.item01;

import java.io.Closeable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

//Bounded Type Parameter
public class Generics3 {
	//static <T extends List & Serializable & Comparable & Closeable> void print0(T t) {}	// multiple , intersaction type
	//static <T extends List> void print(T t) {}
	//Sample live coding
	//CASE 1 : Integer[] 형태만 처리가능
//	static long countGreaterThan(Integer[] arr, Integer elem) {
//		return Arrays.stream(arr).filter(s -> s > elem).count();
//	}
	
	//CASE 2 : 자유롭게 처리가능
	static <T extends Comparable<T>> long countGreaterThan(T[] arr, T elem) {
		return Arrays.stream(arr).filter(s -> s.compareTo(elem) > 0).count();
	}
	
	public static void main(String[] args) {
		//Integer[] arr = new Integer[] {1,2,3,4,5,6,7};
		String[] arr = new String[] {"a", "b", "c", "d", "e"};
		System.out.println(countGreaterThan(arr, "b"));
	}
}
