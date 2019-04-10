package LC;

import LC.LCPkg.TreeNode;
import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeDrawer;

public class LC0236 {
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    public static void main(String[] args) {
        String rootString = "3,5,1,6,2,0,8,#,#,7,4";

        TreeNode root = TreeGenerator.deserialize(rootString);
        TreeDrawer.draw(root);
        if (root != null) {
            TreeNode p = root.left;
            TreeDrawer.draw(p);

            TreeNode q = root.right;
            TreeDrawer.draw(q);

            TreeNode result = lowestCommonAncestor(root, p, q);

            System.out.println(TreeGenerator.serialize(result));
            TreeDrawer.draw(result);
        }
    }
}
