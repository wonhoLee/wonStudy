package me.exam.ch03;

import java.util.function.Consumer;

public class ConsumerInterfaceExample {
	public static void main(String[] args) {
		/*final Consumer<String>  print = new Consumer<>() {
			@Override
			public void accept(String arg0) {
				System.out.println(arg0);
			}
		};*/
		
		final Consumer<String>  print = arg0 -> System.out.println(arg0);
		
		print.accept("Hello");
	}
}
