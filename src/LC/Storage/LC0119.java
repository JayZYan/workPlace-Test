package LC;

import java.util.ArrayList;
import java.util.List;

public class LC0119 {
    private static List<Integer> generate(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i <= rowIndex; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j <= i - 1; j++) {
                dp[i][j]= dp[i -1][j - 1] + dp[i - 1][j];
            }
        }

        for (int i = 0; i <= rowIndex; i++) {
            result.add(dp[rowIndex][i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int numRows = 3;
        List<Integer> result = generate(numRows);
        System.out.println(result);
    }
}
