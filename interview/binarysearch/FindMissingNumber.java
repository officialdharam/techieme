package com.amazon.sets._238;

/**
 * Find the missing number in an increasing sequence of numbers.
 * 
 * <pre>
 * Input: 
 * 1)	Its an increasing sequence (1 .. n) stored in an array A
 * 2)	One number is missing
 * 
 * Output:
 * The missing number
 * 
 * Idea:
 * As it is a sorted array from 1..n, in an ideal scenario, when no number is missing, then the element at 
 * index i must be the number i. Let us say that the index i divides the array in two parts LEFT and RIGHT. 
 * When we examine the number at index i, the below two cases can happen:
 * 1)	The number A[i] > i, this means the missing number is in the LEFT part.
 * 2) 	The number A[i] == i, this means the missing number is in the RIGHT part.
 * 
 * Now we have eliminated a significant part (at best half the array). Now try searching in the next half 
 * in a similar way. The idea behind this is a Binary Search. The range will shrink till only one index is 
 * left for evaluation and the number at that index would be one less than the missing number.
 * </pre>
 * 
 * @author dprasad
 */
public class FindMissingNumber {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		System.out.println(findMissingNumber(A));

	}

	public static int findMissingNumber(int[] A) {
		int start = 0, end = A.length - 1, mid = (start + end) / 2;
		while (end - start > 1) {
			if (A[mid] > mid + 1) {
				end = mid;
			} else {
				start = mid;
			}
			mid = (start + end) / 2;
		}
		return A[mid] + 1;
	}
}
