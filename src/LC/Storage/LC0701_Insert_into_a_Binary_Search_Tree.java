package LC;

import LC.LCPkg.TreeDrawer;
import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;

public class LC0701_Insert_into_a_Binary_Search_Tree {

    /*
    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode prev = root;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                prev = cur;
                cur = cur.left;
            } else {
                prev = cur;
                cur = cur.right;
            }
        }
        if (prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }
        return root;
    }
    */

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode[] prev = {root};

        helper(root, val, prev);
        return root;
    }
    private static void helper(TreeNode cur, int val, TreeNode[] prev) {
        if (cur == null) {
            if (prev[0].val > val) {
                prev[0].left = new TreeNode(val);
            } else {
                prev[0].right = new TreeNode(val);
            }
            return;
        }
        prev[0] = cur;
        if (cur.val < val) {
            helper(cur.right, val, prev);
        } else {
            helper(cur.left, val, prev);
        }

    }
    public static void main(String[] args) {
        int val = 5;
        String data = "4,2,7,1,3";

        TreeNode root = TreeGenerator.deserialize(data);

        TreeDrawer.draw(root);
        if (root != null) {
            TreeNode result = insertIntoBST(root, val);
            TreeDrawer.draw(result);
        }
    }
}
