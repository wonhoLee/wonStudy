package com.exam.ch04.item02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Generics1 {
	//ex1 : 둘다 동일하게 사용이 가능
	//? 의경우 list상관없이 list의 기능만 사용할경우 사용가능
	static <T> boolean isEmpty1(List<T> list) {
		return list.size() == 0;
	}
	
	static boolean isEmpty2(List<?> list) {
		return list.size() == 0;
	}
	
	//ex2
	//기능으로는 완벽하게 동작
	//JAVA 설계 사상을 생각하면 wild 카드 형식으로 개발하는것을 권장
	//T 타입을 쓴다면 내부 구현중에 T 를 써야함
	static <T> long frequency1(List<T> list, T elem) {
		return list.stream().filter(s -> s.equals(elem)).count();
	}
	static long frequency2(List<?> list, Object elem) {
		return list.stream().filter(s -> s.equals(elem)).count();
	}
	
	/*ex3
	*wild 카드형식으로 개발하는 것을 권장
	*추가 팁 wild 카드 함수 중
	*upper bound -> 안에서 사용할 것(Input)은 extends 밖에서 
	*lower bound -> 사용할것(Output)은 super 로 사용함
	*/
	private static <T extends Comparable<T>> T max1(List<T> list) {
		return list.stream().reduce((a,b) -> a.compareTo(b) > 0 ? a : b).get();
	}
	private static <T extends Comparable<? super T>> T  max2(List<? extends T> list) {
		return list.stream().reduce((a,b) -> a.compareTo(b) > 0 ? a : b).get();
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,3,2);
		System.out.println(isEmpty1(list));
		System.out.println(isEmpty2(list));
		
		System.out.println(frequency1(list, 3));
		System.out.println(frequency2(list, 3));
		
		System.out.println(max1(list));
		System.out.println(max2(list));
		System.out.println(Collections.max(list));
		
		System.out.println(Collections.max(list, (a,b) -> a - b));
		System.out.println(Collections.max(list, 
				(Comparator<Integer>)(a,b) -> a - b));
		System.out.println(Collections.max(list, 
				(Comparator<Object>)(a,b) -> a.toString().compareTo(b.toString())));
		System.out.println(Collections.<Number>max(list, 
				(Comparator<Object>)(a,b) -> a.toString().compareTo(b.toString())));
		
	}
}
