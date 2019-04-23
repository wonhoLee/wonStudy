package main.dollar;

public class Dollar {
	int amount = 0;
	
	public Dollar(int amount){
		this.amount = amount; 
	}
	public Dollar times(int multiplier) {
		return new Dollar(this.amount * multiplier);
	}
}
