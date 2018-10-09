package me.exam.ch11;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.Arrays;

public class MethodReferenceExamples {
	public static void main(String[] args) {
		Arrays.asList(1,2,3,4,5).forEach(i -> System.out.println(i));
		
		Arrays.asList(1,2,3,4,5).forEach(System.out::println);
		
		System.out.println(
			Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
				.stream()
				//.sorted()
				//.sorted((bd1, bd2) -> bd1.compareTo(bd2))
				//.sorted(BigDecimalUtil::compare)
				.sorted(BigDecimal::compareTo)
				.collect(toList())
		);
		
		final String targetString = "c";
		System.out.println(
			Arrays.asList("a", "b", targetString, "d")
				.stream()
				//.anyMatch(x -> x.equals("c"))
				.anyMatch(targetString::equals)
		);
	}
}

class BigDecimalUtil{
	public static int compare(BigDecimal bd1, BigDecimal bd2) {
		return bd1.compareTo(bd2);
	}
}
