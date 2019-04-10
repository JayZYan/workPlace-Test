package LC;

public class LC0072 {
    private static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int lenWord1 = word1.length();
        int lenWord2 = word2.length();
        if (word1.isEmpty()) {
            return lenWord2;
        }
        if (word2.isEmpty()) {
            return lenWord1;
        }

        int[][] dp = new int[lenWord1 + 1][lenWord2 + 1];

        for (int i = 1; i <= lenWord1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= lenWord2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= lenWord1; i++) {
            for (int j = 1; j <= lenWord2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[lenWord1][lenWord2];
    }
    public static void main(String[] args) {
        String word1 = "abef";
        String word2 = "abcdef";

        System.out.println(minDistance(word1, word2));

    }
}
