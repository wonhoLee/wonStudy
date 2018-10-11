package me.book.ch07;

/*origin
 * public class MoveMethodEx02 {
	private MoveMethodEx02AccountType _type;
	private double _interestRate;
	
	double interestForAmount_days (double amount, int days) {
		return get_interestRate() * amount * days / 365;
	}

	public double get_interestRate() {
		return _interestRate;
	}

	public void set_interestRate(double _interestRate) {
		this._interestRate = _interestRate;
	}
	
	
	
}

class MoveMethodEx02AccountType{
	
}*/

public class MoveMethodEx02 {
	private MoveMethodEx02AccountType _type;
	
	double interestForAmount_days (double amount, int days) {
		return get_interestRate() * amount * days / 365;
	}

	public double get_interestRate() {
		return _type.get_interestRate();
	}

	public void set_interestRate(double _interestRate) {
		_type.set_interestRate(_interestRate);
	}
}

class MoveMethodEx02AccountType{
	private double _interestRate;

	public double get_interestRate() {
		return _interestRate;
	}

	public void set_interestRate(double _interestRate) {
		this._interestRate = _interestRate;
	}
	
}