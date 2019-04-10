package LC;

import java.util.Arrays;

public class LC0059 {
    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generateMatrix(matrix, n, 0, 1);
        return matrix;
    }

    private static void generateMatrix(int[][] matrix, int size, int offset, int count) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            matrix[offset][offset] = count;
            return;
        }
        for (int colTop = 0; colTop < size - 1; colTop++) {
            matrix[offset][offset + colTop] = count;
            count++;
        }
        for (int rowRight = 0; rowRight < size - 1; rowRight++) {
            matrix[offset + rowRight][offset + size - 1] = count;
            count++;
        }
        for (int colBottom = 0; colBottom < size - 1; colBottom++) {
            matrix[offset + size - 1][offset + size - 1 - colBottom] = count;
            count++;
        }
        for (int rowLeft = 0; rowLeft < size - 1; rowLeft++) {
            matrix[offset + size - 1 - rowLeft][offset] = count;
            count++;
        }
        generateMatrix(matrix, size - 2, offset + 1, count);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }
}
