package LC;

import java.util.ArrayList;
import java.util.List;

public class LC0118 {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j <= i - 1; j++) {
                dp[i][j]= dp[i -1][j - 1] + dp[i - 1][j];
            }
        }

        int levelCounter = 0;

        while (levelCounter < numRows) {
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i <= levelCounter; i++) {
                path.add(dp[levelCounter][i]);
            }
            result.add( new ArrayList<>(path));
            levelCounter++;
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
