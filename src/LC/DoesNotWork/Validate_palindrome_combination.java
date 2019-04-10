package LC;

import java.util.*;

public class Validate_palindrome_combination {
    private static HashSet<String> combination(String str) {
        char[] arr = str.toCharArray();
        HashSet<String> res = new HashSet<>();
        boolean[] visited = new boolean[str.length()];
        dfs(arr, res, new StringBuilder(), visited);
        return res;
    }
    private static void dfs(char[] arr, Set<String> res, StringBuilder sb, boolean[] visited) {
        if (isPalindrome(sb.toString())) {
            res.add(sb.toString());
        }
        int length = sb.length();

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            sb.append(arr[i]);
            visited[i] = true;

            dfs(arr, res, sb, visited);

            sb.setLength(length);
            visited[i] = false;
        }
    }
    public static boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
    class TrieNode {
        public char ch;
        public boolean isLeaf;
        public TrieNode[] children;

        public TrieNode(char ch) {
            this.ch = ch;
            this.isLeaf = false;
            children = new TrieNode[256];
        }
    }
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode('\0');
        }
        public void addWord(String word) {
            TrieNode cur = root;
            for (char ch : )
        }
    }

    public static void main(String[] args) {
        String str = "abb";
        Set<String> res = combination(str);
        Arrays.sort();
        Collections.sort();
        Queue<String> q = new LinkedList<>();

        Stack<System> s =;
        ArrayList




        int[] arr = new int[5];

        int len = arr.length;






        List<String> str111 = new ArrayList<>();










        for (Object s : res.toArray()) {
            System.out.println(s);
        }
        Set<Integer> treeSet = new TreeSet<>();

    }
}
