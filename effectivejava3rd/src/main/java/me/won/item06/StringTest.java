package me.won.item06;

public class StringTest {
	public static void main(String[] args) {
		String name = new String("won");
		String name2 = new String("won");
		System.out.println(name == name2);
		
		String name3 = "won";
		String name4 = "won";
		System.out.println(name3 == name4);
		
		Boolean true1 = Boolean.valueOf("true");
		Boolean true2 = Boolean.valueOf("true");
		
		System.out.println(true1 == true2);
	}
}
