package me.exam.ch09;

public class ClosureExamples {
	public static void main(String[] args) {
		final int number = 100;
		
		/*final Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(number);
			}
		};
		runnable.run();
		
		final Runnable runnable2 = () -> System.out.println(number);
		runnable2.run();
		*/
		
		testClosure("Anonymous Class", new Runnable() {
			@Override
			public void run() {
				System.out.println(number);
			}
		});
		
		testClosure("Lambda Expression", () -> System.out.println(number));
	}
	
	public static void testClosure(final String name, final Runnable runnable) {
		System.out.println("=======================");
		System.out.println(name + ": ");
		runnable.run();
		System.out.println("=======================");
	}
}
