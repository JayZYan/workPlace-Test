package Platform.Storage;

import LC.LCPkg.ArrayPrinter;

public class MatrixRotate {
    private static void matrixRotate(int[][] matrix, int offset, int size) {
        if (size == 0 || size == 1) {
            return;
        }
        int temp;
        for (int i = 0; i < size - 1; i++) {
            temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[offset + size - 1 - i][offset];
            matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1][offset + size - 1  - i];
            matrix[offset + size - 1][offset + size - 1  - i] = matrix[offset + i][offset + size - 1];
            matrix[offset + i][offset + size - 1] = temp;

        }
        matrixRotate(matrix, offset + 1, size - 2);
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayPrinter.print(matrix);
        matrixRotate(matrix, 0, 4);
        ArrayPrinter.print(matrix);
    }
}
