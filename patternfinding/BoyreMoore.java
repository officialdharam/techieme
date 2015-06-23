package com.interview.string;

import java.util.HashMap;
import java.util.Map;

public class BoyreMoore {

	public static void main(String[] args) {
		String T = "I LIKE TECHIEME";
		String P = "TECCH";
		BoyreMoore bm = new BoyreMoore();
		Map<Character, Integer> lookUpTable = bm.buildLookUp(P);
		int findPattern = bm.findPattern(T, P, lookUpTable);
		System.out.println(findPattern);

		System.out.println("done");
	}

	private int findPattern(String T, String P, Map<Character, Integer> lookUpTable) {
		int j = P.length() - 1;
		int i = j;
		do {
			if (T.charAt(i) == P.charAt(j)) {
				if (j == 0)
					return i;
				else {
					i--;
					j--;
				}
			} else {
				j = P.length() - 1;
				i += lookUpTable.get(T.charAt(i)) == null ? P.length() : lookUpTable.get(T.charAt(i));
			}
		} while (i < T.length() - 1);

		return -1;
	}

	private Map<Character, Integer> buildLookUp(String P) {
		Map<Character, Integer> lookUpTable = new HashMap<Character, Integer>();
		char currentChar = P.charAt(P.length() - 1);
		lookUpTable.put(currentChar, P.length());
		for (int i = P.length() - 2; i >= 0; i--) {
			currentChar = P.charAt(i);
			Integer integer = lookUpTable.get(currentChar);
			if (integer == null)
				lookUpTable.put(currentChar, P.length() - i - 1);

		}
		return lookUpTable;
	}

}
