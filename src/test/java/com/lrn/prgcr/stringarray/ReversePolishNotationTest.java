package com.lrn.prgcr.stringarray;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReversePolishNotationTest {

	ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

	@Test
	public void testEvaluate() {
		String[] array1 = { "2", "1", "+", "3", "*" };
		assertTrue(reversePolishNotation.evaluate(array1) == 9);
		String[] array2 = { "4", "13", "5", "/", "+" };
		assertTrue(reversePolishNotation.evaluate(array2) == 6);
	}

}
