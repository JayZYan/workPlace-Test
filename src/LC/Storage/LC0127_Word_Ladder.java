package LC;

import java.util.*;

public class LC0127_Word_Ladder {
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                List<String> nexts = transform(cur);
                System.out.print(nexts);
                System.out.println();
                for (String next : nexts) {
                    if (next.equals(endWord)) {
                        return minLen + 1;
                    }
                    if (dict.remove(next)) {
                        queue.offer(next);
                    }
                }
            }
            minLen++;
        }
        return 0;
    }
    private static List<String> transform(String cur) {
        int len = cur.length();
        List<String> res = new ArrayList<>();
        char[] arr = cur.toCharArray();
        //System.out.println(arr);
        for (int i = 0; i < len; i++) {
            char temp = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                res.add(new String(arr));
                arr[i] = temp;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = new ArrayList<>();

        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
        //System.out.println(ladderLength(endWord, beginWord, wordList));

    }
}
