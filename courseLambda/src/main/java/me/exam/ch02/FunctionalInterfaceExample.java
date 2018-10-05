package me.exam.ch02;

import java.util.function.Function;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		/*Function<String, Integer> toInt = new Function<>() {
			@Override
			public Integer apply(String arg0) {
				return Integer.parseInt(arg0);
			}
		};*/
		
		//Lambda 적용
		/*Function<String, Integer> toInt = (String arg0) -> {
				return Integer.parseInt(arg0);
			}
		;*/
		final Function<String, Integer> toInt = arg0 -> Integer.parseInt(arg0);
		
		final Integer number = toInt.apply("100");
		System.out.println(number);
		
		//idendity 설명
		//final Function<Integer, Integer> identity = Function.identity();
		final Function<Integer, Integer> identity = t -> t;
		
		System.out.println(identity.apply(999));
	}
}
