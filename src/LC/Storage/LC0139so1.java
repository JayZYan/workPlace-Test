package LC;

import java.util.*;

public class LC0139so1 {
    private static boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet, 0);


    }
    private static boolean wordBreak(String s, Set<String > wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");
        System.out.println(wordBreak(s, wordDict));
    }

}
