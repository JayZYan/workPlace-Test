package LC;

import LC.LCPkg.TreeNode;

public class LC0437 {
    private static int pathSum(TreeNode root, int sum) {

        return pathSum(root, sum);
    }

    private static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        if (sum == (left + right)){
        }
    }
}
