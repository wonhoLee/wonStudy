package me.book.ch07;

/*orogin 
 * public class MoveFieldEx01 {
	private MoveFieldEx01AccountType _type;
	private double _interestRate;
	
	double interestForAmount_days (double amount, int days) {
		return _interestRate * amount * days /365;
	}
}

class MoveFieldEx01AccountType{
	
}*/

public class MoveFieldEx01 {
	private MoveFieldEx01AccountType _type;
	
	double interestForAmount_days (double amount, int days) {
		return _type.get_interestRate() * amount * days /365;
	}
}

class MoveFieldEx01AccountType{
	private double _interestRate;

	public double get_interestRate() {
		return _interestRate;
	}

	public void set_interestRate(double _interestRate) {
		this._interestRate = _interestRate;
	}
	
	
}