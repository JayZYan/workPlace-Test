package LC;


import java.util.*;

public class LC0282 {
    private static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        dfs(res, path, num, 0, target, 0, 0);
        return res;

    }
    private static void dfs(List<String> res, StringBuilder path, String num, int idx, int target, long curSum, long lastVal){
        int len = num.length();
        if(idx == len && curSum == target){
            res.add(path.toString());
            return;
        }
        if(idx >= len && curSum != target){
            return;
        }
        int pathLen = path.length();
        for(int i = idx + 1; i <= len; i++) {
//            if(num.charAt(idx) == '0' && i != idx+1){   //when start from 0 and look to the right, then break
//                break;
//            }
            long val = Long.parseLong(num.substring(idx, i));
            if (path.length() == 0) {     //head
                path.append(val);
                dfs(res, path, num, i, target, val, val);
                path.setLength(pathLen);
            } else {  //not head
                // +
                path.append("+").append(val);
                dfs(res, path, num, i, target, curSum + val, val);
                path.setLength(pathLen);
                // -
                path.append("-").append(val);
                dfs(res, path, num, i, target, curSum - val, -val);
                path.setLength(pathLen);
                // *
                path.append("*").append(val);
                dfs(res, path, num, i, target, curSum - lastVal + lastVal * val, lastVal * val);
                path.setLength(pathLen);



                if(val == 0){
                    dfs(res, path, num, i + 1, target, curSum, lastVal);
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        int target = 5;
        String num = "1005";
        System.out.print(addOperators(num, target));
    }
}
