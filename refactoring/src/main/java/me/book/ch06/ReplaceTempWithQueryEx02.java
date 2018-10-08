package me.book.ch06;

public class ReplaceTempWithQueryEx02 {
	private int _quantity;
	private int _itemPrice;
	
	/*origin
	 * double getPrice() {
		int basePrice = _quantity * _itemPrice;
		double discountFactor;
		if(basePrice > 1000) 
			discountFactor = 0.95;
		else
			discountFactor = 0.98;
		return basePrice * discountFactor;
	}*/
	
	double getPrice() {
		return basePrice() * dicountFactor();
	}

	private double dicountFactor() {
		return (basePrice() > 1000) ? 0.95 : 0.98 ;
	}

	private int basePrice() {
		return _quantity * _itemPrice;
	}
}
