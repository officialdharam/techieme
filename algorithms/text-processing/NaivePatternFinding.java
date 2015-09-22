package com.interview.string;

public class NaivePatternFinding {

	public static void main(String[] args) {
		NaivePatternFinding patternFinding = new NaivePatternFinding();
		System.out.println(patternFinding.findPattern("adharam", "dharam"));

	}

	public int findPattern(String T, String P) {
		int j = 0, i = 0;
		for (; j < P.length() && i < T.length();) {
			if (T.charAt(i+j) == P.charAt(j)) {
				j++;
			} else {
				j = 0;
				i++;
			}
		}
		
		if(i == T.length() && j != P.length())
			return -1;
		
		return i ;
	}
}
