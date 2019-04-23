package main.dollar;

public abstract class Money {
	protected int amount;
	abstract Money times(int multiplier);
	
	static Money franc(int amount) {
		return new Franc(amount);
	}
	
	static Money dollar(int amount) {
		return new Dollar(amount);
	}
	
	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount
				&& getClass().equals(money.getClass());
	}
}
