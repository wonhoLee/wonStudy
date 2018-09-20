package refactoring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import refactoring.NumberTest;

class NumberTestTest {

	@Test
	void testNTest() {
		NumberTest numberTest = new NumberTest();
		assertEquals(1, numberTest.nTest(1));
	}

}
