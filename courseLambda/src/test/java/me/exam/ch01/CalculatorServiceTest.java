package me.exam.ch01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorServiceTest {
	@Test
	public void testCalculateAddition() throws Exception{
		CalculatorService calculatorService = new CalculatorService();
		final int actual = calculatorService.calculate('+', 1, 1);
		assertEquals(actual, 2);
	}

	@Test
	public void testCalculateSubtracion() throws Exception{
		CalculatorService calculatorService = new CalculatorService();
		final int actual = calculatorService.calculate('-', 1, 1);
		assertEquals(actual, 0);
	}
	
	@Test
	public void testCalculateMultiple() throws Exception{
		CalculatorService calculatorService = new CalculatorService();
		final int actual = calculatorService.calculate('*', 2, 1);
		assertEquals(actual, 2);
	}
	
	@Test
	public void testCalculateDivide() throws Exception{
		CalculatorService calculatorService = new CalculatorService();
		final int actual = calculatorService.calculate('/', 8, 2);
		assertEquals(actual, 4);
	}
}
