package main.dollar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.dollar.Dollar;

public class DollarTest {

	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		Dollar product = five.times(2);
		assertEquals(10, product.amount);
		product = five.times(3);
		assertEquals(15, product.amount);
	}

}
