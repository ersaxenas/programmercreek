package com.lrn.prgcr.stringarray;

import java.util.Arrays;

public class ArrayRotation {
	/*
	 * 1). Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different
	 * ways do you know to solve this problem? 2). Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters. The input string
	 * does not contain leading or trailing spaces and the words are always separated by a single space. For example, Given s = "the sky is blue", return "blue is sky the".
	 */

	public void rotate(final int[] array, final int order) {
		assert array != null : "Array is null";
		assert array.length != 0 : "Array is empty";
		assert order != 0 : "Rotation order is zero";
		int rotateBy = order;
		if (rotateBy > array.length) {
			rotateBy = rotateBy % array.length;
			System.out.println("New order " + rotateBy);
		}
		/* divide array 0 to array length - rotateBy */
		int divider = array.length - rotateBy;
		System.out.println(Arrays.toString(array));
		reverse(array, 0, divider - 1);
		System.out.println(Arrays.toString(array));
		reverse(array, divider, array.length - 1);
		System.out.println(Arrays.toString(array));
		reverse(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	public void reverse(final int[] array, int startPos, int endPos) {
		/* if array is null or have 1 element then just return */
		if ((array == null) || (array.length <= 1)) {
			return;
		}
		/* move startPos to forward direction ++ and right to reverse direction -- */
		int tmp;
		while (startPos < endPos) {
			/* swap startPos element with endPos element */
			tmp = array[startPos];
			array[startPos] = array[endPos];
			array[endPos] = tmp;
			/* increment startPos and decrement endPos */
			startPos++;
			endPos--;
		}
	}

	public void reverse(final char[] array, int startPos, int endPos) {
		/* if array is null or have 1 element then just return */
		if ((array == null) || (array.length <= 1)) {
			return;
		}
		/* move startPos to forward direction ++ and right to reverse direction -- */
		char tmp;
		while (startPos < endPos) {
			/* swap startPos element with endPos element */
			tmp = array[startPos];
			array[startPos] = array[endPos];
			array[endPos] = tmp;
			/* increment startPos and decrement endPos */
			startPos++;
			endPos--;
		}
	}

	public String reverseWords(final String line) {
		char[] charArray = line.toCharArray();
		int spacePos = 0;
		System.out.println(Arrays.toString(charArray));
		for (int cnt = 0; cnt < charArray.length; cnt++) {
			if (charArray[cnt] == ' ') {
				/* reverse array cnt to space position -1 */
				reverse(charArray, spacePos, cnt - 1);
				System.out.println(Arrays.toString(charArray));
				/* next position to start reverse */
				spacePos = cnt + 1;
			}
		}
		/* for last word */
		reverse(charArray, spacePos, charArray.length - 1);
		System.out.println(Arrays.toString(charArray));
		reverse(charArray, 0, charArray.length - 1);
		System.out.println(Arrays.toString(charArray));
		return new String(charArray);
	}

}
