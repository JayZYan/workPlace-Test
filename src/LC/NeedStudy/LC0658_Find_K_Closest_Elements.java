package LC;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC0658_Find_K_Closest_Elements {
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left + 1 <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int closestIdx = (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right);
        int count = 1;
        left = closestIdx - 1;
        right = closestIdx + 1;
        while(count < k){
            if (left < 0) {
                right++;
            } else if (right > arr.length - 1) {
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
            count++;
        }
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;

    }
}
