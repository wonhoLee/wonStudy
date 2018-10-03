package com.exam.ch04.item02;

import java.util.function.Consumer;
import java.util.function.Function;

import com.exam.ch04.item02.IntersectionType2.Hello;
import com.exam.ch04.item02.IntersectionType2.Hi;
import com.exam.ch04.item02.IntersectionType2.Printer;

public class IntersectionType3 {
	interface Hello extends Function{
		default void hello() {
			System.out.println("Hello");
		}
	}
	
	interface Hi extends Function{
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
		//intersectionType은 최종적으로 induction 과정을 거쳐
		//Method 가 하나로 판단될 경우 문제가 없음
		//해당 예제는 Fucntion, Hello 의 extends 도 Function, Hi의 extends 도 Fucntion 이므로 결국 메소드 하나로 계산됨
		run((Function & Hello & Hi & Printer) s->s, o -> {
			o.hello();
			o.hi();
			o.print("test");
		});
	}
	
	private static <T extends Function> void run(T t, Consumer<T> consumer) {
		consumer.accept(t);
	}
}
