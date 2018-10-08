package me.book.ch06;

public class ReplaceTempWithQueryEx01 {
	private double _quantity;
	private double _itemPrice;
	
	public ReplaceTempWithQueryEx01(double _quantity, double _itemPrice) {
		super();
		this._quantity = _quantity;
		this._itemPrice = _itemPrice;
	}

	public static void main(String[] args) {
		ReplaceTempWithQueryEx01 ex1 = new ReplaceTempWithQueryEx01(2, 2000);
		ex1.example();
	}
	
	/* origin
	 * double example() {
		double basePrice = _quantity * _itemPrice;
		if(basePrice > 1000)
			return basePrice * 0.95;
		else
			return basePrice * 0.98;
	}*/
	
	double example() {
		if(basePrice() > 1000)
			return basePrice() * 0.95;
		else
			return basePrice() * 0.98;
	}

	private double basePrice() {
		return _quantity * _itemPrice;
	}
}
