package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0051 {
    private static List<int[]> solveNQueens(int n) {
        int[][] matrix = new int[n][n];
        int[] sol = new int[n];
        List<int[]> result = new ArrayList<>();
        dfs(0, sol, matrix, result);
        return result;
    }

    private static void dfs(int level, int[] sol, int[][] matrix, List<int[]> result) {
        if (level == matrix.length) {
            result.add(sol.clone());
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (isValid(sol, level, i)) {
                sol[level] = i;
                dfs(level + 1, sol, matrix, result);
                sol[level] = 0;
            }
        }
    }
    private static boolean isValid(int[] sol, int level, int i) {

    }
    public static void main(String[] args) {
        List<int[]> result = solveNQueens(8);
        for (int[] sol : result) {
            System.out.println(sol.toString());
        }

    }
}
