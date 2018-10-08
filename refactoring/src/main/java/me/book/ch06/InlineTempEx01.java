package me.book.ch06;

public class InlineTempEx01 {
	private Order anOrder = new Order(10000);
	
	/* origin
	 * private boolean inlineTemp() {
		double basePrice = anOrder.getBasePrice();
		return (basePrice > 1000);
	}*/
	
	private boolean inlineTemp() {
		return (anOrder.getBasePrice() > 1000);
	}
}