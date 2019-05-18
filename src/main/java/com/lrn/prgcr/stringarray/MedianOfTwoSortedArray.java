package com.lrn.prgcr.stringarray;

public class MedianOfTwoSortedArray {

	public int findMedian(final int array1[], final int array2[]) {
		assert (array1 == null) || (array2 == null) : "array1 or array2 is null";
		assert array1.length != array2.length : "array1 and array2 are not equal in length";
		int m1 = -1, m2 = -1;
		int index1 = 0, index2 = 0;
		for (int cnt = 0; cnt <= array1.length; cnt++) {
			/* if all the elements in array1 are smaller then array2 */
			if (index1 == array1.length) {
				m1 = m2;
				m2 = array2[0];
				break;
			}
			/* if all the elements in array1 are smaller then array2 */
			if (index2 == array2.length) {
				m1 = m2;
				m2 = array1[0];
				break;
			}
			if (array1[index1] < array2[index2]) {
				m1 = m2;
				m2 = array1[index1];
				index1++;
			} else {
				m1 = m2;
				m2 = array2[index2];
				index2++;
			}
			System.out.println("m1=" + m1 + ", m2=" + m2);
		}

		return (m1 + m2) / 2;
	}

	public static void main(final String args[]) {
		MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
		int[] array1 = { 1, 12, 15, 26, 38 };
		int[] array2 = { 2, 13, 17, 30, 45 };
		System.out.println(obj.findMedian(array1, array2));
	}

}
