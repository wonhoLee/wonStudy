package me.exam.ch07;

import java.math.BigDecimal;

public class BigDecimalExample {

	public static void main(String[] args) {
		//기존 Interface들은 타입추론을 사용함
		//하지만 어떤 타입인지 정해져 있다면 굳이 타입추론을 안써도 됨
		//해당예제임 : BigDecimal -> To String 해줌
		BigDeciamlToCurrency bigDeciamlToCurrency = bd -> "$" + bd.toString();
		System.out.println(bigDeciamlToCurrency.toCurrency(new BigDecimal("120.00")));
		
		//Functional Interface 의 제약사항
		//람다식으로 못쓰는 경우가 있음
		final InvalidFunctionalInterface anonymousClass = new InvalidFunctionalInterface() {
			
			@Override
			public <T> String mkString(T value) {
				return value.toString();
			}
		};
		
		System.out.println(anonymousClass.mkString(123));
		
		//컴파일 오류남
		//Class 자체에는 Input, Output 값을 알수없음
		//Method 자체에서 Input, Output 을 알수있음
		//현재 @FunctionalInterface 를 사용했는데도 컴파일 오류가 안남 -> 하지만 람다로는 못씀
		/*final InvalidFunctionalInterface invalidFunctionalInterface = value -> value.toString();
		System.out.println(invalidFunctionalInterface.mkString(123));*/
		
		
	}

}

@FunctionalInterface
interface BigDeciamlToCurrency {
	String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvalidFunctionalInterface {
	<T> String mkString(T value);
}