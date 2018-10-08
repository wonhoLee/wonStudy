package me.book.ch06;

import java.util.Enumeration;

public class ExtractMethodEx02 {
	/* origin
	 * void printOwing() {
		Enumeration e = _orders.elements();
		double outstanding = 0.0;
		
		// 배너(banner)표시
		System.out.println("*******************");
		System.out.println("***Customer Owes***");
		System.out.println("*******************");
		
		// outstanding 계산
		while (e.hasMoreElements()) {
			Order each = (Order)e.nextElement();
			outstanding += each.getAmount();
		}
		
		// 상세 정보 표시
		System.out.println("name : " + _name);
		System.out.println("amount : " + outstanding);
	}*/
	private String _name;
	private Order _orders;
	
	void printOwing() {
		printBanner();
		double outstanding = getoutstanding();
		printDetails(outstanding);
	}

	private double getoutstanding() {
		Enumeration e = _orders.elements();
		double result = 0.0;
		
		while (e.hasMoreElements()) {
			Order each = (Order)e.nextElement();
			result += each.getAmount();
		}
		return result;
	}

	private void printDetails(double outstanding) {
		System.out.println("name : " + _name);
		System.out.println("amount : " + outstanding);
	}

	private void printBanner() {
		System.out.println("*******************");
		System.out.println("***Customer Owes***");
		System.out.println("*******************");
	}
}