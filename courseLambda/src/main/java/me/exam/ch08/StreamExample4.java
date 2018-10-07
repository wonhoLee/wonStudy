package me.exam.ch08;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

public class StreamExample4 {
	public static void main(String[] args) {
		/*
		 * Windows -> Preferences -> Java -> Editor -> Content Assist -> Favorites
		 * New type -> Browse -> Collectors -> add
		 */
		Stream.of(1,2,3,4,5)
			.collect(toList());
		
		Stream.of(1,2,3,4,5)
		.collect(toSet());
		
		Stream.of(1,2,3,4,5)
			.map(i -> String.valueOf(i))
			.collect(joining());
		
		/*
		 *	Java -> Code Style -> Organize Imports -> Number of static imports needed for 숫자수정 -> apply 
		 */
	}

}
