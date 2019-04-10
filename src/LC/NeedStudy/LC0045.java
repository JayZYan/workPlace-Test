package LC;

public class LC0045 {
    public static int jump(int[] nums) {
//        if (nums.length == 1) {
//            return 0;
//        }
//        if (nums.length == 2) {
//                return 1;
//        }
//
//        int[] dp = new int[nums.length];
//        dp[nums.length - 1] = 0;
//        int min;
//
//        for (int i = nums.length - 2; i >= 0; i--) {
//            min = Integer.MAX_VALUE;
//            for (int j = 1; j <= nums[i]; j++) {
//                if (i + j < nums.length) {
//                    min = Math.min(min, dp[i + j]);
//                }
//            }
//            if (min == Integer.MAX_VALUE) {
//                dp[i] = Integer.MAX_VALUE;
//            } else {
//                dp[i] = min + 1;
//            }
//        }
//        return dp[0];
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int result = 0;
        int preMax = 0;
        int curMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (curMax >= nums.length - 1) {
                return result + 1;
            }
            if (i > preMax) {
                preMax = curMax;
                result++;
            }
            curMax = Math.max(curMax, i + nums[i]);
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {4,5,0,3,2,1,1,10,3};
        System.out.println(jump(nums));

    }
}
