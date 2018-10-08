package me.book.ch06;

public class InlineMethodEx01 {
	int _numberOfLateDeliveries = 10;
	
	/* origin
	 * int getRaing() {
		return (moreThanFiveLateDeliveries()) ? 2: 1;
	}
	
	boolean moreThanFiveLateDeliveries() {
		return _numberOfLateDeliveries > 5;
	}*/
	
	int getRaing() {
		return (_numberOfLateDeliveries > 5) ? 2: 1;
	}
}
