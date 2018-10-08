package me.book.ch06;

public class ReplaceMethodWithMethodObjectEx01 {
	int delta() {
		return 0;
	}
	
	/*origin
	 * int gamma (int inputVal, int quantity, int yearToDate) {
		int importantValue1 = (inputVal * quantity) + delta();
		int importantValue2 = (inputVal * yearToDate) + 100;
		if ((yearToDate - importantValue1) > 100) {
			importantValue2 -= 20;
		}
		
		int importantValue3 = importantValue2 * 7;
		//기타 등등
		return importantValue3 -2 * importantValue1;
	}*/
	
	int gamma (int inputVal, int quantity, int yearToDate) {
		return new Gamma(this, inputVal, quantity, yearToDate).compute();
	}
}

class Gamma {
	private final ReplaceMethodWithMethodObjectEx01 _account;
	private int inputVal;
	private int quantity;
	private int yearToDate;
	public Gamma(ReplaceMethodWithMethodObjectEx01 _account, int inputVal, int quantity, int yearToDate) {
		super();
		this._account = _account;
		this.inputVal = inputVal;
		this.quantity = quantity;
		this.yearToDate = yearToDate;
	}
	
	int compute () {
		int importantValue1 = (inputVal * quantity) + _account.delta();
		int importantValue2 = (inputVal * yearToDate) + 100;
		importantValue2 = importantThing(importantValue1, importantValue2);
		
		int importantValue3 = importantValue2 * 7;
		//기타 등등
		return importantValue3 -2 * importantValue1;
	}

	private int importantThing(int importantValue1, int importantValue2) {
		if ((yearToDate - importantValue1) > 100) {
			importantValue2 -= 20;
		}
		return importantValue2;
	}
}