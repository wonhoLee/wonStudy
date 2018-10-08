package me.book.ch06;

public class IntroduceExplainingVariableEx02 {
	private int _quantity;
	private int _itemPrice;
	
	public IntroduceExplainingVariableEx02(int _quantity, int _itemPrice) {
		super();
		this._quantity = _quantity;
		this._itemPrice = _itemPrice;
	}

	public static void main(String[] args) {
		IntroduceExplainingVariableEx02 ex02 = new IntroduceExplainingVariableEx02(5, 2000);
		ex02.price();
	}
	
	/* origin
	 * double price() {
		//price = (base price) - (quantity discount) + (shipping)
		return _quantity * _itemPrice - Math.max(0, _quantity - 500) * _itemPrice * 0.05 + Math.min(_quantity * _itemPrice * 0.1,  100.0);
	}*/
	
	/* Introduce Explaining Variable 방식
	 * double price() {
		final double basePrice = _quantity * _itemPrice;
		final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
		final double shipping = Math.min(basePrice * 0.1,  100.0);
		return basePrice - quantityDiscount + shipping;
	}*/
	
	//Extract Method(136)방식
	double price() {
		return basePrice() - quantityDiscount() + shipping();
	}

	private double shipping() {
		return Math.min(basePrice() * 0.1,  100.0);
	}

	private double quantityDiscount() {
		return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
	}

	private int basePrice() {
		return _quantity * _itemPrice;
	}
}
