package com.interview.string;


public class BoyreMoore {

	public static void main(String[] args) {
		String T = "SSIMPEE EXAMPLE";
		String P = "EXAMPL";
		BoyreMoore bm = new BoyreMoore();
		int[] lookUpTable = bm.lookUpTable(P);
		int findPattern = bm.findPattern(T, P, lookUpTable);
		System.out.println(findPattern);
	}

	private int findPattern(String T, String P, int[] lookUpTable) {
		int n = T.length();
		int m = P.length();

		int i = m - 1;
		if (i > n - 1)
			return -1;

		int j = m - 1;
		do {
			if (P.charAt(j) == T.charAt(i)) {
				if (j == 0)
					return i;
				else {
					i--;
					j--;
				}
			} else {
				if(lookUpTable[T.charAt(i)] == -1 || j < lookUpTable[T.charAt(i)])
					i = i + m;
				else
					i += j - lookUpTable[T.charAt(i)] ;
				j = m - 1;

			}
		} while (i <= n - 1);

		return -1;
	}

	private int[] lookUpTable(String P) {
		int[] last = new int[255];
		for (int i = 0; i < 255; i++) {
			last[i] = -1;
		}

		for (int i = 0; i < P.length(); i++) {
			last[P.charAt(i)] = i;
		}
		return last;
	}
}
