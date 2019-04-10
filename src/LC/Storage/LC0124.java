package LC;

import LC.LCPkg.TreeDrawer;
import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;

public class LC0124 {
    private static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }
//    private static int maxPathSum(TreeNode root) {
//        if (root == null) {
//            return Integer.MIN_VALUE;
//        }
//        int left = maxPathSum(root.left);
//        int right = maxPathSum(root.right);
//        if (left == Integer.MIN_VALUE && right == Integer.MIN_VALUE) {
//            return root.val;
//        }
//        if (left != Integer.MIN_VALUE && right == Integer.MIN_VALUE) {
//            return left + root.val;
//        }
//        return Math.max(left, right) + root.val;
//    }
//    private static int maxPathSum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = maxPathSum(root.left);
//        int right = maxPathSum(root.right);
//
//        return Math.max(0, Math.max(left, right)) + root.val;
//    }
    private static int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSum(root.left, max));
        int right = Math.max(0, maxPathSum(root.right, max));
        max[0] = Math.max(max[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
    public static void main(String[] args) {
        String rootString = "7,8,9,-15,10,13,#,11,14,7,3,#,-8";
        TreeNode root = TreeGenerator.deserialize(rootString);
        int result = maxPathSum(root);
        System.out.println(result);
    }
}
