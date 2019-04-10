package LC;

import java.util.ArrayList;
import java.util.List;

public class LC0300_Longest_Increasing_SubSequence {
    private static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        int k = 0;
        for (int num : nums) {
            if (num >= list.get(k)) {
                list.add(num);
                k++;
            } else {
                int smaller = findClosestSmallerBS(list, num);
                if (list.get(smaller) == num){
                    continue;
                }
                list.set(smaller + 1, num);
            }
        }
        return k;
    }
    private static int findClosestSmallerBS(List<Integer> list, int value) {
        int len = list.size();
        int left = 0;
        int right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == value) {
                return mid;
            }
            if (list.get(mid) < value) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int result = lengthOfLIS(nums);
        System.out.println(result);
    }
}
