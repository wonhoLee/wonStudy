package com.exam.ch04.item02;

import java.util.function.Function;

public class IntersectionType {
	public static void main(String[] args) {
		//Lamda 설명
		/*Function<String, String> f = new Function<String, String>(){
			@Override
			public String apply(String s) {
				return s;
			}
		};
		
		hello(s->s);
		*/
		
		hello((Function & )s->s);
	}

	private static void hello(Function o) {
		
	}
}
