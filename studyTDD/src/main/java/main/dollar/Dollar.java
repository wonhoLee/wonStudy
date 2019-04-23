package main.dollar;

public class Dollar {
	private int amount = 0;
	
	public Dollar(int amount){
		this.amount = amount; 
	}
	public Dollar times(int multiplier) {
		return new Dollar(this.amount * multiplier);
	}
	public boolean equals(Object object) {
		Dollar dollar = (Dollar) object;
		return this.amount == dollar.amount;
	}
}
