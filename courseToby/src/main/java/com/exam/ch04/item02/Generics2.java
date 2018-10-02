package com.exam.ch04.item02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics2 {
	/*
	 * wildcard 형식으로 변경하려고 하면 capture 관련 에러가 남
	 * capture 관련 에러 수정을 위해 Helper 관련 기능완성 해야함
	 */
	static <T> void reverse1(List<T> list) {
		List<T> temp = new ArrayList<>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, temp.get(list.size()-i-1));
		}
	}
	
	static void reverse2(List<?> list) {
		reverseHelper(list);
	}
	private static <T> void reverseHelper(List<T> list) {
		List<T> temp = new ArrayList<>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, temp.get(list.size()-i-1));
		}
	}
	
	//변칙 : 과거 JAVA 버전으로 구현하는 방법도 있음
	static void reverse3(List<?> list) {
		List temp = new ArrayList<>(list);
		List list2 = list;
		for (int i = 0; i < list.size(); i++) {
			list2.set(i, temp.get(list2.size()-i-1));
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		reverse3(list);
		System.out.println(list);
	}
}
