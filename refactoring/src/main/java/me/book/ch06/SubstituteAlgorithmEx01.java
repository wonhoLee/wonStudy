package me.book.ch06;

import java.util.Arrays;
import java.util.List;

public class SubstituteAlgorithmEx01 {
	/* origin
	 * String foundPerson(String[] people) {
		for (int i = 0; i < people.length; i++) {
			if(people[i].equals("Don")) {
				return "Don";
			}
			if(people[i].equals("John")) {
				return "John";
			}
			if(people[i].equals("Kent")) {
				return "Kent";
			}
		}
		
		return " ";
	}*/

	String foundPerson(String[] people) {
		List<String> candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
		for (String str : people) {
			if(candidates.contains(str)) {
				return str;
			}
		}
		
		return " ";
	}
}
