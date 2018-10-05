package me.exam.ch05;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplierInterfaceExample {
	public static void main(String[] args) {
		final Supplier<String> helloSupplier = () -> "Hello ";
		
		System.out.println(helloSupplier.get() + "world");
		
		long start = System.currentTimeMillis();
		//9초걸림
		/*printIfValidIndex(0, getVeryExpensiveValue());
		printIfValidIndex(-2, getVeryExpensiveValue());
		printIfValidIndex(-1, getVeryExpensiveValue());*/
		
		//3초걸림
		//Supplier 를 통해 걸리지 않는경우 함수자체를 통과하지 않음 -> CPU, Memory, 시간등을 아낄수 있음
		printIfValidIndex(0, () -> getVeryExpensiveValue());
		printIfValidIndex(-2, () -> getVeryExpensiveValue());
		printIfValidIndex(-1, () -> getVeryExpensiveValue());
		System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000));
	}
	
	private static String getVeryExpensiveValue() {
		//Let`s just say it has very expensive calculation here!
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Won";
	}
	
	//private static void printIfValidIndex(int number, String value) {
	private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
		if(number >= 0) {
			System.out.println("The value is " + valueSupplier.get() + ".");
		}else {
			System.out.println("Invalid");
		}
	}
}
