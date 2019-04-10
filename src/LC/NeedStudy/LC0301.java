package LC;

import java.util.*;

public class LC0301 {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), s, 0, 0, 0, 0);
        return res;
    }
    private static void dfs(List<String> res, StringBuilder path, String s, int idx, int rmL, int rmR, int delta){
        if (idx == s.length() && rmL == 0 && rmR == 0 && delta == 0){
            res.add(path.toString());
            return;
        }
        if (idx >= s.length() || delta < 0 || rmL < 0 || rmR < 0){
            return;
        }
        char ch = s.charAt(idx);

        if (ch == '('){
            int len = path.length();
            // Delete
            dfs(res, path, s, idx + 1, rmL - 1, rmR, delta);
            // Keep
            path.append(ch);
            dfs(res, path, s, idx + 1, rmL, rmR, delta + 1);
            path.setLength(len);
        } else if (ch == ')'){
            int len = path.length();
            //Delete
            dfs(res, path, s, idx + 1, rmL, rmR - 1, delta);
            // Keep
            path.append(ch);
            dfs(res, path, s, idx + 1, rmL, rmR, delta - 1);
            path.setLength(len);
        } else {
            int len = path.length();
            path.append(ch);
            dfs(res, path, s, idx + 1, rmL, rmR, delta);
            path.setLength(len);
        }

        for (char cha : s.toCharArray()){
            if (cha == '('){
                rmL++;
            } else {
                if(rmL > 0){
                    rmL--;
                } else if (rmL == 0){
                    rmR++;
                }
            }
        }
    }

    public static void main(String[] args){
        String s = "()())()";
        System.out.println(removeInvalidParentheses(s));
    }
}
