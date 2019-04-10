package LC;

import LC.LCPkg.TreeNode;

import java.util.*;

public class Test {
    static class TreeNode{

    }
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        String[] s = paragraph.split("\\s");
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : s) {
            int count = map.getOrDefault(string.toLowerCase(), 0);
            map.put(string, ++count);
        }
        for (String ban : banned) {
            if (map.containsKey(ban.toLowerCase())) {
                int count = map.get(ban.toLowerCase());
                map.put(ban.toLowerCase(), -1);
            }
        }
        int maxCount = 0;
        String res = null;
        for (String str : map.keySet()) {
            if (map.get(str) > maxCount) {
                maxCount = map.get(str);
                res = str;
            }
        }
        return res;
    }
    public static boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Queue<Integer> heap = new PriorityQueue<Integer>((c1, c2) -> c2 - c1);
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')');
            }
            if (c == '(') {
                st.push('}');
            }
            else if (c == '[') {
                st.push(']');
            }
            else if (st.isEmpty() || st.pop() != c) {
                return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
