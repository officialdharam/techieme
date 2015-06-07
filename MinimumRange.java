package com.program.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumRange {

	public static void main(String[] args) {
		MinimumRange rangeFinder = new MinimumRange();
		int[][] arrays = new int[][] { { 5, 9, 13, 7 }, { 8, 10, 11 }, { 2, 3, 6, 7 } };
		rangeFinder.findMinRange(arrays);
	}

	private void findMinRange(int[]... arrays) {
		if (arrays == null)
			return;

		int length = arrays.length;
		int[] indices = new int[length];
		int magnitude = Integer.MAX_VALUE - 1000;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Queue<Integer> Q = new PriorityQueue<Integer>();

		// add the initial values in the queue
		for (int i = 0; i < length; i++) {
			int val = arrays[i][indices[i]];
			if (val < min)
				min = val;
			if (val > max)
				max = val;
			Q.add(arrays[i][indices[i]]);
		}

		magnitude = max - min;
		int tempMin = min;
		int tempMax = max;
		int tempMagnitude = tempMax - tempMin;

		boolean exhausted = false;
		do {
			Integer minFromQueue = Q.remove();
			for (int i = 0; i < length; i++) {
				if (arrays[i][indices[i]] == minFromQueue) {
					indices[i]++;

					if (indices[i] >= arrays[i].length){
						exhausted = true;
						break;
					}
					
					Q.add(arrays[i][indices[i]]);

					if (tempMax < arrays[i][indices[i]]) {
						tempMax = arrays[i][indices[i]];
					}
					else {
						tempMin = Q.peek();
					}
					tempMagnitude = tempMax - tempMin;
					if (tempMagnitude < magnitude) {
						magnitude = tempMagnitude;
						min = tempMin;
						max = tempMax;
					}
					break;
				}
			}
		} while (!exhausted);
		System.out.println("Minimum Range is " + " " + min + " to " + max);
	}
}
