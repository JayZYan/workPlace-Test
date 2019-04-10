package LC;

import java.util.*;

    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    [
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
    ]
    */

public class LC0022 {

    private static List<String> generateParenthesis(int n) {
        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(res, path, 0, 0, n);

        return res;
    }

    private static void dfs(List<String> res, StringBuilder path, int left, int right, int n){
        if (left == n && right == n){
            res.add(path.toString() + "\n");
            return;
        }
        if (left < right || left > n){
            return;
        }
        //left
        path.append("(");
        dfs(res, path, left + 1, right, n);
        path.setLength(path.length() - 1);
        //right
        path.append(")");
        dfs(res, path, left, right + 1, n);
        path.setLength(path.length() - 1);
    }


    public static void main (String[] args){
        int n = 10;

        System.out.println(generateParenthesis(n).toString());

    }
}
