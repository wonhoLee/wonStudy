package me.exam.ch11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExamples2 {
	public static void main(String[] args) {
		//First Calss Function
		/*A Function can be passed as a parameter to another function.
		 * Using Lambda Expression
		 */
		System.out.println(
				//testFirstClassFunction1(3, i -> String.valueOf(i * 2))
				testFirstClassFunction1(3, i -> doubleThenToString(i))
		);
		
		/*
		 * Using Method Reference
		 */
		System.out.println(
				testFirstClassFunction1(3, MethodReferenceExamples2::doubleThenToString)
		);
		
		System.out.println("============================");
		/*
		 *  A function can be returned as the result of another functon.
		 */
		//Using Lambda Expression
		System.out.println(
				getDoubleThenToStringUsingLambdaExpression().apply(3)
				);
		//Using Method Reference
		System.out.println(
				getDoubleThenToStringUsingMethodReference().apply(3)
				);
		
		System.out.println("============================");
		/*
		 * A function can be stored in the data structure.
		 */
		//Using Lambda Expresiion
		final List<Function<Integer, String>> fsL = Arrays.asList(i -> String.valueOf(i * 2));
		for(final Function<Integer, String> f : fsL) {
			final String result = f.apply(3);
			System.out.println(result);
		}
		
		//Using Method Reference
		final List<Function<Integer, String>> fsMr = Arrays.asList(MethodReferenceExamples2::doubleThenToString);
		for(final Function<Integer, String> f : fsMr) {
			final String result = f.apply(3);
			System.out.println(result);
		}
		
		System.out.println("============================");
		//Using Lambda Expresiion
		final Function<Integer, String> fl2 = i -> String.valueOf(i * 2);
		final String resultFl2 = fl2.apply(3);
		System.out.println(resultFl2);
		
		//Using Method Reference
		final Function<Integer, String> fmr2 = MethodReferenceExamples2::doubleThenToString;
		System.out.println(fmr2.apply(3));
		
		System.out.println("============================");
		//Both Lambda Expression and Method Reference
		final List<Function<Integer, String>> fsBoth = Arrays.asList(i -> String.valueOf(i * 2), MethodReferenceExamples2::doubleThenToString, MethodReferenceExamples2::addHashPrefix);
		for(final Function<Integer, String> f : fsBoth) {
			System.out.println(f.apply(7));
		}
	}
	
	private static String doubleThenToString(int n) {
		return String.valueOf(n * 2);
	}
	
	private static String addHashPrefix(int number) {
		return "#" + number;
	}
	
	private static String testFirstClassFunction1(int n, Function<Integer, String> f) {
		return "The result is " + f.apply(n);
	}
	
	private static Function<Integer, String> getDoubleThenToStringUsingLambdaExpression(){
		return i -> String.valueOf(i * 2);
	}
	
	private static Function<Integer, String> getDoubleThenToStringUsingMethodReference() {
		return MethodReferenceExamples2::doubleThenToString;
	}
}
