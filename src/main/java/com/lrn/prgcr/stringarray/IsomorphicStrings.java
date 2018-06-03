package com.lrn.prgcr.stringarray;

import java.util.Arrays;

public class IsomorphicStrings {

	public boolean isIsomorphic(final String x, final String y) {
		int[] array1 = new int[256];
		int[] array2 = new int[256];
		Arrays.fill(array1, -1);
		Arrays.fill(array2, -1);

		if (x.length() != y.length()) {
			return false;
		}

		for (int cnt = 1; cnt < x.length(); cnt++) {
			if (array1[x.charAt(cnt)] != array2[y.charAt(cnt)]) {
				return false;
			}
			array1[x.charAt(cnt)] = cnt;
			array2[y.charAt(cnt)] = cnt;
		}
		return true;
	}

}
