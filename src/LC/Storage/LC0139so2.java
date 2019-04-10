package LC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC0139so2 {
    private static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int end = 0; end < i ; end++) {
                if (dp[end] && wordSet.contains(s.substring(end, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");
        System.out.println(wordBreak(s, wordDict));
    }
}
