package main.dollar;

public abstract class Money {
	protected int amount;
	protected String currency;
	abstract Money times(int multiplier);
	
	Money(int amount, String currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	static Money franc(int amount) {
		return new Franc(amount, "CHF");
	}
	
	static Money dollar(int amount) {
		return new Dollar(amount, "USD");
	}
	
	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount
				&& getClass().equals(money.getClass());
	}
	
	String currency() {
		return currency;
	}
}
