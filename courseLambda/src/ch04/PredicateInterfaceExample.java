package ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterfaceExample {
	public static void main(String[] args) {
		Predicate<Integer> isPositive = i -> i > 0;
		
		System.out.println(isPositive.test(1));
		System.out.println(isPositive.test(0));
		System.out.println(isPositive.test(-1));
		
		List<Integer> numbers = Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5);
		List<Integer> positiveNumbers = new ArrayList<>();
		for(Integer num : numbers) {
			if(isPositive.test(num)) {
				positiveNumbers.add(num);
			}
		}
		System.out.println(positiveNumbers);
		
		Predicate<Integer> isLessThan3 = i -> i < 3;
		List<Integer> lessThan3Numbers = new ArrayList<>();
		for(Integer num : numbers) {
			if(isLessThan3.test(num)) {
				lessThan3Numbers.add(num);
			}
		}
		System.out.println(lessThan3Numbers);
		
		System.out.println(filter(numbers, i -> i > 0));	//간결
		System.out.println(filter(numbers, i -> i < 3));
		
		System.out.println(filter(numbers, isPositive));	//명시적
		System.out.println(filter(numbers, isLessThan3));
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<T> filter){
		List<T> result = new ArrayList<>();
		for(T input : list) {
			if(filter.test(input)) {
				result.add(input);
			}
		}
		return result;
	}
}
