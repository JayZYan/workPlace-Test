package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinsSum {

    public static List<int[]> coinSum(int[] coins, int target) {
        List<int[]> res = new ArrayList<>();
        dfs(coins, 0, target, new int[coins.length], res);
        return res;

    }
    private static void dfs(int[] coins, int level, int left_balance, int[] sol, List<int[]> res) {
        if (level == coins.length - 1) {
            //if (left_balance == 0) {
                sol[level] = left_balance;
                res.add(sol.clone());
            //}
            return;
        }

        int num = left_balance / coins[level] + 1;
        for (int i = 0; i < num; i++) {
            if (left_balance < 0) {
                break;
            }
            sol[level] = i;
            dfs(coins, level + 1, left_balance - coins[level] * i, sol, res);
            sol[level] = 0;
        }

    }
    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        int target = 100;

        List<int[]> ret = coinSum(coins, target);
        for (int[] path : ret) {
            System.out.println(Arrays.toString(path));
        }
    }




}
