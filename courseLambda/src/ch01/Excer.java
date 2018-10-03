package ch01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Excer {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		final StringBuilder stringBuilder = new StringBuilder();
		
		/*for (int i = 0; i < list.size(); i++) {
			stringBuilder.append(list.get(i)).append(" : ");
		}*/
		
		for(Integer number : list) {
			stringBuilder.append(number).append(" : ");
		}
		stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
		System.out.println(stringBuilder);
		
		
		final String sTemp = list.stream().map(String::valueOf).collect(Collectors.joining(" : "));
		
		System.out.println(sTemp);
	}

}
