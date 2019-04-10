package LC;

import java.util.*;

public class LC0320 {
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), word, 0, 0);
        return res;
    }

    private static void dfs(List<String> res, StringBuilder path, String s, int idx, int curCnt){
        if (idx == s.length()){
            if (curCnt > 0){
                int len = path.length();
                path.append(curCnt);
                res.add(path.toString());
                path.setLength(len);
                return;
            } else {
                res.add(path.toString());
            }
            return;
        }
        // Keep char
        int len = path.length();
        if (curCnt > 0){
            path.append(curCnt);
            //curCnt = 0;
        }
        path.append(s.charAt(idx));
        dfs(res, path, s, idx + 1, 0);
        path.setLength(len);
        // Digit
        dfs(res, path, s, idx + 1, curCnt + 1);
    }

    public static void main(String[] args){
        String word = "word";
        System.out.println(generateAbbreviations(word));
    }
}
