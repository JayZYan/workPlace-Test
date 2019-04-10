package LC;

import LC.LCPkg.ArrayPrinter;

import java.util.*;

public class LC0054 {
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        spiralOrder(0, 0, rows, cols, matrix, result);
        return result;
    }
    private static void spiralOrder(int offsetRows, int offsetCols, int sizeRows, int sizeCols, int[][] matrix, List<Integer> result) {
        if (sizeRows == 0 || sizeCols == 0) {
            return;
        }
        if (sizeRows == 1) {    //from left -> right
            for (int colsTop = 0; colsTop < sizeCols; colsTop++) {
                result.add(matrix[offsetRows][offsetCols + colsTop]);
            }
            return;
        }
        if (sizeCols == 1) {    //from top -> bot
            for (int rowsLeft = 0; rowsLeft < sizeRows; rowsLeft++) {
                result.add(matrix[offsetRows + rowsLeft][offsetCols]);
            }
            return;
        }
        for (int colsTop = 0; colsTop < sizeCols - 1; colsTop++) {
            result.add(matrix[offsetRows][offsetCols + colsTop]);
        }
        for (int rowsRight = 0; rowsRight < sizeRows - 1; rowsRight++) {
            result.add(matrix[offsetRows + rowsRight][offsetCols + sizeCols - 1]);
        }
        for (int colsBot = 0; colsBot < sizeCols - 1; colsBot++) {
            result.add(matrix[offsetRows + sizeRows - 1][offsetCols + sizeCols - 1 - colsBot]);
        }
        for (int rowsLeft = 0; rowsLeft < sizeRows - 1; rowsLeft++) {
            result.add(matrix[offsetRows + sizeRows - 1 - rowsLeft][offsetCols]);
        }
        spiralOrder(offsetRows + 1, offsetCols + 1,
                sizeRows - 2, sizeCols - 2, matrix, result);
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] matrix = {{3},{2}};
        System.out.println(spiralOrder(matrix2));

    }
}
