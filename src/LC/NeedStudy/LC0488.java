package LC;

import java.util.HashMap;

public class LC0488 {

    private static int findMinStep(String board, String hand) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
            return dfs(board, map);
    }
    private static int dfs(String board, HashMap<Character, Integer> map){
        if (board.isEmpty()){
            return 0;
        }
        if (map.isEmpty()){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int idx = 0 ; idx < board.length(); idx++){
            char ch = board.charAt(idx);
            Integer cnt = map.get(ch);
            if (cnt == null){
                continue;
            }
            if (idx < board.length() - 1 && ch == board.charAt(idx + 1)){
                // One ball
                String newBoard = generateNewBoard(board, idx - 1, idx + 2);
                if (cnt == 1){
                    map.remove(ch);
                } else {
                    map.put(ch, cnt - 1);
                }
                int res = dfs(newBoard, map);
                if (res != -1){
                    min = Math.min(min, res + 1);
                }
                map.put(ch, cnt);
            } else if (cnt >= 2){
                // Two balls
                String newBoard = generateNewBoard(board, idx - 1, idx + 1);
                if (cnt == 2){
                    map.remove(ch);
                } else {
                    map.put(ch, cnt - 2);
                }
                int res = dfs(newBoard, map);
                if (res != -1){
                    min = Math.min(min, res + 2);
                }
                map.put(ch, cnt);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private static String generateNewBoard(String board, int left, int right){
        int len = board.length();

        while (left >= 0 && right < len){
            int i = left;
            int j = right;
            int cnt = 0;
            char ch = board.charAt(left);
            while (i >= 0 && ch == board.charAt(i)){
                i--;
                cnt++;
            }
            while (j < len && ch == board.charAt(j)){
                j++;
                cnt++;
            }
            if (cnt >= 3){
                left = i;
                right = j;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= left; i++){
            sb.append(board.charAt(i));
        }
        for (int i = right; i < len; i++){
            sb.append(board.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String board = "WRRBBW";
        String hand = "RB";

        System.out.println(findMinStep(board, hand));
    }
}
