package LC;


import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;


public class LC0270_Closest_Binary_Search_Tree_Value {
    /*
    private static TreeNode result;
    private static int closestValue(TreeNode root, double target) {
        result = root;
        helper(root, target);
        return result.val;
    }
    private static void helper(TreeNode root, double target) {

            if (root == null) {
                return;
            }
            if (root.val <= target) {
                if (Math.abs(root.val - target) < Math.abs(result.val - target)) {
                    result = root;
                }
                helper(root.right, target);
            }
            if (root.val > target) {
                if (Math.abs(root.val - target) < Math.abs(result.val - target)) {
                    result = root;
                }
                helper(root.left, target);
            }
    }
    */

    private static int closestValue(TreeNode root, double target) {
        TreeNode cur = root;
        TreeNode res = cur;

        while (cur != null) {
            if (cur.val == target) {
                return cur.val;
            }
            if (Math.abs(cur.val - target) < Math.abs(res.val - target)) {
                res = cur;
            }
            cur = cur.val > target ? cur.left : cur.right;

        }
        return res.val;
    }
    public static void main(String[] args) {
        String bst = "4,2,5,1,3";
        TreeNode root = TreeGenerator.deserialize(bst);
        double target = 3.714286;

        int result = closestValue(root, target);
        System.out.println(result);

    }
//    private static int method(TreeNode root, double target) {
//        if (root == null) {
//            throw new IllegalArgumentException("input not valid");
//        }
//        TreeNode cur = root;
//        TreeNode result = cur;
//
//        while (cur != null) {
//            if (cur.val - target <= 0.0000001) {
//                return cur.val;
//            }
//            if (Math.abs(cur.val - target) < Math.abs(result.val - target)) {
//                result = cur;
//            }
//            if (cur.val < target) {
//                cur = cur.right;
//            } else {
//                cur = cur.left;
//            }
//        }
//        return result.val;
//    }
}
