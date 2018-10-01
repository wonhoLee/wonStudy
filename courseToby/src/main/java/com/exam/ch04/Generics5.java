package com.exam.ch04;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Type inference : 타입추론
public class Generics5 {
	static <T> void method(T t, List<T> list) {}
	
	//차이점
	static <T> void method2(List<T> t) {}	// T : 향후 알게되면 그 type으로 쓰겠다
	static void method3(List<?> t) {}		// ? : wildcards -> 뭔지 모르겠다
	
	//차이점
	static void printList(List<Object> list) {	//
		list.forEach(s-> System.out.println(s));
	}
	static void printList2(List<?> list) {		//
		list.forEach(s-> System.out.println(s));
	}
	
	public static void main(String[] args) {
		method(1, Arrays.asList(1,2,3));
		
		//java 이전버전에서는 명시해줘야함
		Generics5.<Integer>method(1, Arrays.asList(1,2,3));
		
		//다른예제
		List<String> c = Collections.emptyList();
		List<String> d = Collections.<String>emptyList();
		
		//printList 케이스
		List<Integer> list = Arrays.asList(1,2,3);
		//printList(list);	//Integer 가 Object에 SubClass 가 아니여서 불가능
		printList2(list);	//wildcard 로 사용하여 가능
	}
}
