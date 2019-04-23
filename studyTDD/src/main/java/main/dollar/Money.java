package main.dollar;

public class Money {
	protected int amount;
	protected String currency;
	
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
				&& currency().equals(money.currency());
	}
	
	String currency() {
		return currency;
	}
	
	Money times(int multiplier) {
		return new Money(this.amount * multiplier, currency);
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
}
