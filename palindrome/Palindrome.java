package com.palindrome;

import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		String str = "ACECCBA";
		int[][] dp = palindrome.dp(str.toCharArray());
		palindrome.printMatrix(dp);
		palindrome.backtrack(dp, str.toCharArray());
	}

	private void backtrack(int [][] dpTable, char[] charArray){
		char[] palindrome = new char[dpTable[0][dpTable.length - 1]];
		int index = palindrome.length - 1;
		int length = index; 
		for(int j = dpTable.length-1, i = 0 ; i < dpTable.length && j > 0 ;  ){
			if(dpTable[i][j] == 1){
				palindrome[index] = charArray[j];
				break;
			}
			else if(dpTable[i][j] == 2 + dpTable[i+1][j-1]){
				palindrome[index] = charArray[j];
				palindrome[length - index] = charArray[j];
				index--;
				i++; j--;
			}else{
				if(dpTable[i][j-1] == dpTable[i][j]){
					j--;
				}else{
					i++;
				}
			}
		}
		
		System.out.println(Arrays.toString(palindrome));
	}

	private int[][] dp(char[] charArray) {

		int[][] dpTable = new int[charArray.length][charArray.length];
		// populate the one character palindrome length
		for (int i = 0; i < charArray.length; i++) {
			dpTable[i][i] = 1;
		}

		// populate the two character palindrome length
		for (int i = 0; i < charArray.length - 1; i++) {
			if (charArray[i] == charArray[i + 1])
				dpTable[i][i + 1] = 2;
			else
				dpTable[i][i + 1] = 1;
		}

		int k = 2;
		while (k < charArray.length) {
			int i = 0, j = k;
			for (; j < charArray.length; i++, j++) {
				if (charArray[i] == charArray[j]) {
					dpTable[i][j] = 2 + dpTable[i + 1][j - 1];
				} else {
					dpTable[i][j] = Math.max(dpTable[i + 1][j], dpTable[i][j - 1]);
				}
			}
			k++;
		}

		return dpTable;
	}

	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}
}
