package main.dollar;

public class Dollar {
	int amount = 0;
	
	public Dollar(int amount){
		this.amount = amount; 
	}
	public void times(int multiplier) {
		amount *= multiplier;
	}
}
