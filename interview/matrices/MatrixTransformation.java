package com.interview.matrix;

public class MatrixTransformation {

	public static void main(String[] args) {
		int [][] A = new int[][]{{1,1,1,1,0},{1,1,1,1,1},{0,1,1,0,1}};
		MatrixTransformation transform = new MatrixTransformation();
		transform.printMatrix(A);
		transform.rowsAndColumnsToZero(A);
		transform.printMatrix(A);
	}

	private void rowsAndColumnsToZero(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 0) {
					markRow(A, i, 2);
					markColumn(A, j, 2);
				}
			}
		}
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 2) {
					A[i][j] = 0;
				}
			}
		}
	}

	private void markRow(int[][] A, int i, int val) {
		for (int k = 0; k < A[i].length; k++)
			if (A[i][k] != 0)
				A[i][k] = val;
	}

	private void markColumn(int[][] A, int i, int val) {
		for (int k = 0; k < A.length; k++)
			if (A[k][i] != 0)
				A[k][i] = val;
	}
	
	private void printMatrix(int[][] A){
		for (int i = 0; i < A.length; i++) {
			System.out.println();
			for (int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j]);
			}
		}
		System.out.println();
	}
}
