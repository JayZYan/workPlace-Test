package LC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC0001_TwoSum {
//    private static int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length - 1;
//        int[] result = new int[2];
//        while (left < right) {
//            int temp = nums[left] + nums[right];
//            if (temp == target) {
//                result[0] = left;
//                result[1] = right;
//                return result;
//            }
//            else if (temp < target) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return result;
//    }
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,5};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

