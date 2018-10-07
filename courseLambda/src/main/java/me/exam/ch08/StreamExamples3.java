package me.exam.ch08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class StreamExamples3 {
	public static void main(String[] args) {
		System.out.println(
			Stream.of(1,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 2)
				.map(i -> "# " + i)
				.collect(toList())
		);
		
		System.out.println(
			Stream.of(1,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 2)
				.map(i -> "# " + i)
				.collect(toSet())
			);
		
		System.out.println(
			Stream.of(1,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 2)
				.map(i -> "# " + i)
				.collect(joining(", ", "[", "]"))
			);
		
		System.out.println(
			Stream.of(1,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 2)
				.map(i -> "# " + i)
				.distinct()
				.collect(joining(", ", "[", "]"))
			);
		
		System.out.println(
			Stream.of(1,3,3,5,5)
				.filter(i -> i > 2)
				.map(i -> i * 2)
				.map(i -> "# " + i)
				.distinct()
				.collect(toList())
			);
		
		final Integer integer3 = 3;
		System.out.println(
			Stream.of(1,2,3,4,5)
				.filter(i -> i.equals(integer3))
				.findFirst()
		);
		
		System.out.println(
			Stream.of(1,2,3,4,5)
				.filter(i -> i > integer3)
				.count()
		);
		
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		for (Integer i : numbers) {
			System.out.println("i = " + i);
		}
		
		Stream.of(1,2,3,4,5)
			.forEach(i -> System.out.println("i = " + i));
	}

}
