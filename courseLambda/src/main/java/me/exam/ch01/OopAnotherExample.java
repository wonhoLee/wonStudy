package me.exam.ch01;

public class OopAnotherExample {
	
	public static void main(String[] args) {
		final CalculatorService calculatorService = new CalculatorService();
		final int additionResult = calculatorService.calculate('+', 1, 1);
		System.out.println(additionResult);
		final int subtractionResult = calculatorService.calculate('-', 1, 1);
		System.out.println(subtractionResult);
		final int multipleResult = calculatorService.calculate('*', 1, 1);
		System.out.println(multipleResult);
		final int divideResult = calculatorService.calculate('/', 8, 2);
		System.out.println(divideResult);
	}
}

class CalculatorService{
	public int calculate(char calculation, int num1, int num2) {
		if(calculation == '+') {
			return num1 + num2;
		}else if(calculation == '-') {
			return num1 - num2;
		}else if(calculation == '*') {
			return num1 * num2;
		}else if(calculation == '/') {
			return num1 / num2;
		}else {
			throw new IllegalArgumentException("Unknown calculation : " + calculation);
		}
	}
}
