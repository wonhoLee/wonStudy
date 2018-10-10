package com.exam.ch05;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReactiveEx01 {
	// Ierable <---> Observable (duality) - 에릭마이어
	// Pull          Push
	
	public static void main(String[] args) {
		/*
		 * Reactive Programming
		 * 외부에서 뭔가(이벤트, 데이터) 발생하면 거기에 대응하는 방식으로 돌아가는 것
		 * Duality
		 * Observer Pattern
		 * Reactive Streams - 표준 - Java9 API
		 */
		
		/*List<Integer> list = Arrays.asList(1,2,3,4,5);
		for(Integer i : list) {
			System.out.println(i);
		}
		System.out.println("---------------------------");*/
		//Iterable<Integer> iter = Arrays.asList(1,2,3,4,5);
		Iterable<Integer> iter = () -> 
			new Iterator<Integer>() {
				int i = 0;
				final static int MAX = 10;
				
				public boolean hasNext() {
					return i < MAX;
				}
	
				public Integer next() {
					return ++i;
				}
		};
		
		for(Integer i : iter) {
			System.out.println(i);
		}
		System.out.println("---------------------------");
		
		/* JAVA 5 이전
		 * for(Iterator<Integer> it = iter.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}*/
	}
}
