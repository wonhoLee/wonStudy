package me.exam.ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExamples2 {
	public static void main(String[] args) {
		//Stream.of(1,2,3,4,5).forEach(i->System.out.println(i));
		
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		/*
		final List<Integer> result = new ArrayList<>();
		for (final Integer number : numbers) {
			if(number > 3 && number < 9) {
				result.add(number * 2);
			}
		}
		System.out.println(result);
		
		System.out.println(
			numbers.stream()
				.filter(number -> number > 3)
				.filter(number -> number < 9)
				.map(number -> number * 2)
				.filter(number -> number < 10)
				.findFirst()
		);*/
		
		/*final List<Integer> greaterThan3 = filter(numbers, i -> i > 3);
		final List<Integer> lessThan9 = filter(greaterThan3, i -> i < 9);
		final List<Integer> doubled = map(lessThan9, i -> i * 2);
		final List<Integer> lessThan10 = filter(doubled, i -> i < 10);
		System.out.println(lessThan10);*/
		
		final List<Integer> greaterThan3 = filter(numbers, i -> i > 3);
		final List<Integer> lessThan9 = filter(greaterThan3, i -> i < 9);
		final List<Integer> doubled = map(lessThan9, i -> i * 2);
		final List<Integer> lessThan10 = filter(doubled, i -> i < 10);
		System.out.println(lessThan10);
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		final List<T> result = new ArrayList<>();
		for(final T t : list) {
			if(predicate.test(t)) {
				result.add(t);
			}
		}
		
		return result;
	}
	
	private static <T, R> List <R> map(List<T> list, Function<T, R> function){
		final List<R> result = new ArrayList<>();
		for(final T t : list) {
			result.add(function.apply(t));
		}
		return result;
	}
}
