package LC;

import LC.LCPkg.ArrayPrinter;

public class LC0064 {
    private static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }


        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        ArrayPrinter.print(arr);
        System.out.println(minPathSum(arr));
    }
}
