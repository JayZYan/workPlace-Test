package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSumDuplicate {

    public int[][] sumWithSubSet(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return new int[0][];
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, sum, 0, new ArrayList<>(), res);
        return listTo2dArray(res);
    }
    private int[][] listTo2dArray(List<List<Integer>> list) {

        int[][] array = new int[list.size()][];

        for (int i = 0; i < array.length; i++) {
            array[i] = new int[list.get(i).size()];
            for (int j = 0; i < list.get(i).size(); j++){
                array[i][j] = list.get(i).get(j);
            }

        }
        return array;
    }
    private void dfs(int[] nums, int sum, int index, List<Integer> path, List<List<Integer>> res) {
        if (sum == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < nums.length; i++) {
            if (sum - nums[i] < 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            dfs(nums, sum - nums[i], i + 1, path, res);
            path.remove(path.size() - 1);

        }
    }
}
