package com.lrn.prgcr.stringarray;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class RotateArrayTest {
	ArrayRotation arrayRotation = new ArrayRotation();

	@Test
	public void rotateTest() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		arrayRotation.rotate(array, 3);
		assertTrue((array[0] == 5) && (array[1] == 6) && (array[2] == 7));
	}

	@Test
	public void reverseTest() {
		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(array));
		arrayRotation.reverse(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	@Test
	public void rotateWords() {
		assertTrue("blue is sky the".equals(arrayRotation.reverseWords("the sky is blue")));
	}

}
