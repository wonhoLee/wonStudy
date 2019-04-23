package main.dollar;

public class Franc {
	private int amount = 0;
	
	public Franc(int amount){
		this.amount = amount; 
	}
	public Franc times(int multiplier) {
		return new Franc(this.amount * multiplier);
	}
	public boolean equals(Object object) {
		Franc franc = (Franc) object;
		return this.amount == franc.amount;
	}
}
