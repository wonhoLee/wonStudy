package me;

import me.chap07.ExeTimeCalculator;
import me.chap07.ImpeCalculator;
import me.chap07.ReCalculator;

public class MainProxy {
	public static void main(String[] args) {
		ExeTimeCalculator ttCall1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ttCall1.factorial(20));
		
		ExeTimeCalculator ttCall2 = new ExeTimeCalculator(new ReCalculator());
		System.out.println(ttCall2.factorial(20));
	}
}
