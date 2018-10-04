package ch01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorServiceTest2 {
	@Test
	public void testCalculateAddition() throws Exception{
		Calculation2 calculation = new Addition();
		final int actual = calculation.calculate(1, 1);
		assertEquals(actual, 2);
	}

	@Test
	public void testCalculateSubtracion() throws Exception{
		Calculation2 calculation = new Subtraction();
		final int actual = calculation.calculate(1, 1);
		assertEquals(actual, 0);
	}
	
	@Test
	public void testCalculateMultiple() throws Exception{
		Calculation2 calculation = new Multiplication();
		final int actual = calculation.calculate(1, 2);
		assertEquals(actual, 2);
	}
	
	@Test
	public void testCalculateDivide() throws Exception{
		Calculation2 calculation = new Division();
		final int actual = calculation.calculate(8, 2);
		assertEquals(actual, 4);
	}
}
