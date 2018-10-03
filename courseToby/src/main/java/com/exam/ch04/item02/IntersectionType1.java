package com.exam.ch04.item02;

import java.io.Serializable;
import java.util.function.Function;

//IntersectionType : Lambda 식에서 인터페이스를 두개 이상 쓰는 방식?
//marker Interface : Serializable Interface, Type 만 가지고 체크가 가능하고 Type 전송이 가능
public class IntersectionType1 {
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
		
		/*
		이런식으로 인터페이스 여러개 붙여 Class 생성하여 Class를 쓸수있으나 람다식의 취지에 안맞음
		class MyTestClass implements Function & Serializable & Cloneable {
		
		}
		그래서 아래와 같은 람다식에서 IntersectionType 이 필요한것임
		 */
		hello((Function & Serializable & Cloneable)s->s);
		
	}
	
	/*private static void hello(Function o) {
		
	}*/
	private static <T extends Function & Serializable & Cloneable> void hello(T o) {
		
	}
}
