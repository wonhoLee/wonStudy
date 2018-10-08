package me.book.ch06;

public class ExtractMethodEx01 {
	private String _name;
	
	public static void main(String[] args) {
		
	}
	
	void printOwing(double amount) {
		printBanner();
		printDetails(amount);
	}

	private void printDetails(double amount) {
		System.out.println("name : " + _name);
		System.out.println("amount : " + amount);
	}
	
	void printBanner() {
		
	}
}
