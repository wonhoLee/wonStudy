package me.exam.ch01;

public class FpExample {
	
	public static void main(String[] args) {
		final FpCalculatorService fpCalculatorService = new FpCalculatorService();
		System.out.println(fpCalculatorService.calculate(new FpAddition(), 15, 12));
		System.out.println(fpCalculatorService.calculate(new FpSubtraction(), 15, 12));
		
		System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 + i2, 15, 12));
		System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 - i2, 15, 12));
		System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 * i2, 15, 12));
		System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 / i2, 15, 12));
		System.out.println(fpCalculatorService.calculate((i1, i2) -> (i1 + i2) * 2 / i2, 15, 12));
	}
}

interface FpCalculation{
	int calculate(int num1, int num2);
}

class FpAddition implements FpCalculation{
	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}
}

class FpSubtraction implements FpCalculation{
	@Override
	public int calculate(int num1, int num2) {
		return num1 - num2;
	}
}

class FpCalculatorService{
	public int calculate(FpCalculation fpCalculation, int num1, int num2) {
		if(num1 > 10 && num2 < num1) {
			return fpCalculation.calculate(num1, num2);
		}else {
			throw new IllegalArgumentException("Invalid input num1 : " + num1 + ", num2 : " + num2);
		}
	}
}
