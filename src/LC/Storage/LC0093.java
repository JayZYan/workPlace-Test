package LC;


import java.util.*;

public class LC0093 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        if(s == null || s.length() == 0){
            return result;
        }

        dfs(result, path, 0, s, 0);

        return result;
    }
    private static void dfs(List<String> result, StringBuilder path, int idx, String s, int part){
        if(part == 4 && idx == s.length()){
            path.setLength(path.length() - 1);
            result.add(path.toString());
            return;
        }
        if(part > 4 || idx >= s.length()){
            return;
        }
        int len = path.length();
        for(int l = 1; l <= 3; l++){
            if (idx + l > s.length()){
                break;
            }
            String subStr = s.substring(idx, idx + l);
            int val = Integer.valueOf(subStr);
            if(val < 256){
                path.append(subStr + '.');
                dfs(result, path, (idx + l - 1) + 1, s, part + 1);
                path.setLength(len);
            }
            if(val == 0){
                break;
            }
        }
    }
    public static void main(String[] args){
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
