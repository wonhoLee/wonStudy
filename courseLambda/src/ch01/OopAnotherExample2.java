package ch01;

public class OopAnotherExample2 {
	
	public static void main(String[] args) {
		final CalculatorService2 calculatorService = new CalculatorService2(new Addition(), new Addition());
		final int additionResult = calculatorService.calculate(1, 1);
		System.out.println(additionResult);
		final int subtractionResult = calculatorService.calculate(1, 1);
		System.out.println(subtractionResult);
	}
}

interface Calculation2{
	int calculate(int num1, int num2);
}

class Addition implements Calculation2{
	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}
}

class Subtraction implements Calculation2{
	@Override
	public int calculate(int num1, int num2) {
		return num1 - num2;
	}
}

class Multiplication implements Calculation2{
	@Override
	public int calculate(int num1, int num2) {
		return num1 * num2;
	}
}

class Division implements Calculation2{
	@Override
	public int calculate(int num1, int num2) {
		return num1 / num2;
	}
}

class CalculatorService2{
	private final Calculation2 calculation;
	private final Calculation2 calculation2;
	
	public CalculatorService2(Calculation2 calculation, Calculation2 calculation2) {
		super();
		this.calculation = calculation;
		this.calculation2 = calculation2;
	}

	public int calculate(int num1, int num2) {
		if(num1 > 10 && num2 < num1) {
			return calculation.calculate(num1, num2);
		}else {
			throw new IllegalArgumentException("Invalid input num1 : " + num1 + ", num2 : " + num2);
		}
	}
	
	public int compute(int num1, int num2) {
		if(num1 > 10 && num2 < num1) {
			return calculation2.calculate(num1, num2);
		}else {
			throw new IllegalArgumentException("Invalid input num1 : " + num1 + ", num2 : " + num2);
		}
	}
}
