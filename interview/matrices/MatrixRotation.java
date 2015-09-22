public class MatrixRotation {
public static void main(String[] args) {
    MatrixRotation m = new MatrixRotation();
    int[][] matrix = new int[][] { { 1, 6, 11, 16, 21 }, { 2, 7, 12, 17, 22 }, { 3, 8, 13, 18, 23 }, { 4, 9, 14, 19, 24 }, { 5, 10, 15, 20, 25 } };
 
    int[][] transpose = m.transpose(matrix);
    System.out.println("Transpose of Matrix");
    m.printMatrix(transpose);
 
    matrix = new int[][] { { 1, 6, 11, 16, 21 }, { 2, 7, 12, 17, 22 }, { 3, 8, 13, 18, 23 }, { 4, 9, 14, 19, 24 }, { 5, 10, 15, 20, 25 } };
    m.horizontalReflection(matrix);
    System.out.println("Horizontal Reflection of Matrix");
    m.printMatrix(matrix);
 
    matrix = new int[][] { { 1, 6, 11, 16, 21 }, { 2, 7, 12, 17, 22 }, { 3, 8, 13, 18, 23 }, { 4, 9, 14, 19, 24 }, { 5, 10, 15, 20, 25 } };
    m.verticalReflection(matrix);
    System.out.println("Vertical Reflection of Matrix");
    m.printMatrix(matrix);
 
    matrix = new int[][] { { 1, 6, 11, 16, 21 }, { 2, 7, 12, 17, 22 }, { 3, 8, 13, 18, 23 }, { 4, 9, 14, 19, 24 }, { 5, 10, 15, 20, 25 } };
    transpose = m.transpose(matrix);
    m.horizontalReflection(transpose);
    System.out.println("90 degree rotation of Matrix");
    m.printMatrix(transpose);
 
    matrix = new int[][] { { 1, 6, 11, 16, 21 }, { 2, 7, 12, 17, 22 }, { 3, 8, 13, 18, 23 }, { 4, 9, 14, 19, 24 }, { 5, 10, 15, 20, 25 } };
    m.horizontalReflection(matrix);
    m.verticalReflection(matrix);
    System.out.println("180 degree rotation of Matrix");
    m.printMatrix(matrix);
 
    matrix = new int[][] { { 1, 6, 11, 16, 21 }, { 2, 7, 12, 17, 22 }, { 3, 8, 13, 18, 23 }, { 4, 9, 14, 19, 24 }, { 5, 10, 15, 20, 25 } };
    transpose = m.transpose(matrix);
    m.verticalReflection(transpose);
    System.out.println("270 degree rotation of Matrix");
    m.printMatrix(transpose);
}
 
/*
 * Method to get transpose of a matrix. It creates a new matrix to copy the
 * elements because the physical structure of the matrix may change as a
 * part of the transpose operation in case its not a square matrix.
 */
    public int[][] transpose(int[][] mat) {
        if (mat == null)
	    return null;
 
        int m = mat.length;
        int n = mat[0].length;
        int[][] matResult = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matResult[j][i] = mat[i][j];
            }
        }
        return matResult;
    }
 
/*
 * Method to get the horizontal reflection of the matrix.
 */
public void horizontalReflection(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int temp = 0;
    for (int i = 0; i < m / 2; i++) {
        for (int j = 0; j < n; j++) {
            temp = mat[i][j];
            mat[i][j] = mat[m - (i + 1)][j];
            mat[m - (i + 1)][j] = temp;
        }
    }
}
 
/*
 * Method to get the vertical reflection of the given matrix
 */
public void verticalReflection(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int temp = 0;
    for (int i = 0; i < n / 2; i++) {
        for (int j = 0; j < m; j++) {
            temp = mat[j][i];
            mat[j][i] = mat[j][n - (i + 1)];
            mat[j][n - (i + 1)] = temp;
        }
    }
}
 
/*
 * Utility method to print the matrix.
 */
public void printMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(mat[i][j] + "  ");
        }
        System.out.println();
    }
}
}
