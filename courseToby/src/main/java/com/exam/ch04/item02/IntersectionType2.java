package com.exam.ch04.item02;

import java.util.function.Consumer;
import java.util.function.Function;

public class IntersectionType2 {
	interface Hello{
		default void hello() {
			System.out.println("Hello");
		}
	}
	
	interface Hi{
		default void hi() {
			System.out.println("Hi");
		}
	}
	
	interface Printer {
		default void print(String str) {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		//위에서 interface 선언이후 아래와같이 IntersectionType 을 쓸수있음
		//static 메소드와 default 메소드는 제외하고 일반적인 메소드 갯수만 합하여 하나면 됨
		hello((Function & Hello & Hi) s->s);
		
		run((Function & Hello & Hi & Printer) s->s, o -> {
			o.hello();
			o.hi();
			o.print("test");
		});
	}
	
	/* 이렇게 사용은 가능하지만 실제 구현에서는 한계가있음
	 * 가져가서 쓰는 입장에서 인터페이스 모두를 붙여줘야 하는 문제점 이 있음
	 * 개선식은 아래에 
	*/
	private static <T extends Function & Hello & Hi> void hello(T t) {
		t.hello();
		t.hi();
	}
	
	//추가 이야기
	//Consumer : 리턴은 없고 파라미터만 하나 있음
	//Supplier : 파라미터 없고 리턴값만 하나 있음
	//Function : 파라미터 와 리턴값 모두 하나 있음
	//BiFunction : 파라미터가 두개 일경우 리턴값은 하나있음 
	private static <T extends Function> void run(T t, Consumer<T> consumer) {
		consumer.accept(t);
	}
}
