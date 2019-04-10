package LC;

import java.util.Arrays;

public class LC0042_Trapping_Rain_Water {
    private static int trapO1(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1,0};
        //int result = trap(heights);
        int result = trapO1(heights);
        System.out.println(result);
    }
    /*
    private static int trap(int[] height) {
        int len = height.length;
        int result = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len - 1] = height[len - 1];
        for (int idx = 1; idx <= len - 1; idx++) {
            if (height[idx] > left[idx - 1]) {
                left[idx] = height[idx];
            } else {
                left[idx] = left[idx - 1];
            }
        }
        for (int idx = len - 2; idx >= 0; idx--) {
            if (height[idx] > right[idx + 1]) {
                right[idx] = height[idx];
            } else {
                right[idx] = right[idx + 1];
            }
        }
        int[] minMax = new int[len];
        int[] resultTest = new int[len];
        for (int idx = 0; idx <= len - 1; idx++) {
            minMax[idx] = left[idx] < right[idx] ? left[idx] : right[idx];
        }
        for (int idx = 0; idx <= len - 1; idx++) {
            result += Math.min(left[idx], right[idx]) - height[idx];
            resultTest[idx] = result;
        }

        System.out.println("left        " + Arrays.toString(left));
        System.out.println("right       " + Arrays.toString(right));
        System.out.println();
        System.out.println("minMax      " +Arrays.toString(minMax));
        System.out.println("height      " + Arrays.toString(height));
        System.out.println("resultTest  " + Arrays.toString(resultTest));

        return result;
    }
    */
}
