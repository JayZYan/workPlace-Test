package LC;

import java.util.Arrays;

public class CoinChange2 {
    static int count = 0;
    public static int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return amount == 0 ? 1 : 0;
        }
        dfs(coins, 0, amount);
        return count;
    }
    private static void dfs(int[] coins, int level, int left_balance) {
        if (level == coins.length - 1) {
            if (left_balance % coins[level] == 0) {
                count++;
            }
            return;
        }
        int num = left_balance / coins[level] + 1;

        for (int i = 0; i < num; i++) {
            dfs(coins, level + 1, left_balance - coins[level] * i);
        }
    }
    public static void main(String[] args) {
        int[] coins = {3,5,7,8,9,10,11};
        int amount = 500;
        char[] ch = {'a', 'b'};
        //String s = Arrays.toString(ch).trim();
        String s = "        a    b b b d       ";
        System.out.println(s.trim());

        //System.out.println(change(amount, coins));
    }
}
