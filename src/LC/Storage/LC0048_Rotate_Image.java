package LC;

import LC.LCPkg.ArrayPrinter;

public class LC0048_Rotate_Image {
    public static void rotate(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
                return;
            }
            rotate90(matrix, 0, matrix.length);

    }
    public static void rotate90(int[][] matrix, int offset, int size) {
        if (size <= 1) {
                return;
        }
        int temp;
        for (int i = 0 ; i < size - 1; i++) {
            temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[offset + size - 1 - i][offset];
            matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1][offset + size - 1 - i];
            matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + i][offset + size - 1];
            matrix[offset + i][offset + size - 1]= temp;
        }
        rotate90(matrix, offset + 1, size - 2);
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] matrix = {{3},{2}};
        int[][] matrix4 = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayPrinter.print(matrix4);

        rotate(matrix4);
        ArrayPrinter.print(matrix4);

    }
}

